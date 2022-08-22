package com.onix.internship.entity.network

import com.google.gson.annotations.SerializedName

data class ApiPageInfo(
    @SerializedName("numRecording") val numRecording: Int,
    @SerializedName("numSpecies") val numSpecies: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("numPages") val numPages: Int,
    @SerializedName("recordings") val recordings: List<ApiBirdInfo>
)
