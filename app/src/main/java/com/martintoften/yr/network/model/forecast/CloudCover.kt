package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.Serializable

@Serializable
data class CloudCover(
    val fog: Double? = null,
    val high: Double? = null,
    val low: Double? = null,
    val middle: Double? = null,
    val value: Double? = null
)