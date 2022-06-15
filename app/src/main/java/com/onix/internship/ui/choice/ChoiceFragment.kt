package com.onix.internship.ui.choice

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.ChoiceFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChoiceFragment : BaseFragment<ChoiceFragmentBinding>(R.layout.choice_fragment) {

    override val viewModel: ChoiceViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstPlayerButton.setOnClickListener {
            findNavController().navigate(ChoiceFragmentDirections.actionChoiceFragmentToGameFragment(PlayerMove(false).player))
        }
        binding.secondPlayerButton.setOnClickListener {
            findNavController().navigate(ChoiceFragmentDirections.actionChoiceFragmentToGameFragment(PlayerMove(true).player))
        }

    }
}