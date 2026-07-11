package com.example.trackme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackme.presentation.ui.theme.BricolageGrotesqueFontFamily
import com.example.trackme.presentation.ui.theme.GoogleSansFontFamily
import com.example.trackme.presentation.ui.theme.LimeGreen
import com.example.trackme.presentation.ui.theme.TrackmeTheme
import com.example.trackme.presentation.ui.theme.VibrantBlue
import java.time.LocalDate

enum class CalendarDayItemType {
    PAST,
    TODAY,
    SELECTED,
    FUTURE
}

@Composable
fun CalendarDayItem(
    date: LocalDate = LocalDate.now(),
    dayNumber: String = "1",
    dayAbbreviation: String = "Seg",
    type: CalendarDayItemType = CalendarDayItemType.TODAY,
    onClick: (LocalDate) -> Unit = {}
) {
    val cardContainerColor = when (type) {
        CalendarDayItemType.PAST -> LimeGreen
        CalendarDayItemType.TODAY -> VibrantBlue
        CalendarDayItemType.SELECTED -> MaterialTheme.colorScheme.primary
        CalendarDayItemType.FUTURE -> MaterialTheme.colorScheme.surface
    }

    val cardContentColor = when (type) {
        CalendarDayItemType.PAST -> Color.Black
        CalendarDayItemType.TODAY -> Color.White
        CalendarDayItemType.SELECTED -> MaterialTheme.colorScheme.onPrimary
        CalendarDayItemType.FUTURE -> MaterialTheme.colorScheme.onBackground
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardContainerColor,
            contentColor = cardContentColor
        ),
        onClick = {
            onClick(date)
        },
    ) {
        Column(
            modifier = Modifier
                .widthIn(min = 60.dp)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = dayNumber,
                fontFamily = BricolageGrotesqueFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = dayAbbreviation,
                fontFamily = GoogleSansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun CalendarDayItemPreview() {
    TrackmeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalendarDayItem(type = CalendarDayItemType.PAST)
            CalendarDayItem(type = CalendarDayItemType.TODAY)
            CalendarDayItem(type = CalendarDayItemType.FUTURE)
        }
    }
}

@Preview
@Composable
fun CalendarDayItemPreviewDark() {
    TrackmeTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalendarDayItem(type = CalendarDayItemType.PAST)
            CalendarDayItem(type = CalendarDayItemType.TODAY)
            CalendarDayItem(type = CalendarDayItemType.FUTURE)
        }
    }
}