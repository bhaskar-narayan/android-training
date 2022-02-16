package com.bhaskar.bigoh.viewpagerproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ViewPagerAdapter(private var title : List<String>, private var description : List<String>, private var images : List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPageHolder>() {

    inner class ViewPageHolder (view : View) : RecyclerView.ViewHolder(view) {
        val title : TextView = view.findViewById(R.id.titleText)
        val description : TextView = view.findViewById(R.id.descriptionText)
        val image : ShapeableImageView = view.findViewById(R.id.imageContainer)
        init {
            image.setOnClickListener {
                Toast.makeText(view.context, "You have clicked a ViewPage", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.ViewPageHolder {
        return ViewPageHolder(LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewPageHolder, position: Int) {
        holder.title.text = title[position]
        holder.description.text = description[position]
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount() = title.size

}