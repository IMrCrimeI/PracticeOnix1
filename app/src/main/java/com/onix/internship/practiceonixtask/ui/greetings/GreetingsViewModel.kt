package com.onix.internship.practiceonixtask.ui.greetings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GreetingsViewModel: ViewModel() {
    private val _move = MutableLiveData<Unit>()
    val move: LiveData<Unit> = _move

    fun goToTest(){
        _move.value = Unit
    }
}