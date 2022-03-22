package com.bhaskar.bigoh.combinedapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.apimodels.Articles
import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.databinding.HomeAdapterLayoutBinding
import com.bhaskar.bigoh.combinedapp.models.NewsDataModel
import com.bhaskar.bigoh.combinedapp.ui.fragments.NewsViewFragment
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private lateinit var database: NewsDatabase
    private lateinit var binder: HomeAdapterLayoutBinding
    private var dataList = ArrayList<Articles>()


    class MyViewHolder (val binding: HomeAdapterLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (data: Articles) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

    fun setDataListItems(dataObject: ArrayList<Articles>) {
        this.dataList = dataObject
        //this.database = database
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binder = HomeAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
    override fun getItemCount() = dataList.size

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }
}