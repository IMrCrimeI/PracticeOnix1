package com.onix.internship.ui.folderTab

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FolderTabFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FolderTab : BaseFragment<FolderTabFragmentBinding>(R.layout.folder_tab_fragment) {
    override val viewModel: FolderTabViewModel by viewModel()
}