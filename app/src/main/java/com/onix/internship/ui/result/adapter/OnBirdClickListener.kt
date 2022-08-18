package com.onix.internship.ui.result.adapter

import com.onix.internship.entity.BirdInfo

interface OnBirdClickListener {
    fun playPauseMusic(it: BirdInfo)

    fun showDetails(it: BirdInfo)
}