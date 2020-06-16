package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    @SerialName("_links")
    val links: Links? = null,
    val created: String? = null,
    val longIntervals: List<LongInterval> = emptyList(),
    val shortIntervals: List<ShortInterval> = emptyList(),
    val update: String? = null
)