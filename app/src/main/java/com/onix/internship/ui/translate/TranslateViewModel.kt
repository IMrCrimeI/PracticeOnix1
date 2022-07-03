package com.onix.internship.ui.translate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.R
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.DictionaryItem
import com.onix.internship.data.TranslationStorage

class TranslateViewModel(
    private val translationStorage: TranslationStorage,
) : BaseViewModel() {

    var languageChoice = false

    private val _translationLivaData = MutableLiveData<List<DictionaryItem>>()
    val translationLivaData: LiveData<List<DictionaryItem>> = _translationLivaData

    val language = MutableLiveData(R.string.uk_pol)

    val model = TranslateModel()

    val initEvent = SingleLiveEvent<Boolean>()

    private val dictionary = translationStorage.getDictionary()

    fun changeLanguage() {
        Log.d("Debug", translationStorage.choice.toString())
        Log.d("Debug", languageChoice.toString())
        when {
            !translationStorage.choice -> {
                translationStorage.choice = true
                languageChoice = true
                language.value = R.string.pol_uk
            }
            translationStorage.choice -> {
                translationStorage.choice = false
                languageChoice = false
                language.value = R.string.uk_pol
            }
        }
    }

    fun findTranslation() {
        translationStorage.clearResults()
        model.kay.lowercase()
        dictionary.forEach {
            when {
                !translationStorage.choice -> {
                    if (it.key == model.kay) {
                        translationStorage.saveSearchingResults(it)
                    }
                }
                else -> {
                    if (model.kay == it.value) {
                        translationStorage.saveSearchingResults(it)
                    }
                }
            }
        }
        _translationLivaData.value = translationStorage.getSearchingHistory()
        initEvent.value = true
    }
}