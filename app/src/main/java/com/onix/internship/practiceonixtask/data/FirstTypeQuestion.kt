package com.onix.internship.practiceonixtask.data

data class FirstTypeQuestion(
    val answers: List<Answer>,
    val correctIndex: Int,
    val questionText: String
)