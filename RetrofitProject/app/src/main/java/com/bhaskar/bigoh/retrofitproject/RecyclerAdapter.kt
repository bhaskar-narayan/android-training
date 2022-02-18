package com.bhaskar.bigoh.retrofitproject

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter (val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var dataList = Data()

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val title: TextView = itemView!!.findViewById(R.id.title)
        val author: TextView = itemView!!.findViewById(R.id.author)
        val description: TextView = itemView!!.findViewById(R.id.description)
        val image: ImageView = itemView!!.findViewById(R.id.image)
        val publish: TextView = itemView!!.findViewById(R.id.publish)
        val content: TextView = itemView!!.findViewById(R.id.content)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataList: Data){
        this.dataList = dataList;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        holder.title.text = dataList.articles[position].title
        holder.author.text = dataList.articles[position].author
        holder.description.text = dataList.articles[position].description
        Picasso.get().load(dataList.articles[position].urlToImage).into(holder.image)
        holder.publish.text = dataList.articles[position].publishedAt
        holder.content.text = dataList.articles[position].content
    }

    override fun getItemCount() = dataList.articles.size

}