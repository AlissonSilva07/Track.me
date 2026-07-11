package com.example.trackme.core

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

fun getWeekDays(startDay: DayOfWeek = DayOfWeek.MONDAY): List<LocalDate> {
    val today = LocalDate.now()

    val startOfWeek = today.with(TemporalAdjusters.previousOrSame(startDay))

    return (0..6).map { startOfWeek.plusDays(it.toLong()) }
}