package com.martintoften.yr.ui.list.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.R
import com.martintoften.yr.ui.model.ViewForecast
import com.martintoften.yr.util.Differ

class ForecastAdapter : RecyclerView.Adapter<ForecastViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    private val items = mutableListOf<ViewForecast>()

    fun setItems(items: List<ViewForecast>) {
        val diffResult = DiffUtil.calculateDiff(Differ(this.items, items))
        this.items.clear()
        this.items.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast_parent, parent, false)
        return ForecastViewHolder(viewPool, view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = items.count()
}