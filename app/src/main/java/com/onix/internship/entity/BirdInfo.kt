package com.onix.internship.entity

import androidx.databinding.ObservableBoolean

data class BirdInfo(
    val id: String = "",
    val gen: String = "",
    val sp: String = "",
    val ssp: String = "",
    val en: String = "",
    val rec: String = "",
    val cnt: String = "",
    val loc: String = "",
    val lat: String = "",
    val lng: String = "",
    val alt: String = "",
    val type: String = "",
    val url: String = "",
    val file: String = "",
    val file_name: String = "",
    val sono: SongInfo = SongInfo(),
    val lic: String = "",
    val q: String = "",
    val length: String = "",
    val time: String = "",
    val date: String = "",
    val uploaded: String = "",
    val also: List<String> = listOf(),
    val rmk: String = "",
    val bird_seen: String = "",
    val playback_used: String = "",
    val isPlaying: ObservableBoolean = ObservableBoolean(false)
)