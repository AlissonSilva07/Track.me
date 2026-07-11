package com.example.trackme.domain.model

import androidx.compose.ui.graphics.Color
import java.time.LocalDate
import java.time.LocalTime

data class Habit(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val color: Color,
    val icon: String,
    val createdAt: LocalDate,
    val interval: Interval,
    val startTime: LocalTime
)

enum class Interval {
    EVERYDAY,
    EVERYOTHERDAY,
    EVERYWEEK,
    EVERYMONTH
}