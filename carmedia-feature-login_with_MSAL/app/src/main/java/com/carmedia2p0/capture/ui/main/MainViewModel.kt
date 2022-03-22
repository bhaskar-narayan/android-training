package com.carmedia2p0.capture.ui.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.carmedia2p0.capture.CarMediaApplication
import com.carmedia2p0.capture.data.datastore.AppDataStore
import com.carmedia2p0.capture.model.GithubUser
import com.carmedia2p0.capture.repository.DataRepository
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: DataRepository,
    private val appDataStore: AppDataStore
) : BaseViewModel(application, repository) {

    val userName = MutableLiveData<GithubUser>()
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val resString = getApplication<CarMediaApplication>().resources

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            showLoading(true)
//            githubUserRepository.getGithubUser()
//                .catch {
//                    showLoading(false)
//                    onError(this.toString())
//                }
//                .collect {
//                    showLoading(false)
//                    userName.postValue(it)
//                }
//        }
//
//
//        viewModelScope.launch {
//            appDataStore.isLoggedIn.collect {
//                Log.d("vm", "IS LOGGED IN? => $it")
//            }
//        }

//    }

    init {
        viewModelScope.launch {
            delay(3000)
            _isLoading.value = false
        }
    }
}
