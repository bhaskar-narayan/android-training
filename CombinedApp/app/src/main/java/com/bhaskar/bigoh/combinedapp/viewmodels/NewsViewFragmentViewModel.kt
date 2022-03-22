package com.bhaskar.bigoh.combinedapp.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhaskar.bigoh.combinedapp.adapters.HomeAdapter
import com.bhaskar.bigoh.combinedapp.apimodels.Articles
import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.client.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class NewsViewFragmentViewModel: ViewModel() {
    private var listData = MutableLiveData<NewsModel>()
    private var adapter: HomeAdapter = HomeAdapter()

    @JvmName("getHomeAdapter")
    fun getAdapter(): HomeAdapter {
        return adapter

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapter(data: ArrayList<Articles>) {
        adapter.setDataListItems(data)
        adapter.notifyDataSetChanged()
    }

    fun getListDataObserver(): MutableLiveData<NewsModel> {
        return listData
    }

    fun callApi() {
        val apiClient = ApiClient.create()
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiClient.getNews()
            if (response.isSuccessful)
                listData.postValue(response.body())
        }

    }
}