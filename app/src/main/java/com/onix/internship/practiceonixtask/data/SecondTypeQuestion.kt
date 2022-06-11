package com.onix.internship.practiceonixtask.data

data class SecondTypeQuestion(
    override val questionText: String,
    val correctAnswer: String
): QuestionBaseClass()
