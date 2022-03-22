package com.carmedia2p0.capture.ui.base.recyclerViewAdapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.carmedia2p0.capture.BR

/**
 * A generic ViewHolder that works with a [ViewDataBinding].
 * Note: Ensure to use the identifier [viewHolderItem] for the variable created in the item's XML file.
 * @param <T> The type of item
 */
class DataBindingViewHolder<T> constructor(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(BR.viewHolderItem, item)
        binding.executePendingBindings()
    }
}
