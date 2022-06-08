package com.onix.internship.practiceonixtask.ui.test

import com.onix.internship.practiceonixtask.data.Answer
import com.onix.internship.practiceonixtask.data.FirstTypeQuestion
import com.onix.internship.practiceonixtask.data.SecondTypeQuestion
import com.onix.internship.practiceonixtask.data.ThirdTypeQuestion

class QuizManager {

    var firstIndex = 0
    var secondIndex = 0
    var thirdIndex = 0
    var counter = 0

    private val firstTypeQuestionList = listOf(
        FirstTypeQuestion(
            listOf(
                Answer(1, "4"), Answer(2, "5"),
                Answer(3, "6")
            ),
            2, "Сколько океанов на нашей планете?"
        ),
        FirstTypeQuestion(
            listOf(

                Answer(1, "Вольт"), Answer(2, "Ватт"),
                Answer(3, "Ампер")
            ),
            3, "Единица измерения силы тока?"
        ),
        FirstTypeQuestion(
            listOf(

                Answer(1, "Амазонка"), Answer(2, "Нил"),
                Answer(3, "Янцзы")
            ),
            1, "Самая длинная река в мире?"
        )
    )

    private val secondTypeQuestionList = listOf(
        SecondTypeQuestion(
            listOf(
                Answer(1, "Медведь"), Answer(2, "Скиний кит"),
                Answer(3, "Жираф"), Answer(4, "Лосось"),
                Answer(5, "Панда"), Answer(6, "Осьминог")
            ),
            arrayListOf(4, 6), "Кто не отсносится к млекопитающим?"
        ),
        SecondTypeQuestion(
            listOf(
                Answer(1, "Правильная экспозиция"),
                Answer(2, "Композиция кадра"),
                Answer(3, "Авторскач задумка"),
                Answer(4, "Правильная освещонность сцены"),
                Answer(5, "Фотоаппарат"),
                Answer(6, "Время сьемки")
            ),
            arrayListOf(1, 2, 4), "Что самое важное в хорошей фотографии?"
        ),
        SecondTypeQuestion(
            listOf(
                Answer(1, "Кто это спрашивет?"), Answer(2, "6"),
                Answer(3, "4.0"), Answer(4, "1+1+1+1"),
                Answer(5, "4"), Answer(6, "Четыре")
            ),
            arrayListOf(3, 5, 6), "2+2?"
        )
    )

    private val thirdTypeQuestionList = listOf(
        ThirdTypeQuestion(
            "Из-за наклона земной оси",
            "Почему времена года сменяют друг друга?(Из-за ...)"
        ),
        ThirdTypeQuestion(
            "46",
            "Сколько хромосом в геноме человека?"
        ),
        ThirdTypeQuestion(
            "Ножницы",
            "Два кольца, два конца, посередине гвоздик, что это)))?"
        )
    )

    fun chekAnswer(firstCurrentIndex: Int, seccondCurrentIndex: ArrayList<Int>, answer: String) {
        if (firstTypeQuestionList.size > firstIndex) {
            if (firstCurrentIndex == firstTypeQuestionList[firstIndex].correctIndex) {
                counter++
            }
        }
        if (secondTypeQuestionList.size > secondIndex) {
            if (seccondCurrentIndex.containsAll(secondTypeQuestionList[secondIndex].correctIndex)) {
                counter++
            }
        }
        if (thirdTypeQuestionList.size > thirdIndex) {
            if (answer == thirdTypeQuestionList[thirdIndex].correctAnswer) {
                counter++
            }
        }

        firstIndex++
        secondIndex++
        thirdIndex++
    }

    fun getCurrentQuestion(): FirstTypeQuestion? {
        return if (firstIndex < firstTypeQuestionList.size) {
            firstTypeQuestionList[firstIndex]
        } else null
    }

    fun getCurrentQuestion1(): SecondTypeQuestion? {
        return if (secondIndex < secondTypeQuestionList.size) {
            secondTypeQuestionList[secondIndex]
        } else null
    }

    fun getCurrentQuestion2(): ThirdTypeQuestion? {
        return if (thirdIndex < thirdTypeQuestionList.size) {
            thirdTypeQuestionList[thirdIndex]
        } else null
    }

    fun test() {
    }

    companion object {
        private var instance: QuizManager? = null

        fun getInstance(): QuizManager {
            return instance ?: QuizManager().also { instance = it }
        }
    }
}