package com.carmedia2p0.capture.ui.base.recyclerViewAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * A generic RecyclerView list adapter that uses Data Binding & DiffUtil. It also supports
 * multiple types of views in the RecyclerView
 * @param <T> Type of the items in the list
 */
abstract class BaseAdapter<T>(
    itemsSame: (T, T) -> Boolean,
    contentsSame: (T, T) -> Boolean,
) :
    ListAdapter<T, DataBindingViewHolder<T>>(
        object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(old: T, new: T): Boolean = itemsSame(old, new)
            override fun areContentsTheSame(old: T, new: T): Boolean = contentsSame(old, new)
        }
    ) {

    /**
     * Return the view type of the item at <code>position</code> for the purposes
     * of view recycling.
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * <code>position</code>. Type codes need not be contiguous.
     */
    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent
     * an item.
     * @param parent ViewGroupThe ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return BaseViewHolder<V>
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(binding)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * Return the layout id for the item at the <code>position</code>
     * @param position position to query
     * @return layout ID of the item
     */
    protected abstract fun getLayoutIdForPosition(position: Int): Int
}
