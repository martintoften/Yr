package com.martintoften.yr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("airqualityforecast")
    val airqualityForecast: AirqualityForecast? = null,
    @SerialName("bathingtemperatures")
    val bathingTemperatures: BathingTemperatures? = null,
    @SerialName("celestialevents")
    val celestialEvents: CelestialEvents? = null,
    @SerialName("extremeforecasts")
    val extremeForecasts: ExtremeForecasts? = null,
    val forecast: Forecast? = null,
    @SerialName("mapfeature")
    val mapFeature: MapFeature? = null,
    val notifications: Notifications? = null,
    val now: Now? = null,
    val observations: List<Observation>? = null,
    val pollen: Pollen? = null,
    val self: Self? = null
)