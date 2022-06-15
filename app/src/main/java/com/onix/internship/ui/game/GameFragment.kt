package com.onix.internship.ui.game

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.GameFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : BaseFragment<GameFragmentBinding>(R.layout.game_fragment) {

    override val viewModel: GameViewModel by viewModel()
    private val args: GameFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ticTacToeBoard.setPlayer(args.firstMove)

        binding.goHome.setOnClickListener { findNavController().navigate(R.id.action_gameFragment_to_displayFragment) }
    }

}