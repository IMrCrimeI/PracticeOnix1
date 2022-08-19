package com.onix.internship.ui.result.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.navArgs
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.loadUrlImage
import com.onix.internship.databinding.FragmentDetailsBinding
import com.onix.internship.entity.BirdInfo
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {
    override val viewModel: DetailsViewModel by viewModel()
    private val navArgs: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        val details = navArgs.bird
        binding.birdInfo = details
        binding.birdSongImage.loadUrlImage(details.sono.small)
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.stopMusic()
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.downloadSong.observe(viewLifecycleOwner) {
            downloadSong(it)
        }

        viewModel.changeDrawable.observe(viewLifecycleOwner) {
            setImageToButton(it)
        }
    }

    private fun setImageToButton(it: Boolean) {
        if (it) {
            binding.playPauseMusic.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_pause
                )
            )
        } else {
            binding.playPauseMusic.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.ic_play
                )
            )
        }
    }

    private fun downloadSong(bird: BirdInfo) {
        val downloadManager = DownloadManager(requireContext())
        val url = bird.file
        val name = bird.file_name
        downloadManager.downloadRequest(name, url)
    }
}