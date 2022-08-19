package com.onix.internship.ui.result

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.arch.network.onFailure
import com.onix.internship.arch.network.onSuccess
import com.onix.internship.data.repository.BirdRepository
import com.onix.internship.entity.BirdInfo
import com.onix.internship.ui.result.adapter.OnBirdClickListener
import com.onix.internship.ui.search.SearchModel
import kotlinx.coroutines.launch

class ResultViewModel(
    private val birdRepository: BirdRepository,
    private val mediaPlayerProvider: MediaPlayerProvider
) : BaseViewModel(), OnBirdClickListener, MediaPlayer.OnBufferingUpdateListener {

    private val _listOfBird = MutableLiveData<List<BirdInfo>>()
    val listOfBird: LiveData<List<BirdInfo>> = _listOfBird

    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _goToDetails = SingleLiveEvent<BirdInfo>()
    val goToDetails: LiveData<BirdInfo> = _goToDetails

    val model = SearchModel()
    var currentItem: BirdInfo? = null

    init {
        mediaPlayerProvider.setListener(this)
    }

    fun stopMusic(){
        mediaPlayerProvider.stop()
    }

    fun getBirdListFromApi(searchQuery: String) {
        viewModelScope.launch {
            birdRepository.getBird(searchQuery)
                .onSuccess { _listOfBird.postValue(it) }
                .onFailure { _errorMessage.postValue(it.message) }
        }
    }

    override fun playPauseMusic(it: BirdInfo) {
        currentItem = it
        val newListOfBird = mutableListOf<BirdInfo>()
        _listOfBird.value?.forEach { bird ->
            if (bird.id == it.id && !bird.isPlaying) {
                newListOfBird.add(bird.copy(isPlaying = true))
            } else {
                newListOfBird.add(bird.copy(isPlaying = false))
            }
        }
        _listOfBird.value = newListOfBird
        mediaPlayerProvider.setNewRecording(it)
    }

    override fun showDetails(it: BirdInfo) {
        _goToDetails.value = it
    }

    override fun onBufferingUpdate(mp: MediaPlayer?, percent: Int) {

    }
}