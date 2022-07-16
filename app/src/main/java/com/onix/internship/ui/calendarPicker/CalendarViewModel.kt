package com.onix.internship.ui.calendarPicker

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class CalendarViewModel : BaseViewModel() {

    val backToFragment = SingleLiveEvent<Boolean>()

    fun backToAddTask(it: Boolean) {
        backToFragment.value = it
    }
}