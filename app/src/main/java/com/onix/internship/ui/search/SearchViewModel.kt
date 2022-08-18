package com.onix.internship.ui.search

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.storage.SearchStorage

class SearchViewModel(private val searchStorage: SearchStorage) : BaseViewModel() {
    private val _goToResult = SingleLiveEvent<Unit>()
    val goToResult: LiveData<Unit> = _goToResult

    val model = SearchModel()

    fun startSearching() {
        searchStorage.saveRequest(model.gen.get() ?: " ")
        _goToResult.value = Unit
    }
}