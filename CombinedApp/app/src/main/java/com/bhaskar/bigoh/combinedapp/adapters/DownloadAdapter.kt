package com.bhaskar.bigoh.combinedapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.database.Model
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.ui.fragments.DownloadNews
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DownloadAdapter(val context: DownloadNews) : RecyclerView.Adapter<DownloadAdapter.MyViewHolder>() {
    private var dataObject = listOf<Model>()
    private lateinit var database : NewsDatabase

    class MyViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title : TextView = itemView!!.findViewById(R.id.newsTitleDownload)
        val author : TextView = itemView!!.findViewById(R.id.newsAuthorDownload)
        val publish : TextView = itemView!!.findViewById(R.id.newsPublishDownload)
        val description : TextView = itemView!!.findViewById(R.id.newsDescriptionDownload)
        val content : TextView = itemView!!.findViewById(R.id.newsContentDownload)
        val image : ImageView = itemView!!.findViewById(R.id.newsImageDownload)
        val deleteButton : Button = itemView!!.findViewById(R.id.buttonDownload)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataObject : List<Model>, database: NewsDatabase) {
        this.dataObject = dataObject;
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.download_adapter_layout,parent,false)
        return DownloadAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataObject[position].title
        holder.author.text = dataObject[position].author
        holder.publish.text = dataObject[position].publish
        holder.description.text = dataObject[position].description
        holder.content.text = dataObject[position].content
        Picasso.get().load(dataObject[position].image).into(holder.image)
        holder.deleteButton.setOnClickListener {
            GlobalScope.launch {
                val droppedDataObject = dataObject.drop(position)
                database.newsDao().deleteNews(dataObject[position])
            }
            Toast.makeText(context.context, "News deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = dataObject.size
}