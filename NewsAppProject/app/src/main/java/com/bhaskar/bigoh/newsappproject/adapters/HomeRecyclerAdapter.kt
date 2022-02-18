package com.bhaskar.bigoh.newsappproject.adapters

import android.annotation.SuppressLint
import android.content.Context
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
import com.bhaskar.bigoh.newsappproject.fragments.HomeScreen
import com.bhaskar.bigoh.newsappproject.homemodel.HomeData
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeRecyclerAdapter(val context: HomeScreen) : RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>() {
    private lateinit var database : DownloadDatabase

    private var dataObject = HomeData()

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val title : TextView = itemView!!.findViewById(R.id.title)
        val image : ImageView = itemView!!.findViewById(R.id.image)
        val author : TextView = itemView!!.findViewById(R.id.author)
        val publish : TextView = itemView!!.findViewById(R.id.publish)
        val description : TextView = itemView!!.findViewById(R.id.description)
        val content : TextView = itemView!!.findViewById(R.id.content)
        val button : Button = itemView!!.findViewById(R.id.button)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataObject: HomeData, database: DownloadDatabase) {
        this.dataObject = dataObject
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_adapter_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeRecyclerAdapter.MyViewHolder, position: Int) {
        holder.title.text = dataObject.articles[position].title
        val titleValue = dataObject.articles[position].title.toString()
        holder.author.text = dataObject.articles[position].author
        val authorValue = dataObject.articles[position].author.toString()
        holder.description.text = dataObject.articles[position].description
        val descriptionValue = dataObject.articles[position].description.toString()
        Picasso.get().load(dataObject.articles[position].urlToImage).into(holder.image)
        val imageValue = dataObject.articles[position].urlToImage.toString()
        holder.publish.text = dataObject.articles[position].publishedAt
        val publishValue = dataObject.articles[position].publishedAt.toString()
        holder.content.text = dataObject.articles[position].content
        val contentValue = dataObject.articles[position].content.toString()
        val toastMessage = "Saved Successfully"

        holder.button.setOnClickListener {
            GlobalScope.launch {
                if (database.downloadDao().newsCheck(titleValue) == null) {
                    database.downloadDao().downloadNews(Download(0, titleValue, authorValue, publishValue, descriptionValue, contentValue, imageValue))
                }
                //database.downloadDao().downloadNews(Download(0, titleValue, authorValue, publishValue, descriptionValue, contentValue, imageValue))
            }
            Toast.makeText(context.context, "Saved Successfully", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = dataObject.articles.size

}