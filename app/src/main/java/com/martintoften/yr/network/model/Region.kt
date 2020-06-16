package com.martintoften.yr.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Region(
    val id: String? = null,
    val name: String? = null
)