package com.bhaskar.bigoh.pagination.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhaskar.bigoh.pagination.interfaces.ApiInterface
import java.lang.IllegalArgumentException

class MainActivityViewModelFactory (private val apiInterface: ApiInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(apiInterface) as T
        }
        throw IllegalArgumentException("viewmodel not found")
    }
}