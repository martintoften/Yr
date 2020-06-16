package com.martintoften.yr.ui.model

import android.os.Parcelable
import com.martintoften.yr.util.Diffable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewLocation(
    override val id: String,
    val name: String,
    val category : ViewCategory?,
    val region: ViewRegion?,
    val subRegion: ViewSubRegion?
) : Parcelable, Diffable

@Parcelize
data class ViewCategory(
    val id: String?,
    val name: String?
): Parcelable

@Parcelize
data class ViewRegion(
    val id: String?,
    val name: String?
): Parcelable

@Parcelize
data class ViewSubRegion(
    val id: String?,
    val name: String?
): Parcelable