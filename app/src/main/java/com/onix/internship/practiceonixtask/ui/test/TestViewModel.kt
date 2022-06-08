package com.onix.internship.practiceonixtask.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.practiceonixtask.data.FirstTypeQuestion
import com.onix.internship.practiceonixtask.data.SecondTypeQuestion
import com.onix.internship.practiceonixtask.data.ThirdTypeQuestion

class TestViewModel : ViewModel() {

    private val _firstTypeQuestion = MutableLiveData<FirstTypeQuestion>()
    val firstTypeQuestion: LiveData<FirstTypeQuestion?> = _firstTypeQuestion

    private val _secondTypeQuestion = MutableLiveData<SecondTypeQuestion>()
    val secondTypeQuestion: LiveData<SecondTypeQuestion?> = _secondTypeQuestion

    private val _thirdTypeQuestion = MutableLiveData<ThirdTypeQuestion>()
    val thirdTypeQuestion: LiveData<ThirdTypeQuestion?> = _thirdTypeQuestion

    val model = TestModel()

    private val _move = MutableLiveData<Unit>()
    val move: LiveData<Unit> = _move

    private val quizManager = QuizManager.getInstance()


    init {
        _firstTypeQuestion.value = quizManager.getCurrentQuestion()
        _secondTypeQuestion.value = quizManager.getCurrentQuestion1()
        _thirdTypeQuestion.value = quizManager.getCurrentQuestion2()
    }

    fun chekAnswer() {
        quizManager.chekAnswer(model.index, model.array, model.inputAnswer)
        _move.value = Unit
    }

    fun writeIndex(index: Int) {
        model.index = index
    }

    fun writeSecondIndex(element: Int, isChecked: Boolean) {
        with(model.array) {
            if (isChecked) {
                if (!contains(element)) {
                    add(element)
                }
            } else {
                if (contains(element)) {
                    remove(element)
                }
            }
        }
    }
}