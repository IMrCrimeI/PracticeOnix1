package com.onix.internship.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val age: Int = 0,
    val count: Int = 0,
    val name: String = ""
)
