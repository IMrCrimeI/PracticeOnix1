package com.onix.internship.ui.mem

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.onRefresh
import com.onix.internship.databinding.FragmentMemBinding
import com.onix.internship.ui.mem.adapter.RecyclerViewAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MemFragment : BaseFragment<FragmentMemBinding>(R.layout.fragment_mem) {
    override val viewModel: MemViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        setRecyclerAdapter()
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.openFilterPopup.observe(viewLifecycleOwner) {
            openPopup()
        }
    }

    private fun openPopup() {
        val popup = PopupMenu(context, binding.topAppBar, Gravity.END)
        popup.menuInflater.inflate(R.menu.main_menu, popup.menu)
        popup.setOnMenuItemClickListener { menuItem -> // Toast message on menu item clicked
            when (menuItem.itemId) {
                R.id.menuAll -> {
                    viewModel.filter.set(getString(R.string.all))
                    true
                }
                R.id.menuCat -> {
                    viewModel.filter.set(getString(R.string.cat))
                    true
                }
                R.id.menuDog -> {
                    viewModel.filter.set(getString(R.string.dog))
                    true
                }
                else -> false
            }
        }
        popup.show()
    }


    private fun setRecyclerAdapter() {
        val memesAdapter = RecyclerViewAdapter()
        binding.memesRecycler.adapter = memesAdapter

        binding.swipeRefreshLayout.onRefresh { memesAdapter.refresh() }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getMemList().collectLatest {
                    memesAdapter.submitData(viewModel.filterData(it))
                }
            }
        }
    }
}