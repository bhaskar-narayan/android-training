package com.carmedia2p0.capture.adapters

import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.ItemFilterKeysBinding
import com.carmedia2p0.capture.model.dummy.DummyKeyFilterResponse
import com.carmedia2p0.capture.ui.base.recyclerViewAdapter.BaseAdapter
import com.carmedia2p0.capture.ui.base.recyclerViewAdapter.DataBindingViewHolder

class FilterKeysAdapter(private val onClickItem: (DummyKeyFilterResponse) -> Unit) :
    BaseAdapter<DummyKeyFilterResponse>(
        itemsSame = { old, new -> old.filterKeyText == new.filterKeyText },
        contentsSame = { old, new -> old == new }
    ) {
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_filter_keys
    }

    override fun onBindViewHolder(
        holder: DataBindingViewHolder<DummyKeyFilterResponse>,
        position: Int
    ) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        val binding = holder.binding as ItemFilterKeysBinding
        binding.filterKey.text = item.filterKeyText
    }
}
