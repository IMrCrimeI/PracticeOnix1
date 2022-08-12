package com.onix.internship.ui.editPhoto

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.entity.SeekBarStates

class EditPhotoViewModel : BaseViewModel() {
    private val _saveImageInFolder = MutableLiveData<Unit>()
    val saveImageInFolder: LiveData<Unit> = _saveImageInFolder

    private val _currentSliderValue = MutableLiveData(1f)
    val currentSliderValue: LiveData<Float> = _currentSliderValue

    private val seekBarStates = MutableLiveData(SeekBarStates.CONTRAST)
    private val lastEdit = MutableLiveData<SeekBarStates>()

    val model = EditPhotoModel()

    val isShadeEditing = ObservableBoolean()

    fun changeSeekBar(state: SeekBarStates) {
        lastEdit.value = state
        isShadeEditing.set(state == SeekBarStates.SHADE)
        when (state) {
            SeekBarStates.CONTRAST -> {
                _currentSliderValue.value = model.contrastValue.get()
            }
            SeekBarStates.BRIGHTNESS -> {
                _currentSliderValue.value = model.brightnessValue.get()
            }
            SeekBarStates.SATURATION -> {
                _currentSliderValue.value = model.saturationValue.get()
            }
            else -> {}
        }
        seekBarStates.value = state
    }

    fun restoreImage() {
        _currentSliderValue.value = DEFAULT_VALUE
        when (lastEdit.value) {
            SeekBarStates.CONTRAST -> {
                model.contrastValue.set(DEFAULT_VALUE)
            }
            SeekBarStates.BRIGHTNESS -> {
                model.brightnessValue.set(DEFAULT_VALUE)
            }
            SeekBarStates.SATURATION -> {
                model.saturationValue.set(DEFAULT_VALUE)
            }
            else -> {}
        }
    }

    fun saveImageInFolder() {
        _saveImageInFolder.value = Unit
    }

    fun onAttributeChanged(value: Float) {
        when (seekBarStates.value) {
            SeekBarStates.CONTRAST -> {
                model.contrastValue.set(value)
            }
            SeekBarStates.BRIGHTNESS -> {
                model.brightnessValue.set(value)
            }
            SeekBarStates.SATURATION -> {
                model.saturationValue.set(value)
            }
            else -> {}
        }
    }

    fun saveLastEdit() {

    }

    companion object {
        const val DEFAULT_VALUE = 1f
    }
}