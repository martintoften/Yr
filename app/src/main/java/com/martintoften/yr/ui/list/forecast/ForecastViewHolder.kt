package com.martintoften.yr.ui.list.forecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.ui.model.ViewForecast
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast_parent.view.*

class ForecastViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindItem(forecast: ViewForecast) {
        containerView.label.text = forecast.day.toString()
    }
}