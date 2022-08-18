package com.onix.internship.ui.advanced_search

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class AdvancedSearchViewModel : BaseViewModel() {
    private val _goToResult = SingleLiveEvent<Unit>()
    val goToResult: LiveData<Unit> = _goToResult

    fun startSearching() {
        _goToResult.value = Unit
    }
}