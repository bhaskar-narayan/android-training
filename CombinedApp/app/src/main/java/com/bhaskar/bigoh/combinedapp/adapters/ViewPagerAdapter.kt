package com.bhaskar.bigoh.combinedapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.ViewPagerLayoutBinding

class ViewPagerAdapter(
    private var title: List<String>,
    private var description: List<String>,
    private var images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPageHolder>() {
    private lateinit var binder: ViewPagerLayoutBinding

    class ViewPageHolder(view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.ViewPageHolder {
        binder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.view_pager_layout,
            parent,
            false
        )
        return ViewPageHolder(binder.root)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewPageHolder, position: Int) {
        binder.titleText.text = title[position]
        binder.descriptionText.text = description[position]
        binder.imageContainer.setImageResource(images[position])

        binder.imageContainer.setOnClickListener {
            when (position) {
                0 -> Toast.makeText(
                    holder.itemView.context,
                    holder.itemView.context.getString(R.string.swift_and_fast),
                    Toast.LENGTH_SHORT
                ).show()
                1 -> Toast.makeText(
                    holder.itemView.context,
                    holder.itemView.context.getString(R.string.security_assured),
                    Toast.LENGTH_SHORT
                ).show()
                2 -> Toast.makeText(
                    holder.itemView.context,
                    holder.itemView.context.getString(R.string.vaccinated_stuff),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount() = title.size
}