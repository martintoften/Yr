package com.martintoften.yr.network.model

import kotlinx.serialization.Serializable

@Serializable
data class LinksX(
    val location: List<LocationX>?,
    val page: Page?,
    val search: Search?,
    val self: SelfX?
)