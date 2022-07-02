package com.onix.internship.ui.translationsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.DictionaryItem
import com.onix.internship.data.TranslationStorage

class ResultsListViewModel(storage: TranslationStorage) : BaseViewModel() {
    private val _translationLivaData = MutableLiveData<List<DictionaryItem>>()
    val translationLivaData: LiveData<List<DictionaryItem>> = _translationLivaData

    val languageChoice = storage.choice

    init {
        if (storage.getSearchingResults() == listOf<DictionaryItem>()) {
            _translationLivaData.value = listOf(DictionaryItem("Error", "Перевод не найден или такого перевода нет"))
        } else _translationLivaData.value = storage.getSearchingResults()
    }
}
