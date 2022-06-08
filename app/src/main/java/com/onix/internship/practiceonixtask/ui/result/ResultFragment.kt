package com.onix.internship.practiceonixtask.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.onix.internship.practiceonixtask.R
import com.onix.internship.practiceonixtask.databinding.FragmentResultBinding
import com.onix.internship.practiceonixtask.ui.test.QuizManager

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val viewModel: ResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentResultBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewResult.text = QuizManager.getInstance().counter.toString()

        binding.viewModel = viewModel

        viewModel.move.observe(viewLifecycleOwner) {
            viewModel.clearIndexAndCounter()
            findNavController().navigate(R.id.action_resultFragment_to_greetingsFragment)
        }
    }
}