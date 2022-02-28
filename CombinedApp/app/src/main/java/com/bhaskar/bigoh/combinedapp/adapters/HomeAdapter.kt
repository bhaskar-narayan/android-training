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
import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.database.Model
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.ui.fragments.HomeNews
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeAdapter (val context: HomeNews): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private lateinit var database : NewsDatabase

    private var dataObject = NewsModel()


    class MyViewHolder (itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        val title: TextView = itemView!!.findViewById(R.id.newsTitle)
        val image: ImageView = itemView!!.findViewById(R.id.newsImage)
        val author: TextView = itemView!!.findViewById(R.id.newsAuthor)
        val publish: TextView = itemView!!.findViewById(R.id.newsPublish)
        val description: TextView = itemView!!.findViewById(R.id.newsDescription)
        val content: TextView = itemView!!.findViewById(R.id.newsContent)
        val button: Button = itemView!!.findViewById(R.id.button)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataObject: NewsModel, database: NewsDatabase) {
        this.dataObject = dataObject
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_adapter_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
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

        GlobalScope.launch {
            holder.button.isEnabled = database.newsDao().newsCheck(titleValue) == null
        }

        holder.button.setOnClickListener {
            GlobalScope.launch {
                database.newsDao().downloadNews(Model(0, titleValue, authorValue, publishValue, descriptionValue, contentValue, imageValue))
            }
            notifyDataSetChanged()
            Toast.makeText(context.context, "News downloaded", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = dataObject.articles.size
}