package com.onix.internship.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _music = MutableLiveData<Boolean>()
    val music: LiveData<Boolean> = _music
    fun chekMusic(isChecked: Boolean) {
        _music.value = isChecked
    }
}