package com.onix.internship.data

import android.content.Context
import android.media.MediaPlayer
import com.onix.internship.R

class MediaPlayerWrapper(private val context: Context) {
    private var mediaPlayer: MediaPlayer = MediaPlayer()

    fun setUpPlayer() {
        mediaPlayer = MediaPlayer.create(context, R.raw.illurock)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    fun playMusic() {
        mediaPlayer.start()
    }

    fun stopMusic() {
        mediaPlayer.pause()
    }

    fun destroyMusic() {
        mediaPlayer.release()
    }
}