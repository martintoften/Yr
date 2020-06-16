package com.martintoften.yr.network.model.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("_links")
    val links: Links? = null,
    val category: Category? = null,
    val country: Country? = null,
    val elevation: Int? = null,
    val id: String? = null,
    val name: String? = null,
    val position: Position? = null,
    val region: Region? = null,
    @SerialName("subregion")
    val subRegion: SubRegion? = null,
    val timeZone: String? = null,
    val urlPath: String? = null
)