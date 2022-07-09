package com.onix.internship.ui.game.secondSceneAlternate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.R
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.GameResources

class SecondSceneAlternateViewModel(private val gameResources: GameResources) : BaseViewModel() {
    private val _text = MutableLiveData(gameResources.laterDialog.firstOrNull())
    val text: LiveData<String?> = _text

    private val _bgId = MutableLiveData(R.drawable.bg_uni)
    val bgId: LiveData<Int> = _bgId

    val openSettingFragment = SingleLiveEvent<Boolean>()
    val goToHome = SingleLiveEvent<Boolean>()
    private var counter = 0

    fun changeText() {
        when (counter) {
            1 -> _bgId.value = null
        }
        if (counter != gameResources.laterDialog.size) {
            _text.value = gameResources.laterDialog[counter]
            counter++
        } else goToHome.value = true
    }

    fun openSettings() {
        openSettingFragment.value = true
    }
}