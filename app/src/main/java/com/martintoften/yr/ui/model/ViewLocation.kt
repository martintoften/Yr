package com.martintoften.yr.ui.model

import com.martintoften.yr.util.Diffable

data class ViewLocation(
    override val id: String,
    val name: String,
    val category : ViewCategory?,
    val region: ViewRegion?,
    val subRegion: ViewSubRegion?
) : Diffable

data class ViewCategory(
    val id: String?,
    val name: String?
)

data class ViewRegion(
    val id: String?,
    val name: String?
)

data class ViewSubRegion(
    val id: String?,
    val name: String?
)