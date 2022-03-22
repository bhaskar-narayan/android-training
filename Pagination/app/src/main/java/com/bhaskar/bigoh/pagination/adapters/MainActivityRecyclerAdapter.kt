package com.bhaskar.bigoh.pagination.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.pagination.R
import com.bhaskar.bigoh.pagination.models.Hit
import com.bumptech.glide.Glide

class MainActivityRecyclerAdapter: PagingDataAdapter<Hit, MainActivityRecyclerAdapter.MyViewHolder>(DataDiff) {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    object DataDiff: DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: MainActivityRecyclerAdapter.MyViewHolder, position: Int) {
        val imageView: ImageView = holder.itemView.findViewById(R.id.adapterImage)
        Glide.with(imageView)
            .load(getItem(position)?.largeImageURL)
            .into(imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityRecyclerAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_adapter_layout, parent, false))
    }
}