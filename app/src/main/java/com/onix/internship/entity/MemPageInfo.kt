package com.onix.internship.entity

data class MemPageInfo(
    val code: Int,
    val data: List<MemInfo>,
    val message: String,
    val next: String
)
