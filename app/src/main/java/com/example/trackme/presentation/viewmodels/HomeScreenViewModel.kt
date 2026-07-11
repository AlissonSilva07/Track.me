package com.example.trackme.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.trackme.core.getWeekDays
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import javax.inject.Inject

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val daysList: List<LocalDate> = listOf(),
    val selectedDay: LocalDate? = null
)

sealed class HomeScreenEvent {
    data class OnChangeSelectedDay(val date: LocalDate) : HomeScreenEvent()
}

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.OnChangeSelectedDay -> onChangeSelectedDay(event.date)
        }
    }

    init {
        loadDays()
    }

    private fun loadDays() {
        val weeks = getWeekDays()
        _uiState.update {
            it.copy(
                daysList = weeks,
                selectedDay = LocalDate.now()
            )
        }
    }

    private fun onChangeSelectedDay(date: LocalDate) {
        _uiState.update {
            it.copy(
                selectedDay = date
            )
        }
    }
}

