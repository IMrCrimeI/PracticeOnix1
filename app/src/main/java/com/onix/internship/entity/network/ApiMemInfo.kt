package com.onix.internship.entity.network

import com.google.gson.annotations.SerializedName

data class ApiMemInfo(
    @SerializedName("ID") val ID: String?,
    @SerializedName("bottomText") val bottomText: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("tags") val tags: String?,
    @SerializedName("topText") val topText: String?
)