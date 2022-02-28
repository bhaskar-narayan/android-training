package com.bhaskar.bigoh.mvvmbasic.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.bhaskar.bigoh.mvvmbasic.model.Model

class ViewModelClass : BaseObservable() {
    private val model = Model()

    val number : String
        @Bindable
        get() {
            return model.number.toString()
        }

    val bool : String
        @Bindable
        get() {
            return (model.number % 2 == 0).toString()
        }

    fun onButtonClick() {
        ++model.number
//        notifyPropertyChanged(BR.number)
//        notifyPropertyChanged(BR.bool)
        notifyChange()
    }
}