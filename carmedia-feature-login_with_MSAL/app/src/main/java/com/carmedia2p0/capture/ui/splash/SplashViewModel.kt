package com.carmedia2p0.capture.ui.splash

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @NonNull application: Application,
    private val repository: DataRepository
) : BaseViewModel(application, repository) {

    val yo = MutableLiveData<String>()
}
