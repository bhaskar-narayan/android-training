// package com.wildforkfoods.food.base.livedata
//
// import android.annotation.SuppressLint
// import android.content.Context
// import android.util.Log
// import androidx.lifecycle.MutableLiveData
// import com.google.gson.Gson
// import com.snippet.kindle.livedata.LiveDataEvent
// import com.snippet.kindle.network.Resource
// import com.snippet.kindle.repository.DataRepository
// import com.wildforkfoods.food.R
// import com.wildforkfoods.food.core.schedulers.resource.Resource
// import com.wildforkfoods.food.data.WFFAppPreferences
// import com.wildforkfoods.food.livedata.LiveDataEvent
// import com.wildforkfoods.food.model.response.inventory.Inventory
// import com.wildforkfoods.food.model.response.inventory.InventoryResponse
// import com.wildforkfoods.food.repository.DataRepository
// import kotlinx.coroutines.*
// import javax.inject.Inject
//
// class ZipCodeLiveData @Inject constructor(private val context: Context,private val dataRepository: DataRepository) : MutableLiveData<LiveDataEvent<Resource<List<Inventory>>>>() {
//
//    private val tag = "ZipCodeLiveData"
//    private val dISTANCE ="20"
//
//
//
//    @SuppressLint("LogNotTimber")
//    val handler:CoroutineExceptionHandler = CoroutineExceptionHandler{ _, exception ->
//        Log.d(tag,exception.message ?: context.getString(R.string.something_went_wrong))
//    }
//
//    fun locateZipcode(zipcode:String){
//        postValue(LiveDataEvent(Resource.Loading()))
//        val parentJob =CoroutineScope(Dispatchers.IO).launch(handler) {
//            val zipcodeStore =async {
//                val response= dataRepository.locateZipCode(zipcode,dISTANCE)
//                if(response!!.isSuccessful) {
//                    response.body()!!.store }
//                else{
//                    throw Exception("does not exist in DB")
//                }
//            }.await()
//
//
//            val inventoryResponse = async {
//                val response= dataRepository.getZipCodeInventory(zipcodeStore?.id!!)
//                if (response!!.isSuccessful) {
//                    response.body()!!.apply {
//                        if(this.isEmpty()){
//                            throw Exception("does not exist in DB")
//                        }
//                        saveInventory(this)
//                        onLocateStoreSuccess(zipcode)
//                        postValue(LiveDataEvent(Resource.Success(this)))
//
//
//                    }
//                } else {
//                    throw Exception("does not exist in DB")
//                }
//            }.await()
//
//
//        }
//        parentJob.invokeOnCompletion { throwable->
//            if (throwable != null) {
//                if (throwable.message!!.contains("does not exist in DB")) {
//                    onLocateStoreFailed(zipcode)
//                }
//                postValue(LiveDataEvent(Resource.Failure(throwable)))
//            }
//        }
//    }
//
//    private fun onLocateStoreSuccess(zipCode: String) {
//        WFFAppPreferences.zipCode = zipCode
//        WFFAppPreferences.isdeliveryavailable = true
//
//    }
//
//
//    private fun onLocateStoreFailed(zip: String) {
//        WFFAppPreferences.inventory = ""
//        WFFAppPreferences.zipCode = zip
//        WFFAppPreferences.isdeliveryavailable = false
//    }
//
//    private fun saveInventory(inventoryList: List<Inventory>) {
//        val inventoryResponse = InventoryResponse()
//        inventoryResponse.inventories = inventoryList
//        val gson = Gson()
//        val inventoryListJson = gson.toJson(inventoryResponse)
//        WFFAppPreferences.inventory = inventoryListJson
//    }
//
// }
