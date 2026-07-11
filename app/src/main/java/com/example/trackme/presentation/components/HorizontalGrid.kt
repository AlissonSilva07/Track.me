package com.example.trackme.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trackme.data.Habits
import com.example.trackme.domain.model.Habit
import com.example.trackme.presentation.ui.theme.TrackmeTheme

@Composable
fun HorizontalGrid(
    modifier: Modifier = Modifier,
    habitsList: List<Habit>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        modifier = Modifier.height(600.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (habitsList.isNotEmpty()) {
            items(habitsList) { item ->
                HabitCard(habit = item)
            }
        } else {
            item {
                Text("Nenhum item encontrado para este dia.")
            }
        }
    }
}

@Preview
@Composable
fun HorizontalGridPreview() {
    TrackmeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        HorizontalGrid(
            habitsList = Habits.mockHabits
        )
    }
}

@Preview
@Composable
fun HorizontalGridPreviewDark() {
    TrackmeTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        HorizontalGrid(
            habitsList = Habits.emptyList
        )
    }
}