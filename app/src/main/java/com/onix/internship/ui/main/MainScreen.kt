package com.onix.internship.ui.main

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.onix.internship.R
import com.onix.internship.arch.BaseActivity
import com.onix.internship.data.MediaPlayerWrapper
import com.onix.internship.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreen :
    BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mediaPlayer: MediaPlayerWrapper by inject()

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
        mediaPlayer.setUpPlayer()
        viewModel.music.observe(this) {
            if (it) {
                mediaPlayer.stopMusic()
            } else mediaPlayer.playMusic()
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.stopMusic()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.music.observe(this) {
            if (!it) {
                mediaPlayer.playMusic()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.destroyMusic()
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, binding.root)

        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}