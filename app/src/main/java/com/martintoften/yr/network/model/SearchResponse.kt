package com.martintoften.yr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("_embedded")
    val embedded: Embedded? = null,
    @SerialName("_links")
    val links: LinksX? = null,
    val totalResults: Int? = 0
)