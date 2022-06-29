package com.onix.internship.ui.translate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.ui.data.DictionaryItem
import com.onix.internship.ui.data.TranslationStorage

class TranslateViewModel(private val translationStorage: TranslationStorage) : BaseViewModel() {
    private val _translationLivaData = MutableLiveData<List<DictionaryItem>>()
    val translationLivaData: LiveData<List<DictionaryItem>> = _translationLivaData

    val initEvent = SingleLiveEvent<Boolean>()

    private val dictionary = translationStorage.getDictionary()

    var key = ""

    fun findTranslation() {
        translationStorage.clearResults()
        dictionary.forEach {
            if (it.key == key) {
                translationStorage.saveSearchingResults(it)
            }
        }
        _translationLivaData.value = translationStorage.getSearchingHistory()
        initEvent.value = true
    }
}