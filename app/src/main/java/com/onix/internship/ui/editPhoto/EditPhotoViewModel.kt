package com.onix.internship.ui.editPhoto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.entity.SeekBarStates

class EditPhotoViewModel : BaseViewModel() {
    private val _saveImageInFolder = MutableLiveData<Unit>()
    val saveImageInFolder : LiveData<Unit> = _saveImageInFolder

    private val _restoreImage = MutableLiveData<Unit>()
    val restoreImage : LiveData<Unit> = _restoreImage

    val test = MutableLiveData(SeekBarStates.CONTRAST)

    fun changeSeekBar(state: SeekBarStates) {
        test.value = state
    }

    fun restoreImage() {
        _restoreImage.value = Unit
    }

    fun saveImageInFolder(){
        _saveImageInFolder.value = Unit
    }
}