package com.onix.internship.ui.result

import android.media.MediaPlayer
import com.onix.internship.entity.BirdInfo

class MediaPlayerProvider {

    private var currentRecording = BirdInfo()

    private val player = MediaPlayer()

    fun setNewRecording(item: BirdInfo) {
        if (currentRecording != item) {
            if (currentRecording.isPlaying.get() && player.isPlaying)
                stop()

            currentRecording = item
        }
    }

    fun playPause() {
        if (!currentRecording.isPlaying.get() && !player.isPlaying) {
            currentRecording.isPlaying.set(true)
            player.setDataSource(currentRecording.file)
            player.prepare()
            player.start()
        } else {
            stop()
        }
    }

    private fun stop() {
        currentRecording.isPlaying.set(false)
        player.stop()
        player.reset()
    }

}