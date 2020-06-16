package com.martintoften.yr.ui.list.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.martintoften.yr.ui.model.ViewLocation
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_search.view.*

class SearchViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindItem(location: ViewLocation) {
        containerView.title.text = location.name
        containerView.subTitle.text = getSubTitle(location)
    }

    private fun getSubTitle(location: ViewLocation): String {
        return "${location.category?.name.orEmpty()} - " +
                "${location.subRegion?.name.orEmpty()} " +
                "(${location.region?.name.orEmpty()})"
    }
}