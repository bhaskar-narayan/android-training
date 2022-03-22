package com.carmedia2p0.capture.data.network.retrofitmanager

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import com.carmedia2p0.capture.data.network.api.CarmediaApi
import com.carmedia2p0.capture.utils.livedata.EventObject
import javax.inject.Inject

open class ApiManager @Inject constructor(private val carmediaApi: CarmediaApi) {
    private var apiResponseEvent: MediatorLiveData<EventObject> = MediatorLiveData()
    private val TAG: String = ApiManager::class.java.simpleName

    /**
     * This implementation create retrofit client for API Server. Its enable self signed certificate of HTTPS server.
     */

    fun getApiResponseEvent(): MediatorLiveData<EventObject>? {
        return apiResponseEvent
    }

    private fun updateAPIResponseEvent(eventObject: EventObject) {
        Log.d(TAG, "updateAPIResponseEvent")
        apiResponseEvent!!.setValue(eventObject)
    }

// //    example
//    suspend fun locateZipCode(zipCode: String, distance: String): Response<ZipCodeResponse>? {
//        return mWildForkApi.locateZipCode(zipCode, distance)
//    }

// //    example
//    fun getInventory(storeId: String?, zipCode: String?) {
//        val event= EventObject(
//            EventCenter.GET_INVENTORY_RESPONSE,
//            mWildForkApi!!.getInventory(storeId),
//            zipCode!!
//        )
//        updateAPIResponseEvent(event)
//    }
}
