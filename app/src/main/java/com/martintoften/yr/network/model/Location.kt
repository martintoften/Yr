package com.martintoften.yr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("_links")
    val links: Links?,
    val category: Category?,
    val country: Country?,
    val elevation: Int?,
    val id: String?,
    val name: String?,
    val position: Position?,
    val region: Region?,
    @SerialName("subregion")
    val subRegion: SubRegion?,
    val timeZone: String?,
    val urlPath: String?
)