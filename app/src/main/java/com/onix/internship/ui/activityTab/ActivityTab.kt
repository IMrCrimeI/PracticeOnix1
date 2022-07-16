package com.onix.internship.ui.activityTab

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.ActivityTabFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActivityTab : BaseFragment<ActivityTabFragmentBinding>(R.layout.activity_tab_fragment) {

    override val viewModel: ActivityTabViewModel by viewModel()
}