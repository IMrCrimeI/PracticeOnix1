package com.onix.internship.data.repository

import com.onix.internship.data.PointItem

class Test {
    private val test = listOf(
        PointItem(0, "17.07.2004", "14:43", "Master", 3),
        PointItem(1, "18.07.2004", "14:44", "Player", 5)
    )

    fun getTest(): List<PointItem> {
        return test
    }
}