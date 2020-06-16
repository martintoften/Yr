package com.martintoften.yr.network.model.search

import kotlinx.serialization.Serializable

@Serializable
data class Embedded(
    val location: List<Location> = emptyList()
)