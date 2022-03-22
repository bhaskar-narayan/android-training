package com.carmedia2p0.capture.ui.base.recyclerViewAdapter

import androidx.annotation.LayoutRes

/**
 * A generic RecyclerView list adapter that uses Data Binding & DiffUtil.
 * This adapter is for single view type.
 * @param <T> Type of the items in the list
 */
abstract class SingleViewAdapter<T>(
    @LayoutRes
    val layoutId: Int,
    itemsSame: (T, T) -> Boolean,
    contentsSame: (T, T) -> Boolean,
) : BaseAdapter<T>(itemsSame, contentsSame) {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}
