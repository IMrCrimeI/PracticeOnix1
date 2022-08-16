package com.onix.internship.ui.selectPhoto

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.storage.ImageStorage

class SelectPhotoViewModel(private val storage: ImageStorage) : BaseViewModel() {
    private val _fromGallery = SingleLiveEvent<Unit>()
    val fromGallery: LiveData<Unit> = _fromGallery

    private val _fromCamera = SingleLiveEvent<Unit>()
    val fromCamera: LiveData<Unit> = _fromCamera

    fun pickPhotoFromGallery() {
        _fromGallery.value = Unit
    }

    fun pickPhotoFromCamera() {
        _fromCamera.value = Unit
    }

    fun saveImageToStorage(img: Bitmap) {
        storage.saveImage(img)
    }
}