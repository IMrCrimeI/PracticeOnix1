package com.onix.internship.practiceonixtask.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.onix.internship.practiceonixtask.R
import com.onix.internship.practiceonixtask.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    private val arg: UserFragmentArgs by navArgs()

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeText.text = getString(R.string.correctLogin, arg.test)
    }
}