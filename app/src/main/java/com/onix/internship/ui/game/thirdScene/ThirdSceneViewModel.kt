package com.onix.internship.ui.game.thirdScene


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.GameResources

class ThirdSceneViewModel(private val gameResources: GameResources) : BaseViewModel() {
    private val _text = MutableLiveData(gameResources.merryDialog.firstOrNull())
    val text: LiveData<String?> = _text

    private val _bgId = MutableLiveData<Int>()
    val bgId: LiveData<Int> = _bgId

    private val _imageId = MutableLiveData<Int>()
    val imageId: LiveData<Int> = _imageId

    val openSettingFragment = SingleLiveEvent<Boolean>()
    val goToHome = SingleLiveEvent<Boolean>()
    private var counter = 0

    fun changeText() {
        when (counter) {
            1 -> _bgId.value = gameResources.backGroundId[3].resId
            5 -> _imageId.value = gameResources.characterId[3]
            7 -> _imageId.value = gameResources.characterId[6]
            9 -> _imageId.value = gameResources.characterId[5]
            11 -> _imageId.value = gameResources.characterId[4]
            14 -> _imageId.value = gameResources.characterId[6]
            15 -> _imageId.value = gameResources.characterId[3]
            19 -> _imageId.value = gameResources.characterId[6]
            20 -> {
                _imageId.value = null
                _bgId.value = null
            }
        }
        if (counter != gameResources.merryDialog.size) {
            _text.value = gameResources.merryDialog[counter]
            counter++
        } else goToHome.value = true
    }

    fun openSettings() {
        openSettingFragment.value = true
    }
}