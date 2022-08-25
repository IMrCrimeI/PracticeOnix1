package com.onix.internship.entity.network

import com.google.gson.annotations.SerializedName

data class ApiMemPageInfo(
    @SerializedName("code") val code: String?,
    @SerializedName("data") val data: List<ApiMemInfo>?,
    @SerializedName("message") val message: String?,
    @SerializedName("next") val next: String?
)