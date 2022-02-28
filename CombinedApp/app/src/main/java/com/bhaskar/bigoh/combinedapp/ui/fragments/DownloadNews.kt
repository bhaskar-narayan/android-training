package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.adapters.DownloadAdapter
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase

class DownloadNews : Fragment() {
    private lateinit var database : NewsDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_download_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = NewsDatabase.getDatabase(requireActivity().applicationContext)
        val recyclerView : RecyclerView = requireView().findViewById(R.id.downloadRecyclerView)
        val recyclerAdapter = DownloadAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = recyclerAdapter


        database.newsDao().getNews().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setDataListItems(it, database)
        })
    }
}