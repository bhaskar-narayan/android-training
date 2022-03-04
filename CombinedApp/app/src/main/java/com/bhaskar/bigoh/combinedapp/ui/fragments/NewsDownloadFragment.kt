package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.adapters.DownloadAdapter
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.databinding.FragmentDownloadNewsBinding

class NewsDownloadFragment : Fragment() {
    private lateinit var binder: FragmentDownloadNewsBinding
    private lateinit var database : NewsDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_download_news, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = NewsDatabase.getDatabase(requireActivity().applicationContext)
        val recyclerAdapter = DownloadAdapter(this)

        binder.downloadRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binder.downloadRecyclerView.adapter = recyclerAdapter


        database.newsDao().getNews().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setDataListItems(it, database)
        })
    }
}