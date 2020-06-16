package com.martintoften.yr.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Position(
    val lat: Double? = null,
    val lon: Double? = null
)