package com.onix.internship.data

import android.graphics.Color
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import kotlin.random.Random

class Repository {
    private val rnd = Random
    private var tagsId = 0

    private val weeksItem = listOf(
        WeeksItem(0, "MO", "12"),
        WeeksItem(1, "TU", "13"),
        WeeksItem(2, "WE", "14"),
        WeeksItem(3, "TH", "15"),
        WeeksItem(4, "FR", "16"),
        WeeksItem(5, "SA", "17"),
        WeeksItem(6, "SU", "18")
    )

    fun getWeeksItem(): List<WeeksItem> {
        return weeksItem
    }

    private val tagsItem = mutableListOf<TagsItem>()

    fun addTagsItem(tagsName: String?) {
        val bgColor: Int = Color.argb(70, rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200))
        val textColor: Int = Color.argb(255, bgColor.red, bgColor.green, bgColor.blue)
        tagsItem.add(TagsItem(tagsId, tagsName, textColor, bgColor))
        tagsId++
    }

    fun getTagsItem(): List<TagsItem> {
        return tagsItem.toList()
    }
}