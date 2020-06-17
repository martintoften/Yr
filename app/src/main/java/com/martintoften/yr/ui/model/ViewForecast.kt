package com.martintoften.yr.ui.model

import java.util.Date

data class ViewForecast(
    val day: Int,
    val intervals: List<ViewInterval>
)

data class ViewInterval(
    val date: Date,
    val temperature: Double
)