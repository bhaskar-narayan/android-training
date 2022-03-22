package com.carmedia2p0.capture.ui.main.home

import android.app.Application
import com.carmedia2p0.capture.CarMediaApplication
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    repository: DataRepository
) : BaseViewModel(application, repository) {
    private val resString = getApplication<CarMediaApplication>().resources
    companion object {
        const val TAG = "HomeViewModel"
    }
}
