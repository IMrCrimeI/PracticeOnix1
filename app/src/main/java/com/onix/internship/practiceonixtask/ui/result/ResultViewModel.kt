package com.onix.internship.practiceonixtask.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.practiceonixtask.ui.test.QuizManager

class ResultViewModel(private val quizManager: QuizManager) : ViewModel() {
    private val _move = MutableLiveData<Unit>()
    val move: LiveData<Unit> = _move

//    private val quizManager = QuizManager.getInstance()

    fun backToHome() {
        _move.value = Unit
    }

    fun clearIndexAndCounter() {
        quizManager.index.firstIndex = 0
        quizManager.index.secondIndex = 0
        quizManager.index.thirdIndex = 0
        quizManager.counter = 0
    }
}