package com.siddydevelops.baseapplication._base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseViewModel() : ViewModel(), CoroutineScope {

    private val job = Job()

//    var state = MutableLiveData<GenericResponse<*>>()
//    val errorMessage = MutableLiveData<String>()
//    val retry = MutableLiveData<() -> Unit>()
//
//    var showLoader = MutableLiveData(false)
//    var intentToLoginPhone = MutableLiveData(false)
//    var isPagination = MutableLiveData(false)
//    var networkCallStatusLiveData = MutableLiveData<NetworkCallStatus>()
//
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
//
//    override fun onCleared() {
//        super.onCleared()
//        job.cancel()
//    }
//
//    fun isValidNetwork(): Boolean {
//        return NetworkAvailability.isNetworkAvailable()
//    }
//
//    fun <T : Any> apiSuccess(result: UseCaseResult<GenericResponse<T>>) {
//        when (result) {
//            is UseCaseResult.Success -> {
//                if (result.data.code == 200) {
//                    state.value = result.data
//                    showLoader.value = false
//                    if (result.data.data.toJson().length < 15) {
//                        isPagination.value = true
//                    }
//                } else if(result.data.code == 204) {
//                    intentToLoginPhone.value = true
//                } else if (result.data.code != 0 && result.data.code >= 400) {
//                    if (!result.data.message.isNullOrEmpty()) {
//                        showLoader.value = false
//                        errorMessage.value = result.data.message.toString()
//                        networkCallStatusLiveData.postValue(NetworkCallStatus.FAILED)
//                    }
//                }
//            }
//            is UseCaseResult.Exception -> {
//                errorMessage.value = result.exception.message
//                Timber.e("Exception  ${result.exception.printStackTrace()}")
//            }
//        }
//    }

}