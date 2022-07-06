package com.onix.internship.ui.game.secondScene

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.R
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.DialogueList

class SecondSceneViewModel(private val dialogueList: DialogueList) : BaseViewModel() {
    private val _text = MutableLiveData(dialogueList.rightAwayDialog.firstOrNull())
    val text: LiveData<String?> = _text

    private val _bgId = MutableLiveData(R.drawable.bg_uni)
    val bgId: LiveData<Int> = _bgId

    private val _imageId = MutableLiveData(R.drawable.sylvie_green_smile)
    val imageId: LiveData<Int> = _imageId

    val openSettingFragment = SingleLiveEvent<Boolean>()
    val goToNextFragment = SingleLiveEvent<Boolean>()
    val visible = MutableLiveData(false)
    private var bookIsChoice = 0
    private var counter = 0
    private var bookCounter = 0


    fun changeText() {
        when (counter) {
            5 -> {
                _bgId.value = R.drawable.bg_meadow
                _imageId.value = null
            }
            9 -> _imageId.value = R.drawable.sylvie_green_smile
            13 -> _imageId.value = R.drawable.sylvie_green_surprised
            15 -> {
                _imageId.value = R.drawable.sylvie_green_smile
                visible.value = true
            }
        }
        if (counter != dialogueList.rightAwayDialog.size) {
            _text.value = dialogueList.rightAwayDialog[counter]
            counter++
        }

        if (bookCounter != dialogueList.bookIsChoiceDialog.size) {
            when (bookIsChoice) {
                1 -> {
                    _text.value = dialogueList.bookIsChoiceDialog[bookCounter]
                    bookCounter++
                }
                2 -> {
                    _text.value = dialogueList.bookIsNotChoiceDialog[bookCounter]
                    bookCounter++
                }
            }
        } else goToNextFragment.value = true
    }

    fun openSettings() {
        openSettingFragment.value = true
    }

    fun checkBook(it: Int) {
        bookIsChoice = it
        visible.value = false
        changeText()
    }
}