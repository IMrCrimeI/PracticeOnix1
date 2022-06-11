package com.onix.internship.practiceonixtask.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.onix.internship.practiceonixtask.R
import com.onix.internship.practiceonixtask.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding

    //    private val viewModel: TestViewModel by viewModels()
    lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentTestBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val quizManager = QuizManager.getInstance(requireContext())

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(quizManager))[
                    TestViewModel::class.java]

        binding.viewModel = viewModel

        viewModel.firstTypeQuestion.observe(viewLifecycleOwner) {
            if (it == null) {
                findNavController().navigate(R.id.action_tetsFragment_to_resultFragment)
            }
        }

        viewModel.move.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_tetsFragment_self)
        }
    }
}