package com.onix.internship.ui.display

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class DisplayViewModel : BaseViewModel() {
    val initEvent = SingleLiveEvent<Unit>()

    fun goToChoice() {
        initEvent.value = Unit
    }
}