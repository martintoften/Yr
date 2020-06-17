package com.martintoften.yr.ui.list.forecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.ui.model.ViewForecast
import com.martintoften.yr.util.getReadableDate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast_parent.view.*

class ForecastViewHolder(
    private val viewPool: RecyclerView.RecycledViewPool,
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindItem(forecast: ViewForecast) {
        containerView.label.text = getDate(forecast)
        containerView.intervalList.apply {
            setRecycledViewPool(viewPool)
            adapter = ForecastIntervalAdapter().apply {
                setItems(forecast.intervals)
            }
        }
    }

    private fun getDate(forecast: ViewForecast): String {
        val date = forecast.intervals.firstOrNull()?.date
        return if (date != null) getReadableDate(date) else ""
    }
}