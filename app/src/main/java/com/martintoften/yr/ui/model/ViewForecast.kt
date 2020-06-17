package com.martintoften.yr.ui.model

import com.martintoften.yr.util.Diffable
import java.util.Date

data class ViewForecast(
    val day: Int,
    val intervals: List<ViewInterval>
) : Diffable {
    override fun getIdentifier() = day.toString()
}

data class ViewInterval(
    val date: Date,
    val temperature: Double,
    val weatherSymbol: ViewWeatherSymbol?
) : Diffable {
    override fun getIdentifier() = date.time.toString()
}