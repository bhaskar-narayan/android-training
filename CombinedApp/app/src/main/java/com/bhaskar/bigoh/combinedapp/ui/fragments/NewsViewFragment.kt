package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.adapters.HomeAdapter
import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.client.ApiClient
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.databinding.FragmentNewsViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewFragment : Fragment() {
    private lateinit var binder: FragmentNewsViewBinding
    private lateinit var database : NewsDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_news_view, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = NewsDatabase.getDatabase(requireActivity().applicationContext)
        val recyclerAdapter = HomeAdapter(this@NewsViewFragment)

        binder.newsRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binder.newsRecyclerView.adapter = recyclerAdapter
        binder.homeProgressBar.visibility = View.VISIBLE

        val apiClient = ApiClient.create()
        val apiInterface = apiClient.getNews()

        database = NewsDatabase.getDatabase(requireActivity().applicationContext)

        apiInterface.enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                if (response.body() != null)
                    recyclerAdapter.setDataListItems(response.body()!!, database)
                binder.homeProgressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                binder.homeProgressBar.visibility = View.GONE
            }
        })


    }
}