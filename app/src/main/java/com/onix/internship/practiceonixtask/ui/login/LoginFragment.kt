package com.onix.internship.practiceonixtask.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.onix.internship.practiceonixtask.R
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
        val view = FragmentLoginBinding.inflate(inflater, container, false)
        binding = view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.apply {
            loginSubmit.setOnClickListener {
                val login = loginNameInput.text.toString()
                val password = loginPasswordInput.text.toString()
                loginName.error = ""
                loginPassword.error = ""
                viewModel.checkLogin(login, password)
            }
        }


        viewModel.screenState.observe(viewLifecycleOwner) {
            binding.apply {
                when (it) {
                    ScreenState.ERROR_LOGIN -> loginName.error =
                        requireContext().getString(R.string.wrong_login)
                    ScreenState.ERROR_PASSWORD -> loginPassword.error =
                        requireContext().getString(R.string.wrong_password)
                    ScreenState.SUCCESS -> {
                        viewModel.clearLogin()
                        loginNameInput.text?.clear()
                        loginPasswordInput.text?.clear()
                        findNavController().navigate(R.id.action_loginFragment_to_userFragment)
                    } else -> {}
                }
            }
        }
    }
}
