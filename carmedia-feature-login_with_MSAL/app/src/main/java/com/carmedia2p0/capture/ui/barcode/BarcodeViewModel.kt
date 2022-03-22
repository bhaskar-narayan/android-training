package com.carmedia2p0.capture.ui.barcode

import android.app.Application
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BarcodeViewModel @Inject constructor(
    application: Application,
    private val repository: DataRepository
) : BaseViewModel(application, repository)
