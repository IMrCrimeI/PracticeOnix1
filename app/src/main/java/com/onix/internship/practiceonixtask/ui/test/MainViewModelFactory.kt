package com.onix.internship.practiceonixtask.ui.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val quizManager: QuizManager) : ViewModelProvider.Factory {
    override fun < T : ViewModel> create(modelClass: Class<T>): T {
        return TestViewModel(quizManager) as T
    }
}