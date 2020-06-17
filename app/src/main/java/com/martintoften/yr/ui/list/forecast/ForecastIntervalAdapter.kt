package com.martintoften.yr.ui.list.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.R
import com.martintoften.yr.ui.model.ViewInterval

class ForecastIntervalAdapter : RecyclerView.Adapter<ForecastIntervalViewHolder>() {

    private val items = mutableListOf<ViewInterval>()

    fun setItems(items: List<ViewInterval>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastIntervalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast_interval, parent, false)
        return ForecastIntervalViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastIntervalViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = items.count()
}