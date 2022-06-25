package com.onix.internship.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.onix.internship.databinding.DialogWifiDetailFragmentBinding

class WifiDetailDialogFragment: DialogFragment() {
    private lateinit var binding: DialogWifiDetailFragmentBinding
    private val navArgs: WifiDetailDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DialogWifiDetailFragmentBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.wifiName.text = navArgs.name
        binding.wifiLevel.text = navArgs.level.toString()
    }
}