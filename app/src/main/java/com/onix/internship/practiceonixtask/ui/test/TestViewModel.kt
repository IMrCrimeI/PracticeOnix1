package com.onix.internship.practiceonixtask.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.practiceonixtask.data.FirstTypeQuestion
import com.onix.internship.practiceonixtask.data.SecondTypeQuestion

class TestViewModel(private val quizManager: QuizManager) : ViewModel() {

    private val _firstTypeQuestion = MutableLiveData<FirstTypeQuestion>()
    val firstTypeQuestion: LiveData<FirstTypeQuestion?> = _firstTypeQuestion

    private val _secondTypeQuestion = MutableLiveData<FirstTypeQuestion>()
    val secondTypeQuestion: LiveData<FirstTypeQuestion?> = _secondTypeQuestion

    private val _thirdTypeQuestion = MutableLiveData<SecondTypeQuestion>()
    val thirdTypeQuestion: LiveData<SecondTypeQuestion?> = _thirdTypeQuestion

    val model = TestModel()

    private val _move = MutableLiveData<Unit>()
    val move: LiveData<Unit> = _move

    init {
        _firstTypeQuestion.value = quizManager.getFirstTypeCurrentQuestion()
        _secondTypeQuestion.value = quizManager.getSecondTypeCurrentQuestion1()
        _thirdTypeQuestion.value = quizManager.getThirdTypeCurrentQuestion2()
    }

    fun chekAnswer() {
        quizManager.chekAnswer(
            model.firstTypeQuestionArray,
            model.secondTypeQuestionArray,
            model.inputAnswer
        )
        _move.value = Unit
    }

    fun writeFirstTypeQuestionIndex(index: Int, isChecked: Boolean) {
        with(model.firstTypeQuestionArray) {
            if (isChecked) {
                if (!contains(index)) {
                    add(index)
                }
            } else {
                if (contains(index)) {
                    remove(index)
                }
            }
        }
    }

    fun writeSecondTypeQuestionIndex(element: Int, isChecked: Boolean) {
        with(model.secondTypeQuestionArray) {
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