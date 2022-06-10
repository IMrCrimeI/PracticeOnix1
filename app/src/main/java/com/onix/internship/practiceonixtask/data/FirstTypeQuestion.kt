package com.onix.internship.practiceonixtask.data

data class FirstTypeQuestion(
    override val questionText: String,
    override val answers: List<Answer>,
    val correctIndex: List<Int>
) : QuestionBaseClass()
