package com.bhaskar.bigoh.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class AdapterClass(dataObject : DataClass) : RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    private var allData = DataClass()
    init {
        allData = dataObject
    }
    class ViewHolder (view: View) : RecyclerView.ViewHolder (view) {
        val carName : MaterialTextView = view.findViewById(R.id.carName)
        val agingMedia : TextView = view.findViewById(R.id.agingMedia)
        val stock : TextView = view.findViewById(R.id.stockNumber)
        val vin : TextView = view.findViewById(R.id.vinNumber)
        val carImage : ImageView = view.findViewById(R.id.carImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.text = allData.carNameList[position]
        holder.carImage.setImageResource(allData.carImageList[position])
        holder.agingMedia.text = allData.agingMediaList[position]
        holder.stock.text = allData.stockList[position]
        holder.vin.text = allData.vinList[position]
    }

    override fun getItemCount() = allData.carNameList.size
}