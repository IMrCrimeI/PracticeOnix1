package com.onix.internship.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongInfo(
    val small: String = "",
    val med: String = "",
    val large: String = "",
    val full: String = ""
) : Parcelable
