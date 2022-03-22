package com.carmedia2p0.capture.repository

import com.carmedia2p0.capture.data.network.api.CarmediaApi
import com.carmedia2p0.capture.model.GithubUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GithubUserRepository @Inject constructor(
    private val carmediaApi: CarmediaApi
) {

    fun getGithubUser(): Flow<GithubUser> {
        return carmediaApi.getData().map {
            it
//            if(it == 404){
//                throw Throwable("")
//            }
        }.flowOn(Dispatchers.IO)
    }
}
