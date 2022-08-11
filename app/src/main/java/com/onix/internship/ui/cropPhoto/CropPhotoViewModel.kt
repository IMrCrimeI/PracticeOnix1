package com.onix.internship.ui.cropPhoto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel

class CropPhotoViewModel : BaseViewModel() {
    private val _ratioEvent = MutableLiveData<Pair<Int, Int>>()
    val ratioEvent: LiveData<Pair<Int, Int>> = _ratioEvent

    private val _cropEvent = MutableLiveData<Unit>()
    val cropEvent: LiveData<Unit> = _cropEvent

    private val _saveEvent = MutableLiveData<Unit>()
    val saveEvent: LiveData<Unit> = _saveEvent

    private val _restoreEvent = MutableLiveData<Unit>()
    val restoreEvent: LiveData<Unit> = _restoreEvent

    fun onClickRatio(width: Int, height: Int) {
        _ratioEvent.value = Pair(width, height)
    }

    fun onClickCrop() {
        _cropEvent.value = Unit
    }

    fun onClickSave() {
        _saveEvent.value = Unit
    }

    fun onClickRestore() {
        _restoreEvent.value = Unit
    }
}