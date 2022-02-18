package com.bhaskar.bigoh.newsappproject.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.newsappproject.R
import com.bhaskar.bigoh.newsappproject.adapters.HomeRecyclerAdapter
import com.bhaskar.bigoh.newsappproject.clients.HomeApiClient
import com.bhaskar.bigoh.newsappproject.database.DownloadDatabase
import com.bhaskar.bigoh.newsappproject.homemodel.HomeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreen : Fragment() {
    private lateinit var database : DownloadDatabase
    private val TAG = "HomeScreen"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView : RecyclerView = requireView().findViewById(R.id.homeRecyclerView)
        val recyclerAdapter = HomeRecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = recyclerAdapter

        val apiClient = HomeApiClient.create()
        val apiInterface = apiClient.getData()

        database = DownloadDatabase.getDatabase(requireActivity().applicationContext)

        apiInterface.enqueue( object : Callback<HomeData> {
            override fun onResponse(call: Call<HomeData>, response: Response<HomeData>) {
                if(response.body() != null)
                    recyclerAdapter.setDataListItems(response.body()!!, database)
            }

            override fun onFailure(call: Call<HomeData>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.toString()}")
            }
        })
    }
}