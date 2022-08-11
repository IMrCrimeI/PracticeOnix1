package com.onix.internship.data.storage

import android.graphics.Bitmap
import android.util.Log

class ImageStorage {
    private val imageList = mutableListOf<Bitmap>()

    fun saveImage(img: Bitmap) {
        imageList.add(img)
        Log.d("Debug1", imageList.toString())
    }

    fun getImg(): Bitmap {
        return imageList[imageList.lastIndex]
    }

    fun restoreImage(): Bitmap {
        return if (imageList.size != 1) {
            imageList.removeLast()
            imageList.last()
        } else {
            imageList[imageList.lastIndex]
        }
    }

    fun saveCroppedImage(img: Bitmap) {
        imageList.clear()
        imageList.add(img)
    }
}