package com.onix.internship.ui.main

import android.media.MediaPlayer
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.onix.internship.R
import com.onix.internship.arch.BaseActivity
import com.onix.internship.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreen : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private var mediaPlayer: MediaPlayer = MediaPlayer()
    override val viewModel: MainViewModel by viewModel()

    override val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homeHostNavFragment) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemBars()
        binding.viewModel = viewModel
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.illurock)
        mediaPlayer.isLooping = true

        mediaPlayer.start()
        viewModel.music.observe(this) {
            if (it) {
                mediaPlayer.pause()
            } else mediaPlayer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.music.observe(this) {
            if (!it) {
                mediaPlayer.start()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, binding.root)

        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}