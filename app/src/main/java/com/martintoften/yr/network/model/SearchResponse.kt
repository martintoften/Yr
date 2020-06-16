package com.martintoften.yr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("_embedded")
    val embedded: Embedded?,
    @SerialName("_links")
    val links: LinksX?,
    val totalResults: Int? = 0
)