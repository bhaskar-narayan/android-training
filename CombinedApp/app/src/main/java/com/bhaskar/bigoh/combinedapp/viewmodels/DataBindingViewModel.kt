package com.bhaskar.bigoh.combinedapp.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.bhaskar.bigoh.combinedapp.models.DataBindingModel

class DataBindingViewModel: BaseObservable() {
    private val dataModel = DataBindingModel()

    @Bindable
    fun getDataName() : String {
        return dataModel.name
    }

    fun setDataName(inputName : String) {
        dataModel.name = inputName
        notifyChange()
    }
}