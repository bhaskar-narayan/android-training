package com.bhaskar.bigoh.pagination.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bhaskar.bigoh.pagination.datasource.ApiDataSource
import com.bhaskar.bigoh.pagination.interfaces.ApiInterface
import com.bhaskar.bigoh.pagination.models.Hit
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class MainActivityViewModel (private val apiInterface: ApiInterface): ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 3, prefetchDistance = 5)) {
        ApiDataSource(apiInterface)
    }

    

    // .flow.cachedIn(viewModelScope)
}