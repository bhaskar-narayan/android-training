package com.bhaskar.bigoh.pagination.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.pagination.R

class MainActivityRecyclerLoadStateAdapter (private val retry: () -> Unit): LoadStateAdapter<MainActivityRecyclerLoadStateAdapter.LoadStateViewHolder>() {
    class LoadStateViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(
        holder: MainActivityRecyclerLoadStateAdapter.LoadStateViewHolder,
        loadState: LoadState
    ) {
        val progressBar: ProgressBar = holder.itemView.findViewById(R.id.loadStateProgressBar)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): MainActivityRecyclerLoadStateAdapter.LoadStateViewHolder {
        return LoadStateViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.news_adapter_load_state_layout, parent, false))
    }
}