package com.onix.internship.practiceonixtask.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.practiceonixtask.ui.test.QuizManager

class ResultViewModel: ViewModel() {
    private val _move = MutableLiveData<Unit>()
    val move: LiveData<Unit> = _move

    private val quizManager = QuizManager.getInstance()


    fun backToHome(){
        _move.value = Unit
    }

    fun clearIndexAndCounter(){
        quizManager.firstIndex = 0
        quizManager.secondIndex = 0
        quizManager.thirdIndex = 0
        quizManager.counter = 0
    }
}