package com.onix.internship.ui.timePicker

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class TimeDialogViewModel : BaseViewModel() {

    val backToFragment = SingleLiveEvent<Boolean>()

    fun backToAddTask(it: Boolean) {
        backToFragment.value = it
    }
}