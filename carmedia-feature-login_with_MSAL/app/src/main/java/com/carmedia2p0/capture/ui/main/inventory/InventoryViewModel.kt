package com.carmedia2p0.capture.ui.main.inventory

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.carmedia2p0.capture.CarMediaApplication
import com.carmedia2p0.capture.model.response.getInventory.GetInventoryResponse
import com.carmedia2p0.capture.model.response.getInventory.Item
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import com.carmedia2p0.capture.ui.main.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    application: Application,
    private val repository: DataRepository
) : BaseViewModel(application, repository) {
    private val resString = getApplication<CarMediaApplication>().resources
    val inventoryLiveData: MutableLiveData<List<Item>> = MutableLiveData()

    companion object {
        const val TAG = "HomeViewModel"
    }

    init {
        getInventory()
    }

    private fun getInventory() {
        val handler = CoroutineExceptionHandler { _, exception -> }

        val job = viewModelScope.launch(Dispatchers.IO + handler) {
            showLoading(true)
            val response = repository.getInventory()
            if (response.isSuccessful) {
                showLoading(false)
                val inventoryList = response.body() as GetInventoryResponse
                inventoryLiveData.postValue(inventoryList.items)
                Log.d(HomeViewModel.TAG, response?.body()?.toString() ?: "")
            } else {
                showLoading(false)
                Log.d(HomeViewModel.TAG, response?.errorBody()?.toString() ?: "")
            }
        }
        job.invokeOnCompletion {
            if (it != null) {
                showLoading(false)
            }
            Log.d(HomeViewModel.TAG, it.toString())
        }
    }
}
