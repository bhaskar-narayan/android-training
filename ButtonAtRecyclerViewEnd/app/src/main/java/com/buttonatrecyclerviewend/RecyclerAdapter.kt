package com.buttonatrecyclerviewend

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(context: MainActivity) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    var list = mutableListOf<ImageModel>()
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val adapterImage: AppCompatImageView = view.findViewById(R.id.adapterImage)
    }

    fun setData(list: MutableList<ImageModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_layout, parent, false)
        Log.d("DEBUGCHECK", "onCreateViewHolder: ")
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.adapterImage.setImageResource(list[position].image)
    }

    override fun getItemCount() = list.size
}