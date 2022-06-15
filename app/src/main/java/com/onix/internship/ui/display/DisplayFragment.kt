package com.onix.internship.ui.display

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.DisplayFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisplayFragment : BaseFragment<DisplayFragmentBinding>(R.layout.display_fragment) {

    override val viewModel: DisplayViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startGameButton.setOnClickListener {
           findNavController().navigate(R.id.action_displayFragment_to_choiceFragment )
        }
    }
}