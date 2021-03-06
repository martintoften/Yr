package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.Serializable

@Serializable
data class PrecipitationX(
    val max: Double? = null,
    val min: Double? = null,
    val pop: Double? = null,
    val value: Double? = null
)