package com.martintoften.yr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("airqualityforecast")
    val airqualityForecast: AirqualityForecast?,
    @SerialName("bathingtemperatures")
    val bathingTemperatures: BathingTemperatures?,
    @SerialName("celestialevents")
    val celestialEvents: CelestialEvents?,
    @SerialName("extremeforecasts")
    val extremeForecasts: ExtremeForecasts?,
    val forecast: Forecast?,
    @SerialName("mapfeature")
    val mapFeature: MapFeature?,
    val notifications: Notifications?,
    val now: Now?,
    val observations: List<Observation>?,
    val pollen: Pollen?,
    val self: Self?
)