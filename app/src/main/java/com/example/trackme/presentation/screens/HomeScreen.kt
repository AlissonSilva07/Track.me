package com.example.trackme.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.trackme.core.getWeekDays
import com.example.trackme.presentation.components.CalendarDayRow
import com.example.trackme.presentation.components.HomeHeader
import com.example.trackme.presentation.navigation.Screen
import com.example.trackme.presentation.ui.theme.TrackmeTheme
import com.example.trackme.presentation.viewmodels.HomeScreenEvent
import com.example.trackme.presentation.viewmodels.HomeScreenUiState
import com.example.trackme.presentation.viewmodels.HomeScreenViewModel
import java.time.LocalDate

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    backStack: SnapshotStateList<Screen>,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreenContent(
        modifier = modifier,
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: HomeScreenUiState,
    onEvent: (HomeScreenEvent) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                vertical = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HomeHeader("Alisson Rego")
        }
        item {
            CalendarDayRow(
                modifier = Modifier.fillMaxWidth(),
                daysList = state.daysList,
                selectedDay = state.selectedDay ?: LocalDate.now(),
                onChangeSelectedDay = {
                    onEvent(HomeScreenEvent.OnChangeSelectedDay(it))
                }
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    TrackmeTheme(
        dynamicColor = false
    ) {
        HomeScreenContent(
            state = HomeScreenUiState(
                daysList = getWeekDays(),
                selectedDay = LocalDate.now()
            ),
            onEvent = {}
        )
    }
}

@Preview
@Composable
fun HomeScreenPreviewDark() {
    TrackmeTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        HomeScreenContent(
            state = HomeScreenUiState(
                daysList = getWeekDays(),
                selectedDay = LocalDate.now()
            ),
            onEvent = {}
        )
    }
}