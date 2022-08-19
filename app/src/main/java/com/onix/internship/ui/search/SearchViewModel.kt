package com.onix.internship.ui.search

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class SearchViewModel : BaseViewModel() {
    private val _goToResult = SingleLiveEvent<String>()
    val goToResult: LiveData<String> = _goToResult

    val model = SearchModel()

    fun startSearching() {
        _goToResult.value = if (model.gen.get() == null) {
            DEFAULT_VALUE
        } else {
            model.gen.get()
        }
    }

    companion object{
        const val DEFAULT_VALUE = " "
    }
}