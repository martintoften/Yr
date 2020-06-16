package com.martintoften.yr.ui.viewModel.mapper

import com.martintoften.yr.network.model.search.Category
import com.martintoften.yr.network.model.search.Location
import com.martintoften.yr.network.model.search.Region
import com.martintoften.yr.network.model.search.SearchResponse
import com.martintoften.yr.network.model.search.SubRegion
import com.martintoften.yr.ui.model.ViewCategory
import com.martintoften.yr.ui.model.ViewLocation
import com.martintoften.yr.ui.model.ViewRegion
import com.martintoften.yr.ui.model.ViewSubRegion

fun SearchResponse.mapToViewModel(): List<ViewLocation> {
    return embedded?.location?.mapNotNull { it.mapToViewModel() } ?: emptyList()
}

fun Location.mapToViewModel(): ViewLocation? {
    if (id == null || name == null) return null

    return ViewLocation(
        id = id,
        name = name,
        category = category?.mapToViewModel(),
        region = region?.mapToViewModel(),
        subRegion = subRegion?.mapToViewModel()
    )
}

fun Category.mapToViewModel(): ViewCategory? {
    if (id == null || name == null) return null

    return ViewCategory(
        id = id,
        name = name
    )
}

fun Region.mapToViewModel(): ViewRegion? {
    if (id == null || name == null) return null

    return ViewRegion(
        id = id,
        name = name
    )
}


fun SubRegion.mapToViewModel(): ViewSubRegion? {
    if (id == null || name == null) return null

    return ViewSubRegion(
        id = id,
        name = name
    )
}