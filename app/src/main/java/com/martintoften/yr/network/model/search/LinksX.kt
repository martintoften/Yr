package com.martintoften.yr.network.model.search

import kotlinx.serialization.Serializable

@Serializable
data class LinksX(
    val location: List<LocationX> = emptyList(),
    val page: Page? = null,
    val search: Search? = null,
    val self: SelfX? = null
)