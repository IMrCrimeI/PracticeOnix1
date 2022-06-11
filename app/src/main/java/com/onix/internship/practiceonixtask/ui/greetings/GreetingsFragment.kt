package com.onix.internship.practiceonixtask.ui.greetings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.onix.internship.practiceonixtask.R
import com.onix.internship.practiceonixtask.databinding.FragmentGreetingsBinding

class GreetingsFragment : Fragment() {

    private lateinit var binding: FragmentGreetingsBinding
    private val viewModel: GreetingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGreetingsBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.move.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_greetingsFragment_to_tetsFragment)
        }
    }
}