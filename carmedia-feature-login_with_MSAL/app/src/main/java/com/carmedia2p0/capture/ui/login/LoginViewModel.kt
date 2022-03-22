package com.carmedia2p0.capture.ui.login

import android.app.Application
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    repository: DataRepository
) : BaseViewModel(application, repository)
