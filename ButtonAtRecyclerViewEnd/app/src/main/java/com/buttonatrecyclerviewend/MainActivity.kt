package com.buttonatrecyclerviewend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.mainRecyclerView)
        val listOfImage = mutableListOf<ImageModel>()

        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))
        listOfImage.add(ImageModel(R.drawable.ic_launcher_foreground))

        val myAdapter = RecyclerAdapter(this@MainActivity)
        myAdapter.setData(listOfImage)

        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = myAdapter
        }
    }
}