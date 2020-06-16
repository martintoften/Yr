package com.martintoften.yr.ui.list.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.R
import com.martintoften.yr.ui.model.ViewLocation
import com.martintoften.yr.util.Differ

class SearchAdapter(
    private val callback: (ViewLocation) -> Unit
) : RecyclerView.Adapter<SearchViewHolder>() {

    private val items = mutableListOf<ViewLocation>()

    fun setItems(items: List<ViewLocation>) {
        val diffResult = DiffUtil.calculateDiff(Differ(this.items, items))
        this.items.clear()
        this.items.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return SearchViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = items.count()
}