package com.martintoften.yr.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Embedded(
    val location: List<Location>?
)