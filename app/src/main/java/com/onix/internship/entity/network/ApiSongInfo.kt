package com.onix.internship.entity.network

import com.google.gson.annotations.SerializedName

data class ApiSongInfo(
    @SerializedName("small") val small: String,
    @SerializedName("med") val med: String,
    @SerializedName("large") val large: String,
    @SerializedName("full") val full: String
)
