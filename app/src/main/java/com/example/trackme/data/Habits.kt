package com.example.trackme.data

import androidx.compose.ui.graphics.Color
import com.example.trackme.domain.model.Habit
import com.example.trackme.domain.model.Interval
import java.time.LocalDate
import java.time.LocalTime

object Habits {
    val emptyList = listOf<Habit>()
    val mockHabits = listOf(
        Habit(
            id = 1,
            title = "Morning Hydration",
            description = "Drink 500ml of water right after waking up.",
            color = Color(0xFF2196F3),
            icon = "\uD83D\uDCA6", // 💦
            createdAt = LocalDate.of(2026, 7, 6), // Monday
            interval = Interval.EVERYDAY,
            startTime = LocalTime.of(7, 0),
            isCompleted = true
        ),
        Habit(
            id = 2,
            title = "Gym Session",
            description = "Weight lifting and strength training.",
            color = Color(0xFFE91E63),
            icon = "\uD83C\uDFCB\uFE0F", // 🏋️
            createdAt = LocalDate.of(2026, 7, 6), // Monday
            interval = Interval.EVERYOTHERDAY,
            startTime = LocalTime.of(18, 30),
            isCompleted = false
        ),
        Habit(
            id = 3,
            title = "House Deep Clean",
            description = "Vacuum, dust, and mop the entire apartment.",
            color = Color(0xFF9C27B0),
            icon = "\uD83E\uDDF9", // 🧹
            createdAt = LocalDate.of(2026, 7, 6), // Monday
            interval = Interval.EVERYWEEK,
            startTime = LocalTime.of(10, 0),
            isCompleted = true
        ),
    )
}