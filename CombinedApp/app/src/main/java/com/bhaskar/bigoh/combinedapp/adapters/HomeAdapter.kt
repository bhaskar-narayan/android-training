package com.bhaskar.bigoh.combinedapp.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.models.NewsDataModel
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.databinding.HomeAdapterLayoutBinding
import com.bhaskar.bigoh.combinedapp.ui.fragments.NewsViewFragment
import com.bhaskar.bigoh.combinedapp.ui.fragments.RoomRetrofitFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class HomeAdapter (val context: NewsViewFragment): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private lateinit var database : NewsDatabase
    private lateinit var binder: HomeAdapterLayoutBinding
    private var isButtonEnable: Boolean = false
    private var dataObject = NewsModel()


    class MyViewHolder (itemView: View?): RecyclerView.ViewHolder(itemView!!) {}

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataObject: NewsModel, database: NewsDatabase) {
        this.dataObject = dataObject
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binder = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.home_adapter_layout, parent, false)
        return MyViewHolder(binder.root)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        binder.newsTitle.text = dataObject.articles[position].title
        val titleValue = dataObject.articles[position].title.toString()
        binder.newsAuthor.text = dataObject.articles[position].author
        val authorValue = dataObject.articles[position].author.toString()
        binder.newsDescription.text = dataObject.articles[position].description
        val descriptionValue = dataObject.articles[position].description.toString()
        Picasso.get().load(dataObject.articles[position].urlToImage).into(binder.newsImage)
        val imageValue = dataObject.articles[position].urlToImage.toString()
        binder.newsPublish.text = dataObject.articles[position].publishedAt
        val publishValue = dataObject.articles[position].publishedAt.toString()
        binder.newsContent.text = dataObject.articles[position].content
        val contentValue = dataObject.articles[position].content.toString()
        
        CoroutineScope(Dispatchers.Default).launch {
            if (database.newsDao().newsCheck(titleValue) == null) {
                MainScope().launch {
                    binder.button.isEnabled = true
                }
            } else {
                MainScope().launch {
                    binder.button.isEnabled = false
                }
            }
        }

        binder.button.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                database.newsDao().downloadNews(NewsDataModel(0, titleValue, authorValue, publishValue, descriptionValue, contentValue, imageValue))
            }
            Toast.makeText(context.context, context.getString(R.string.news_downloaded), Toast.LENGTH_SHORT).show()
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = dataObject.articles.size
}