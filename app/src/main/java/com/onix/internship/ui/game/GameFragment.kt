package com.onix.internship.ui.game

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.GameFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : BaseFragment<GameFragmentBinding>(R.layout.game_fragment) {


    override val viewModel: GameViewModel by viewModel()
    private val args: GameFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.model = viewModel.model
    }

    override fun onResume() {
        super.onResume()
        binding.isComputerFirst = args.firstMove
    }
    override fun setObservers() {
        viewModel.initEvent.observe(this) {
            if (it) {
                restartGame()
            } else {
                showHomeFragment()
            }
        }
    }

    private fun restartGame() {
        navigate(GameFragmentDirections.actionGameFragmentToChoiceFragment())
    }
    private fun showHomeFragment() {
        navigate(GameFragmentDirections.actionGameFragmentToDisplayFragment())
    }
}