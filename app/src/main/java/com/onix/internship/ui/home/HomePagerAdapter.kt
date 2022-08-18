package com.onix.internship.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.onix.internship.ui.advanced_search.AdvancedSearchFragment
import com.onix.internship.ui.search.SearchFragment

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = HOME_FRAGMENTS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            SEARCH_FRAGMENT -> {
                SearchFragment()
            }
            ADVANCED_SEARCH_FRAGMENT -> {
                AdvancedSearchFragment()
            }
            else -> {
                SearchFragment()
            }
        }
    }

    companion object {
        const val SEARCH_FRAGMENT = 0
        const val ADVANCED_SEARCH_FRAGMENT = 1
        const val HOME_FRAGMENTS_COUNT = 2
    }
}
