package com.bhaskar.bigoh.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = Array<String>(5, init = { "" })

        for (loopCounter in 0..4)
            itemList[loopCounter] = "John Doe"

        val recyclerViewContainer: RecyclerView = findViewById(R.id.recyclerViewContainer)
        val linerLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewContainer.layoutManager = linerLayoutManager
        val dataObject = DataClass()
        val customAdapter = AdapterClass(dataObject)
        recyclerViewContainer.adapter = customAdapter
    }
}