package com.bhaskar.bigoh.twowaydatabinding.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.bhaskar.bigoh.twowaydatabinding.model.DataModel

class DataViewModel : BaseObservable() {
    private val dataModel = DataModel()

    @Bindable
    fun getDataName() : String {
        return dataModel.name
    }

    fun setDataName(inputName : String) {
        dataModel.name = inputName
        notifyChange()
    }
}