package com.onix.internship.ui.game.secondScene

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.R
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.GameResources

class SecondSceneViewModel(private val gameResources: GameResources) : BaseViewModel() {
    private val _text = MutableLiveData(gameResources.rightAwayDialog.firstOrNull())
    val text: LiveData<String?> = _text

    private val _bgId = MutableLiveData(R.drawable.bg_uni)
    val bgId: LiveData<Int> = _bgId

    private val _imageId = MutableLiveData(gameResources.characterId[1])
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
                _bgId.value = gameResources.backGroundId[4].resId
                _imageId.value = gameResources.characterId[7]
            }
            9 -> _imageId.value = gameResources.characterId[1]
            13 -> _imageId.value = gameResources.characterId[2]
            15 -> {
                _imageId.value = gameResources.characterId[1]
                visible.value = true
            }
        }
        if (counter != gameResources.rightAwayDialog.size) {
            _text.value = gameResources.rightAwayDialog[counter]
            counter++
        }

        if (bookCounter != gameResources.bookIsChoiceDialog.size) {
            when (bookIsChoice) {
                1 -> {
                    _text.value = gameResources.bookIsChoiceDialog[bookCounter]
                    bookCounter++
                }
                2 -> {
                    _text.value = gameResources.bookIsNotChoiceDialog[bookCounter]
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