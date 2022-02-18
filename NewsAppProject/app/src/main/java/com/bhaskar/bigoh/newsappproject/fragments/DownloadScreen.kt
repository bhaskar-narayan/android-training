package com.bhaskar.bigoh.newsappproject.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.newsappproject.R
import com.bhaskar.bigoh.newsappproject.adapters.DownloadRecyclerAdapter
import com.bhaskar.bigoh.newsappproject.database.Download
import com.bhaskar.bigoh.newsappproject.database.DownloadDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DownloadScreen : Fragment() {
    private lateinit var database : DownloadDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_download_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = requireView().findViewById(R.id.downloadRecyclerView)
        val recyclerAdapter = DownloadRecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = recyclerAdapter

        database = DownloadDatabase.getDatabase(requireActivity().applicationContext)

        database.downloadDao().getNews().observe(viewLifecycleOwner, Observer {
            recyclerAdapter.setDataListItems(it as ArrayList<Download>, database)
        })
    }
}