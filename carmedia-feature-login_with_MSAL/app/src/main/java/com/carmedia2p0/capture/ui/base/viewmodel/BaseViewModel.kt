package com.carmedia2p0.capture.ui.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.utils.livedata.EventObject
import com.carmedia2p0.capture.utils.livedata.LiveDataEvent

open class BaseViewModel(application: Application, private val repository: DataRepository) : AndroidViewModel(application) {
    var errorLiveData: MutableLiveData<LiveDataEvent<String>> = MutableLiveData()
    fun onError(error: String) {
        errorLiveData.postValue(LiveDataEvent(error))
    }

    var messageLiveData: MutableLiveData<LiveDataEvent<String>> = MutableLiveData()
    fun showMessage(message: String) {
        messageLiveData.postValue(LiveDataEvent(message))
    }

    var loadingLiveData: MutableLiveData<LiveDataEvent<Boolean>> = MutableLiveData()
    fun showLoading(visible: Boolean) {
        loadingLiveData.postValue(LiveDataEvent(visible))
    }

    private var mBroadcastEvent: LiveData<LiveDataEvent<EventObject>>? = null

    init {
        this.mBroadcastEvent = repository.getBroadCastEvent()
    }

    override fun onCleared() {
        super.onCleared()
    }
}
