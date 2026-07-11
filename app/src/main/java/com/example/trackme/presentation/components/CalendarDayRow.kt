package com.example.trackme.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trackme.core.getWeekDays
import com.example.trackme.presentation.ui.theme.TrackmeTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

data class CalendarDayData(
    val date: LocalDate,
    val number: String,
    val abbreviation: String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarDayRow(
    modifier: Modifier = Modifier,
    daysList: List<LocalDate>,
    selectedDay: LocalDate,
    onChangeSelectedDay: (LocalDate) -> Unit = {}
) {
    val brLocale: Locale = Locale.forLanguageTag("pt-BR")

    val formatterNum = DateTimeFormatter.ofPattern("d", brLocale)
    val formatterAbbrev = DateTimeFormatter.ofPattern("E", brLocale)

    val list = daysList.map {
        CalendarDayData(
            date = it,
            number = it.format(formatterNum),
            abbreviation = it.format(formatterAbbrev)
        )
    }

    val today = LocalDate.now()

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Box(Modifier.width(8.dp))
        }
        items(list) { item ->
            val type = when {
                item.date.isBefore(today) -> CalendarDayItemType.PAST
                item.date.isAfter(today) -> CalendarDayItemType.FUTURE
                item.date == selectedDay -> CalendarDayItemType.CURRENT
                else -> CalendarDayItemType.CURRENT
            }

            CalendarDayItem(
                date = item.date,
                dayNumber = item.number,
                dayAbbreviation = item.abbreviation,
                type = type,
                onClick = onChangeSelectedDay
            )
        }
        item {
            Box(Modifier.width(8.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CalendarDayRowPreview() {
    TrackmeTheme {
        CalendarDayRow(
            daysList = getWeekDays(),
            selectedDay = LocalDate.now()
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CalendarDayRowPreviewDark() {
    TrackmeTheme(
        darkTheme = true
    ) {
        CalendarDayRow(
            daysList = getWeekDays(),
            selectedDay = LocalDate.now()
        )
    }
}