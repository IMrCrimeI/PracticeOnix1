package com.onix.internship.data.repository

import android.content.Context

class AppSharedPreferences constructor(context: Context) {

    private val sharedPref = context.getSharedPreferences(
        MAIN_SETTINGS, Context.MODE_PRIVATE
    )
    private val edit = sharedPref.edit()

    fun setBooleanInSharPref(it: Boolean) {
        edit.apply {
            putBoolean(AGE, it)
            apply()
        }
    }

    fun setIntInSharPref(it: Int) {
        edit.apply {
            putInt(SKILL, it)
            apply()
        }
    }

    fun setStringInSharPref(it: String) {
        edit.apply {
            putString(ROLE, it)
            apply()
        }
    }


    fun getBooleanFromSharPref(): Boolean {
        return sharedPref.getBoolean(AGE, false)
    }

    fun getIntFromSharPref(): Int {
        return sharedPref.getInt(SKILL, 1)
    }

    fun getStringFromSharPref(): String? {
        return sharedPref.getString(ROLE, "PLAYER")
    }

    companion object {
        const val MAIN_SETTINGS = "mainSettings"
        const val AGE = "age"
        const val SKILL = "skill"
        const val ROLE = "role"
    }
}