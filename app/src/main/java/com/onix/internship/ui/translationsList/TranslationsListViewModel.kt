package com.onix.internship.ui.translationsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.ui.data.DictionaryItem
import com.onix.internship.ui.data.TranslationStorage

class TranslationsListViewModel(storage: TranslationStorage) : BaseViewModel() {
    private val _translationLivaData = MutableLiveData<List<DictionaryItem>>()
    val translationLivaData: LiveData<List<DictionaryItem>> = _translationLivaData

    init {
        _translationLivaData.value = storage.getSearchingResults()
    }
}
