package com.martintoften.yr.network.model.search

import kotlinx.serialization.Serializable

@Serializable
data class Position(
    val lat: Double? = null,
    val lon: Double? = null
)