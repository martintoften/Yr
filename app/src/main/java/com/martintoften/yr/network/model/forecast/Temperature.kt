package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.Serializable

@Serializable
data class Temperature(
    val max: Double? = null,
    val min: Double? = null,
    val value: Double? = null
)