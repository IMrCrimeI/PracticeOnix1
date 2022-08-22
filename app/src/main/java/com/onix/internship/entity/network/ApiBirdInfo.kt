package com.onix.internship.entity.network

import com.google.gson.annotations.SerializedName

data class ApiBirdInfo(
    @SerializedName("id") val id: String,
    @SerializedName("gen") val gen: String?,
    @SerializedName("sp") val sp: String?,
    @SerializedName("ssp") val ssp: String?,
    @SerializedName("en") val en: String?,
    @SerializedName("rec") val rec: String?,
    @SerializedName("cnt") val cnt: String?,
    @SerializedName("loc") val loc: String?,
    @SerializedName("lat") val lat: String?,
    @SerializedName("lng") val lng: String?,
    @SerializedName("alt") val alt: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("file") val file: String?,
    @SerializedName("file_name") val file_name: String?,
    @SerializedName("sono") val sono: ApiSongInfo?,
    @SerializedName("lic") val lic: String?,
    @SerializedName("q") val q: String?,
    @SerializedName("length") val length: String?,
    @SerializedName("time") val time: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("uploaded") val uploaded: String?,
    @SerializedName("also") val also: List<String>?,
    @SerializedName("rmk") val rmk: String?,
    @SerializedName("bird_seen") val bird_seen: String?,
    @SerializedName("playback_used") val playback_used: String?,
)
