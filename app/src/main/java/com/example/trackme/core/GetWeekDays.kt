package com.example.trackme.core

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

@RequiresApi(Build.VERSION_CODES.O)
fun getWeekDays(startDay: DayOfWeek = DayOfWeek.MONDAY): List<LocalDate> {
    val today = LocalDate.now()

    val startOfWeek = today.with(TemporalAdjusters.previousOrSame(startDay))

    return (0..6).map { startOfWeek.plusDays(it.toLong()) }
}