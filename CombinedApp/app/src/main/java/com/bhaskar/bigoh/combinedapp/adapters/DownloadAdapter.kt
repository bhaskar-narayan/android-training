package com.bhaskar.bigoh.combinedapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.databinding.DownloadAdapterLayoutBinding
import com.bhaskar.bigoh.combinedapp.models.NewsDataModel
import com.bhaskar.bigoh.combinedapp.ui.fragments.NewsDownloadFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DownloadAdapter(val context: NewsDownloadFragment) :
    RecyclerView.Adapter<DownloadAdapter.MyViewHolder>() {
    private var dataObject = listOf<NewsDataModel>()
    private lateinit var database: NewsDatabase
    private lateinit var binder: DownloadAdapterLayoutBinding

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {}

    @SuppressLint("NotifyDataSetChanged")
    fun setDataListItems(dataObject: List<NewsDataModel>, database: NewsDatabase) {
        this.dataObject = dataObject;
        this.database = database
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.download_adapter_layout,
            parent,
            false
        )
        return MyViewHolder(binder.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        binder.newsTitleDownload.text = dataObject[position].title
        binder.newsAuthorDownload.text = dataObject[position].author
        binder.newsPublishDownload.text = dataObject[position].publish
        binder.newsDescriptionDownload.text = dataObject[position].description
        binder.newsContentDownload.text = dataObject[position].content
        Picasso.get().load(dataObject[position].image).into(binder.newsImageDownload)


        binder.buttonDownload.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
//                dataObject.drop(position)
                database.newsDao().deleteNews(dataObject[position])
                dataObject.drop(position)
            }
            Toast.makeText(
                context.context,
                context.getString(R.string.news_deleted),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount() = dataObject.size
}