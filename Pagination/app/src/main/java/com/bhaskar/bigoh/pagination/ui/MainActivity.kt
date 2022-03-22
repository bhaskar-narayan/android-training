package com.bhaskar.bigoh.pagination.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.pagination.R
import com.bhaskar.bigoh.pagination.adapters.MainActivityRecyclerAdapter
import com.bhaskar.bigoh.pagination.adapters.MainActivityRecyclerLoadStateAdapter
import com.bhaskar.bigoh.pagination.interfaces.ApiInterface
import com.bhaskar.bigoh.pagination.viewmodel.MainActivityViewModel
import com.bhaskar.bigoh.pagination.viewmodel.MainActivityViewModelFactory
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var recyclerAdapter: MainActivityRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainActivityViewModelFactory(ApiInterface.create()))[MainActivityViewModel::class.java]
        val recyclerView: RecyclerView = findViewById(R.id.mainRecyclerView)

        recyclerAdapter = MainActivityRecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        lifecycleScope.launch {
            viewModel.listData.collect {
                recyclerAdapter.submitData(it)
            }
        }
    }
}