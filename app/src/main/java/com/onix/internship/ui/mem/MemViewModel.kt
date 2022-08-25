package com.onix.internship.ui.mem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.arch.network.onFailure
import com.onix.internship.arch.network.onSuccess
import com.onix.internship.data.repository.MemRepository
import com.onix.internship.entity.MemInfo
import kotlinx.coroutines.launch

class MemViewModel(private val memRepository: MemRepository) : BaseViewModel() {

    private val _listOfMemes = MutableLiveData<List<MemInfo>>()
    val listOfMemes: LiveData<List<MemInfo>> = _listOfMemes

    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _openFilterPopup = SingleLiveEvent<Unit>()
    val openFilterPopup: LiveData<Unit> = _openFilterPopup

    private val currentList = mutableListOf<MemInfo>()
    private var currentPage = DEFAULT_PAGE

    init {
        getBirdListFromApi(currentPage)
        currentPage++
    }

    private fun getBirdListFromApi(page: Int) {
        viewModelScope.launch {
            memRepository.getMem(page)
                .onSuccess {
                    currentList.addAll(it)
                    _listOfMemes.postValue(currentList.toList())
                }
                .onFailure { _errorMessage.postValue(it.message) }
        }
    }

    fun filterCat() {

    }

    fun reloadRecycler() {
        currentList.clear()
        currentPage = 2
        getBirdListFromApi(DEFAULT_PAGE)
    }

    fun loadMore() {
        getBirdListFromApi(currentPage)
        currentPage++
    }

    fun openFilterPopup() {
        _openFilterPopup.value = Unit
    }

    companion object {
        const val DEFAULT_PAGE = 1
    }
}