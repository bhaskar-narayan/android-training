package com.bhaskar.bigoh.newsappproject.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.newsappproject.R
import com.bhaskar.bigoh.newsappproject.database.Download
import com.bhaskar.bigoh.newsappproject.database.DownloadDatabase
import com.bhaskar.bigoh.newsappproject.fragments.DownloadScreen
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DownloadRecyclerAdapter(val context: DownloadScreen) : RecyclerView.Adapter<DownloadRecyclerAdapter.MyViewHolder>() {
    private var dataObject = listOf<Download>()
    private lateinit var database : DownloadDatabase

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title : TextView = itemView!!.findViewById(R.id.titleDownload)
        val author : TextView = itemView!!.findViewById(R.id.authorDownload)
        val publish : TextView = itemView!!.findViewById(R.id.publishDownload)
        val description : TextView = itemView!!.findViewById(R.id.descriptionDownload)
        val content : TextView = itemView!!.findViewById(R.id.contentDownload)
        val image : ImageView = itemView!!.findViewById(R.id.imageDownload)
        val deleteButton : Button = itemView!!.findViewById(R.id.deleteButton)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataObject : ArrayList<Download>, database: DownloadDatabase) {
        this.dataObject = dataObject;
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DownloadRecyclerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.download_adapter_layout,parent,false)
        return DownloadRecyclerAdapter.MyViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: DownloadRecyclerAdapter.MyViewHolder, position: Int) {
        holder.title.text = dataObject[position].title
        holder.author.text = dataObject[position].author
        holder.publish.text = dataObject[position].publish
        holder.description.text = dataObject[position].description
        holder.content.text = dataObject[position].content
        Picasso.get().load(dataObject[position].image).into(holder.image)

        holder.deleteButton.setOnClickListener {
            GlobalScope.launch {
                database.downloadDao().deleteNews(dataObject[position])
            }
            Toast.makeText(context.context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
            val droppedDataObject = dataObject.drop(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = dataObject.size

}