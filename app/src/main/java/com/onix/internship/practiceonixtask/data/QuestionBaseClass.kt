package com.onix.internship.practiceonixtask.data

open class QuestionBaseClass {
    open val questionText: String = ""
    open val answers: List<Answer> = listOf(Answer(0,""))
}
