package com.onix.internship.data.repository

import com.onix.internship.data.PointItem
import com.onix.internship.data.UserRole

class Test {
    private val test = listOf(
        PointItem(0, " 17.07.2004 ", " 14:43", UserRole.MASTER, 3),
        PointItem(1, " 18.07.2004 ", " 14:44", UserRole.PLAYER, 5)
    )

    fun getTest(): List<PointItem> {
        return test
    }
}