package com.onix.internship.ui.game.thirdScene

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.R
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.DialogueList

class ThirdSceneViewModel(private val dialogueList: DialogueList) : BaseViewModel() {
    private val _text = MutableLiveData(dialogueList.merryDialog.firstOrNull())
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
            1 -> _bgId.value = R.drawable.bg_club
            5 -> _imageId.value = R.drawable.sylvie_blue_normal
            7 -> _imageId.value = R.drawable.sylvie_blue_giggle
            9 -> _imageId.value = R.drawable.sylvie_blue_surprised
            11 -> _imageId.value = R.drawable.sylvie_blue_smile
            14 -> _imageId.value = R.drawable.sylvie_blue_giggle
            15 -> _imageId.value = R.drawable.sylvie_blue_normal
            19 -> _imageId.value = R.drawable.sylvie_blue_giggle
            20 -> {
                _imageId.value = null
                _bgId.value = null
            }
        }
        if (counter != dialogueList.merryDialog.size) {
            _text.value = dialogueList.merryDialog[counter]
            counter++
        } else goToHome.value = true
    }

    fun openSettings() {
        openSettingFragment.value = true
    }
}