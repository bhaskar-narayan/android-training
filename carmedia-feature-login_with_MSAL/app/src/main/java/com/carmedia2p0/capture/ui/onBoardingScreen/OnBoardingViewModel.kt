package com.carmedia2p0.capture.ui.onBoardingScreen

import android.app.Application
import com.carmedia2p0.capture.data.datastore.AppDataStore
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    application: Application,
    private val repository: DataRepository,
    private val appDataStore: AppDataStore
) : BaseViewModel(application, repository)
