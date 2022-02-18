package com.bhaskar.bigoh.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "RetroLog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter


        val apiInterface = ApiInterface.create().getData()

        apiInterface.enqueue( object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if(response?.body() != null)
                    recyclerAdapter.setDataListItems(response.body()!!)
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.toString()}")
            }
        })
    }
}