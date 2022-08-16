package com.onix.internship.ui.editPhoto

import androidx.databinding.ObservableFloat

data class EditPhotoModel(
    var contrastValue: ObservableFloat = ObservableFloat(1f),
    var brightnessValue: ObservableFloat = ObservableFloat(1f),
    var saturationValue: ObservableFloat = ObservableFloat(1f)
)