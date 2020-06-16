package com.martintoften.yr.network.model.search

import com.martintoften.yr.network.model.search.Embedded
import com.martintoften.yr.network.model.search.LinksX
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