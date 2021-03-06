package com.martintoften.yr.ui.list.forecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.R
import com.martintoften.yr.extensions.getDrawableIdByName
import com.martintoften.yr.extensions.getString
import com.martintoften.yr.extensions.getThemeColor
import com.martintoften.yr.ui.model.ViewInterval
import com.martintoften.yr.util.getReadableHours
import com.martintoften.yr.util.getWeatherType
import com.martintoften.yr.util.getWeatherVariant
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast_interval.view.*

class ForecastIntervalViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindItem(interval: ViewInterval) {
        containerView.temperature.setTextColor(getTemperatureColor(interval))
        containerView.temperature.text = getTemperature(interval)
        containerView.time.text = getReadableHours(interval.date)
        val symbol = getWeatherSymbol(interval) ?: return
        containerView.symbol.setImageResource(symbol)
        containerView.precipitation.text = getPrecipitation(interval)
        containerView.wind.rotation = interval.wind?.direction?.toFloat() ?: 0f
        containerView.windSpeed.text = interval.wind?.speed.toString()
    }

    private fun getTemperatureColor(interval: ViewInterval): Int {
        val colorId = if (interval.temperature > 0.0) R.attr.colorOnBackgroundTertiary
        else R.attr.colorSecondary
        return containerView.getThemeColor(colorId)
    }

    private fun getTemperature(interval: ViewInterval): String {
        return containerView.context.getString(R.string.celsius, interval.temperature.toString())
    }

    private fun getWeatherSymbol(interval: ViewInterval): Int? {
        val weatherSymbol = interval.weatherSymbol ?: return null
        val type = getWeatherType(weatherSymbol.type)
        val variant = getWeatherVariant(weatherSymbol.variant).value
        return containerView.context.getDrawableIdByName("ic_$type$variant")
    }

    private fun getPrecipitation(interval: ViewInterval): String {
        val precipitation = interval.precipitation ?: return ""
        if (precipitation.max <= 0) return ""
        return containerView.getString(R.string.precipitation, precipitation.min, precipitation.max)
    }
}