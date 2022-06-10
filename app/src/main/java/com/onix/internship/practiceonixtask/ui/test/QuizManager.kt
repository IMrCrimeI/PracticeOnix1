package com.onix.internship.practiceonixtask.ui.test

import android.content.Context
import com.onix.internship.practiceonixtask.R
import com.onix.internship.practiceonixtask.data.Answer
import com.onix.internship.practiceonixtask.data.FirstTypeQuestion
import com.onix.internship.practiceonixtask.data.Index
import com.onix.internship.practiceonixtask.data.SecondTypeQuestion

class QuizManager(context: Context) {
    var index = Index(0, 0, 0)
    var counter = 0

    private val firstTypeQuestionList = listOf(
        FirstTypeQuestion(
            context.getString(R.string.first_question_of_the_first_type),
            listOf(
                Answer(1, context.getString(R.string.f_a_f_q_f_t)),
                Answer(2, context.getString(R.string.s_a_f_q_f_t)),
                Answer(3, context.getString(R.string.t_a_f_q_f_t))
            ),
            listOf(2)
        ),
        FirstTypeQuestion(
            context.getString(R.string.second_question_of_the_first_type),
            listOf(

                Answer(1, context.getString(R.string.f_a_s_q_f_t)),
                Answer(2, context.getString(R.string.s_a_s_q_f_t)),
                Answer(3, context.getString(R.string.t_a_s_q_f_t))
            ),
            listOf(3)
        ),
        FirstTypeQuestion(
            context.getString(R.string.third_question_of_the_first_type),
            listOf(

                Answer(1, context.getString(R.string.f_a_t_q_f_t)),
                Answer(2, context.getString(R.string.s_a_t_q_f_t)),
                Answer(3, context.getString(R.string.t_a_t_q_f_t))
            ),
            listOf(1)
        )
    )

    private val secondTypeQuestionList = listOf(
        FirstTypeQuestion(
            context.getString(R.string.first_question_of_the_second_type),
            listOf(
                Answer(1, context.getString(R.string.f_a_f_q_s_t)),
                Answer(2, context.getString(R.string.s_a_f_q_s_t)),
                Answer(3, context.getString(R.string.t_a_f_q_s_t)),
                Answer(4, context.getString(R.string.fr_a_f_q_s_t)),
                Answer(5, context.getString(R.string.ff_a_f_q_s_t)),
                Answer(6, context.getString(R.string.sx_a_f_q_s_t))
            ),
            arrayListOf(4, 6),
        ),
        FirstTypeQuestion(
            context.getString(R.string.second_question_of_the_second_type),
            listOf(
                Answer(1, context.getString(R.string.f_a_s_q_s_t)),
                Answer(2, context.getString(R.string.s_a_s_q_s_t)),
                Answer(3, context.getString(R.string.t_a_s_q_s_t)),
                Answer(4, context.getString(R.string.fr_a_s_q_s_t)),
                Answer(5, context.getString(R.string.ff_a_s_q_s_t)),
                Answer(6, context.getString(R.string.sx_a_s_q_s_t))
            ),
            arrayListOf(1, 2, 4)
        ),
        FirstTypeQuestion(
            context.getString(R.string.third_question_of_the_second_type),
            listOf(
                Answer(1, context.getString(R.string.f_a_t_q_s_t)),
                Answer(2, context.getString(R.string.s_a_t_q_s_t)),
                Answer(3, context.getString(R.string.t_a_t_q_s_t)),
                Answer(4, context.getString(R.string.fr_a_t_q_s_t)),
                Answer(5, context.getString(R.string.ff_a_t_q_s_t)),
                Answer(6, context.getString(R.string.sx_a_t_q_s_t))
            ),
            arrayListOf(3, 5, 6)
        )
    )

    private val thirdTypeQuestionList = listOf(
        SecondTypeQuestion(
            context.getString(R.string.first_question_of_the_third_type),
            context.getString(R.string.a_f_q_t_t)

        ),
        SecondTypeQuestion(
            context.getString(R.string.second_question_of_the_third_type),
            context.getString(R.string.a_s_q_t_t)

        ),
        SecondTypeQuestion(
            context.getString(R.string.third_question_of_the_third_type),
            context.getString(R.string.a_t_q_t_t)

        )
    )

    fun chekAnswer(
        firstCurrentIndex: ArrayList<Int>,
        secondCurrentIndex: ArrayList<Int>,
        answer: String
    ) {
        if (firstTypeQuestionList.size > index.firstIndex) {
            if (firstCurrentIndex.containsAll(firstTypeQuestionList[index.firstIndex].correctIndex)) {
                counter++
            }
        }
        if (secondTypeQuestionList.size > index.secondIndex) {
            if (secondCurrentIndex.containsAll(secondTypeQuestionList[index.secondIndex].correctIndex)) {
                counter++
            }
        }
        if (thirdTypeQuestionList.size > index.thirdIndex) {
            if (answer == thirdTypeQuestionList[index.thirdIndex].correctAnswer) {
                counter++
            }
        }

        index.firstIndex++
        index.secondIndex++
        index.thirdIndex++
    }

    fun getFirstTypeCurrentQuestion(): FirstTypeQuestion? {
        return if (index.firstIndex < firstTypeQuestionList.size) {
            firstTypeQuestionList[index.firstIndex]
        } else null
    }

    fun getSecondTypeCurrentQuestion1(): FirstTypeQuestion? {
        return if (index.secondIndex < secondTypeQuestionList.size) {
            secondTypeQuestionList[index.secondIndex]
        } else null
    }

    fun getThirdTypeCurrentQuestion2(): SecondTypeQuestion? {
        return if (index.thirdIndex < thirdTypeQuestionList.size) {
            thirdTypeQuestionList[index.thirdIndex]
        } else null
    }

    companion object {
        private var instance: QuizManager? = null

        fun getInstance(context: Context): QuizManager {
            return instance ?: QuizManager(context).also { instance = it }
        }
    }
}