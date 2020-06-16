package com.martintoften.yr.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Page(
    val href: String?,
    val templated: Boolean?
)