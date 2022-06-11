package com.onix.internship.practiceonixtask.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.practiceonixtask.ui.test.QuizManager

class ResultViewModelFactory(private val quizManager: QuizManager) : ViewModelProvider.Factory {
    override fun < T : ViewModel> create(modelClass: Class<T>): T {
        return ResultViewModel(quizManager) as T
    }
}