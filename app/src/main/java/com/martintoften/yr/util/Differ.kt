package com.martintoften.yr.util

import androidx.recyclerview.widget.DiffUtil

interface Diffable {
    fun getIdentifier(): String
}

class Differ<T : Diffable>(
    private val old: List<T>,
    private val new: List<T>
) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size
    override fun getNewListSize() = new.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].getIdentifier() == new[newItemPosition].getIdentifier()
    }
}