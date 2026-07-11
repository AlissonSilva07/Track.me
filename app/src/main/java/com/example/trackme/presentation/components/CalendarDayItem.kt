package com.example.trackme.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import com.example.trackme.presentation.ui.theme.LimeGreen
import com.example.trackme.presentation.ui.theme.TrackmeTheme
import com.example.trackme.presentation.ui.theme.VibrantBlue
import com.example.trackme.presentation.ui.theme.primary
import java.time.LocalDate

enum class CalendarDayItemType {
    PAST,
    CURRENT,
    FUTURE
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarDayItem(
    date: LocalDate = LocalDate.now(),
    dayNumber: String = "1",
    dayAbbreviation: String = "Seg",
    type: CalendarDayItemType = CalendarDayItemType.CURRENT,
    onClick: (LocalDate) -> Unit = {}
) {
    val cardContainerolor = when(type) {
        CalendarDayItemType.PAST -> LimeGreen
        CalendarDayItemType.CURRENT -> VibrantBlue
        CalendarDayItemType.FUTURE -> MaterialTheme.colorScheme.surface
    }

    val cardContentColor = when(type) {
        CalendarDayItemType.PAST -> Color.Black
        CalendarDayItemType.CURRENT -> Color.White
        CalendarDayItemType.FUTURE -> MaterialTheme.colorScheme.onBackground
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardContainerolor,
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
                fontFamily = BricolageGrotesqueFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CalendarDayItemPreview() {
    TrackmeTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalendarDayItem(type = CalendarDayItemType.PAST)
            CalendarDayItem(type = CalendarDayItemType.CURRENT)
            CalendarDayItem(type = CalendarDayItemType.FUTURE)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CalendarDayItemPreviewDark() {
    TrackmeTheme(
        darkTheme = true
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CalendarDayItem(type = CalendarDayItemType.PAST)
            CalendarDayItem(type = CalendarDayItemType.CURRENT)
            CalendarDayItem(type = CalendarDayItemType.FUTURE)
        }
    }
}