package com.onix.internship.ui.splash

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.ui.data.Bind
import kotlinx.coroutines.delay

class SplashViewModel(bind: Bind) : BaseViewModel() {

    val initEvent = SingleLiveEvent<Boolean>()

    init {
        onLoading(true)
        launch {
            bind.bindData()
            delay(1500)
            initEvent.postValue(true)
        }
    }

}