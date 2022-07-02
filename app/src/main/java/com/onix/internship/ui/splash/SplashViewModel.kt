package com.onix.internship.ui.splash

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.Transfer
import kotlinx.coroutines.delay

class SplashViewModel(transfer: Transfer) : BaseViewModel() {

    val initEvent = SingleLiveEvent<Boolean>()

    init {
        onLoading(true)
        launch {
            transfer.passDictionary()
            delay(1500)
            initEvent.postValue(true)
        }
    }

}