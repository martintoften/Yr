package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SymbolX(
    val clouds: Double? = null,
    val n: Int? = null,
    val precip: Double? = null,
    val sunup: Boolean = false,
    @SerialName("var")
    val variable: String? = null
)