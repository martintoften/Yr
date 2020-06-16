package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    val direction: Int? = null,
    val gust: Double? = null,
    val speed: Double? = null
)