package com.martintoften.yr.network.model.search

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: String? = null,
    val name: String? = null
)