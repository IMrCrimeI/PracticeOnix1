package com.onix.internship.ui.result.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.entity.BirdInfo
import com.onix.internship.ui.result.MediaPlayerProvider

class DetailsViewModel(private val mediaPlayerProvider: MediaPlayerProvider) : BaseViewModel() {

    private val _downloadSong = MutableLiveData<BirdInfo>()
    val downloadSong : LiveData<BirdInfo> = _downloadSong

    private val _changeDrawable = MutableLiveData<Boolean>()
    val changeDrawable : LiveData<Boolean> = _changeDrawable

    fun playMusic(bird: BirdInfo) {
        _changeDrawable.value = changeDrawable.value != true
        mediaPlayerProvider.setNewRecording(bird)
    }

    fun stopMusic(){
        mediaPlayerProvider.stop()
    }

    fun downloadSong(bird: BirdInfo){
        _downloadSong.value = bird
    }
}