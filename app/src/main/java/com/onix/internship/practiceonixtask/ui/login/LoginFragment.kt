package com.onix.internship.practiceonixtask.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.onix.internship.practiceonixtask.ScreenState
import com.onix.internship.practiceonixtask.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLoginBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@LoginFragment.viewModel
            this@LoginFragment.viewModel.screenState.observe(viewLifecycleOwner) {

                if (it == ScreenState.SUCCESS) {
                    this@LoginFragment.viewModel.resetScreenState()
                    val action = LoginFragmentDirections.actionLoginFragmentToUserFragment(
                        this@LoginFragment.viewModel.model.login.get().toString()
                    )
                    loginNameInput.text?.clear()
                    loginPasswordInput.text?.clear()
                    findNavController().navigate(action)
                }
            }
        }
    }
}
