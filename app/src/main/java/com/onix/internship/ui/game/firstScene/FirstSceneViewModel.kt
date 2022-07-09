package com.onix.internship.ui.game.firstScene

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.GameResources

class FirstSceneViewModel(val gameResources: GameResources) : BaseViewModel() {
    private val _text = MutableLiveData(gameResources.startDialog.firstOrNull())
    val text: LiveData<String?> = _text

    private val _bgId = MutableLiveData<Int>()
    val bgId: LiveData<Int> = _bgId

    private val _imageId = MutableLiveData<Int>()
    val imageId: LiveData<Int> = _imageId

    val openSettingFragment = SingleLiveEvent<Boolean>()
    val goToNextFragment = SingleLiveEvent<Boolean>()
    val visible = MutableLiveData(false)
    private var counter = 0

    fun changeText() {
        when (counter) {
            4 -> _bgId.value = gameResources.backGroundId[2].resId
            5 -> _imageId.value = gameResources.characterId[0]
            7 -> visible.value = true
        }
        if (counter != gameResources.startDialog.size) {
            _text.value = gameResources.startDialog[counter]
            counter++
        }
    }

    fun openSettings() {
        openSettingFragment.value = true
    }

    fun goToNextFragment(it: Boolean) {
        goToNextFragment.value = it
    }
}