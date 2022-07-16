package com.onix.internship.ui.documentTab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.Repository
import com.onix.internship.data.WeeksItem

class EmptyTaskViewModel(repository: Repository) : BaseViewModel() {

    private val _weeksLiveData = MutableLiveData(repository.getWeeksItem())
    val weeksLiveData: LiveData<List<WeeksItem>> = _weeksLiveData

    val openCalendar = SingleLiveEvent<Unit>()

    fun openCalendar() {
        openCalendar.value = Unit
    }
}