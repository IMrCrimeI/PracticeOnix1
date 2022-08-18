package com.onix.internship.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.arch.network.onFailure
import com.onix.internship.arch.network.onSuccess
import com.onix.internship.data.repository.BirdRepository
import com.onix.internship.data.storage.BirdDetailsStorage
import com.onix.internship.data.storage.SearchStorage
import com.onix.internship.entity.BirdInfo
import com.onix.internship.ui.result.adapter.OnBirdClickListener
import kotlinx.coroutines.launch

class ResultViewModel(
    private val birdDetailsStorage: BirdDetailsStorage,
    private val birdRepository: BirdRepository,
    private val searchStorage: SearchStorage,
    private val mediaPlayerProvider: MediaPlayerProvider
) : BaseViewModel(), OnBirdClickListener {

    private val _listOfBird = MutableLiveData<List<BirdInfo>>()
    val listOfBird: LiveData<List<BirdInfo>> = _listOfBird

    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _goToDetails = SingleLiveEvent<Unit>()
    val goToDetails: LiveData<Unit> = _goToDetails

    init {
        viewModelScope.launch {
            birdRepository.getBird(searchStorage.getRequest())
                .onSuccess { _listOfBird.postValue(it) }
                .onFailure { _errorMessage.postValue(it.message) }
        }
    }

    override fun playPauseMusic(it: BirdInfo) {
        mediaPlayerProvider.setNewRecording(it)
        mediaPlayerProvider.playPause()
    }

    override fun showDetails(it: BirdInfo) {
        birdDetailsStorage.saveBirdDetails(it)
        _goToDetails.value = Unit
    }
}