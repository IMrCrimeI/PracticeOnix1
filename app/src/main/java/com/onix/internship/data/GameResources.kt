package com.onix.internship.data

import android.content.Context
import com.onix.internship.R

class GameResources(context: Context) {
    val startDialog: Array<String> = context.resources.getStringArray(R.array.startDialog)
    val rightAwayDialog: Array<String> = context.resources.getStringArray(R.array.rightAwayDialog)
    val bookIsChoiceDialog: Array<String> =
        context.resources.getStringArray(R.array.bookIsChoiceDialog)
    val bookIsNotChoiceDialog: Array<String> =
        context.resources.getStringArray(R.array.bookIsNotChoiceDialog)
    val merryDialog: Array<String> = context.resources.getStringArray(R.array.merryDialog)
    val laterDialog: Array<String> = context.resources.getStringArray(R.array.laterDialog)

    val backGroundId = listOf(
        ImageItem(GameStates.BG_BLACK, R.drawable.bg_black),
        ImageItem(GameStates.BG_LECTURE, R.drawable.bg_lecture_hall),
        ImageItem(GameStates.BG_UNI, R.drawable.bg_uni),
        ImageItem(GameStates.BG_CLUB, R.drawable.bg_club),
        ImageItem(GameStates.BG_MEADOW, R.drawable.bg_meadow)
    )

    val characterId = listOf(
        R.drawable.sylvie_green_normal,
        R.drawable.sylvie_green_smile,
        R.drawable.sylvie_green_surprised,
        R.drawable.sylvie_blue_normal,
        R.drawable.sylvie_blue_smile,
        R.drawable.sylvie_blue_surprised,
        R.drawable.sylvie_blue_giggle,
        R.drawable.character_nothing
    )
}