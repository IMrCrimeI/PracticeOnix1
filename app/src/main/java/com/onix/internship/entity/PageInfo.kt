package com.onix.internship.entity

data class PageInfo(
    val numRecording: Int,
    val numSpecies: Int,
    val page: Int,
    val numPages: Int,
    val recordings: List<BirdInfo>
)