package com.carmedia2p0.capture.repository

import androidx.lifecycle.MediatorLiveData
import com.carmedia2p0.capture.data.db.ArticleDao
import com.carmedia2p0.capture.data.network.api.CarmediaApi
import com.carmedia2p0.capture.model.response.getInventory.GetInventoryResponse
import com.carmedia2p0.capture.utils.livedata.EventObject
import com.carmedia2p0.capture.utils.livedata.LiveDataEvent
import retrofit2.Response
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val articleDao: ArticleDao,
    private val carmediaApi: CarmediaApi
) {
    private val TAG = DataRepository::class.java.simpleName
    private var mBroadcastEvent: MediatorLiveData<LiveDataEvent<EventObject>> = MediatorLiveData()

    init {
        subscribeToAPIManager()
    }

    fun getBroadCastEvent(): MediatorLiveData<LiveDataEvent<EventObject>> {
        return mBroadcastEvent
    }
    fun updateBroadCastEvent(event: Int, vararg value: Any?) {
        mBroadcastEvent.value = LiveDataEvent(EventObject(event, value))
    }

    // example to get Common Event
    private fun subscribeToAPIManager() {
//        apiManager.getApiResponseEvent()?.observeForever{ eventObject ->
//            if (eventObject == null) {
//                return@observeForever
//            }
//            when (eventObject.key) {
//                EventCenter.RESPONSE_GET_RECOMMENDED_SONGS -> handleGetRecommendedItem(
//                    eventObject.getValue().get(0) as HCLResponse
//                )
//            }
//        }
    }

// //   api example
//    suspend fun locateZipCode(zipCode: String, distance: String): Response<ZipCodeResponse>? {
//        return apiManager.locateZipCode(zipCode, distance)
//    }

//    db example
//    suspend fun upsertArticle(article: Article) = articleDao.upsert(article)
//    fun getSavedNews()=articleDao.getAllArticles()
//    suspend fun deleteNews(article: Article)= articleDao.deleteArticle(article)

    suspend fun getInventory(): Response<GetInventoryResponse> {
        return carmediaApi.getInventory()
    }
}
