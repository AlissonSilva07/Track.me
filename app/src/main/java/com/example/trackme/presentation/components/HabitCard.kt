package com.example.trackme.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackme.data.Habits
import com.example.trackme.domain.model.Habit
import com.example.trackme.presentation.ui.theme.BricolageGrotesqueFontFamily
import com.example.trackme.presentation.ui.theme.TrackmeTheme

@Composable
fun HabitCard(
    modifier: Modifier = Modifier,
    habit: Habit,
    onCompleted: (Int) -> Unit = {}
) {
    Card(
        modifier = modifier.width(240.dp),
        colors = CardDefaults.cardColors(
            containerColor = habit.color
        ),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(habit.icon)
                Spacer(Modifier.weight(1f))
                Checkbox(
                    checked = habit.isCompleted,
                    onCheckedChange = { onCompleted(habit.id) }
                )
            }
            Spacer(Modifier.height(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = habit.title,
                    fontFamily = BricolageGrotesqueFontFamily,
                    fontSize = 16.sp
                )
                Text(
                    text = habit.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }
}

@Preview
@Composable
fun HabitCardPreview() {
    TrackmeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        HabitCard(
            habit = Habits.mockHabits.first()
        )
    }
}

@Preview
@Composable
fun HabitCardPreviewDark() {
    TrackmeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        HabitCard(
            habit = Habits.mockHabits.first()
        )
    }
}