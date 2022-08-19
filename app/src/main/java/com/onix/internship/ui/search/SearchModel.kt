package com.onix.internship.ui.search

import androidx.databinding.ObservableField

data class SearchModel(
    val gen: ObservableField<String> = ObservableField(),
    val ssp: ObservableField<String> = ObservableField(),
    val also: ObservableField<String> = ObservableField(),
    val type: ObservableField<String> = ObservableField(),
    val loc: ObservableField<String> = ObservableField(),
    val cnt: ObservableField<String> = ObservableField(),
    val rmk: ObservableField<String> = ObservableField(),
    val rec: ObservableField<String> = ObservableField()
)