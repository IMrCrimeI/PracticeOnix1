package com.onix.internship.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentHomeBinding
import com.onix.internship.ui.home.HomePagerAdapter.Companion.ADVANCED_SEARCH_FRAGMENT
import com.onix.internship.ui.home.HomePagerAdapter.Companion.SEARCH_FRAGMENT
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pager.adapter = HomePagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = resources.getStringArray(R.array.tab_headers)[position]
            tab.icon = when (position) {
                SEARCH_FRAGMENT -> ContextCompat.getDrawable(requireContext(), R.drawable.ic_search)
                ADVANCED_SEARCH_FRAGMENT -> ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_advanced_search
                )
                else -> null
            }
        }.attach()
    }
}