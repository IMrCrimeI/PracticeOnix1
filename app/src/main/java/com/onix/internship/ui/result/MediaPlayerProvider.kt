package com.onix.internship.ui.result

import android.media.MediaPlayer
import com.onix.internship.entity.BirdInfo

class MediaPlayerProvider {
    private val player = MediaPlayer()
    private var oldBirdId = ""

    fun setNewRecording(bird: BirdInfo) {
        if (bird.id != oldBirdId) {
            if (player.isPlaying) {
                stop()
            }
            oldBirdId = bird.id
            playPause(bird)
        } else {
            playPause(bird)
        }
    }

    private fun playPause(bird: BirdInfo) {
        if (!player.isPlaying && !bird.isPlaying) {
            player.setDataSource(bird.file)
            player.prepare()
            player.start()
        } else {
            stop()
        }
    }

    fun stop() {
        player.stop()
        player.reset()
    }

    fun setListener(listener: MediaPlayer.OnBufferingUpdateListener) {
        player.setOnBufferingUpdateListener(listener)
    }
}