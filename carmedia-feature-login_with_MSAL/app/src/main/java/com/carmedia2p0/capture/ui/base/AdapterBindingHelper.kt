package com.carmedia2p0.capture.ui.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

/**
 * A generic helper class to generate and bind view for adapters
 * @param <T> Type of the items in the list
 * @param <V> The type of the ViewDataBinding
 */
interface AdapterBindingHelper<T, V : ViewDataBinding> {

    /**
     * to create viewBinding for particular view type
     * @param parent ViewGroup
     * @return V viewBinding
     */
    fun getViewDataBinding(parent: ViewGroup): V

    /**
     * Called when you have to bind view with item
     * @param binding viewBinding of view
     * @param item item to be bind with viewBinding
     */
    fun bind(binding: V, item: T?)
}
