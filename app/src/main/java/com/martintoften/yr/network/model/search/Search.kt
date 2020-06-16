package com.martintoften.yr.network.model.search

import kotlinx.serialization.Serializable

@Serializable
data class Search(
    val href: String? = null,
    val templated: Boolean? = null
)