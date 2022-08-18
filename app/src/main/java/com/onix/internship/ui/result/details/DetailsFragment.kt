package com.onix.internship.ui.result.details

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.loadUrlImage
import com.onix.internship.data.storage.BirdDetailsStorage
import com.onix.internship.databinding.FragmentDetailsBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {
    override val viewModel: DetailsViewModel by viewModel()
    private val birdDetailsStorage: BirdDetailsStorage by inject()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val details = birdDetailsStorage.getBirdDetails()
        binding.birdInfo = details
        binding.birdSongImage.loadUrlImage(details.sono.small)
    }
}