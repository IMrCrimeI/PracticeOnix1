package com.onix.internship.ui.mem

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.onRefresh
import com.onix.internship.databinding.FragmentMemBinding
import com.onix.internship.ui.mem.adapter.RecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MemFragment : BaseFragment<FragmentMemBinding>(R.layout.fragment_mem) {
    override val viewModel: MemViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        setRecyclerAdapter()

        binding.swipeRefreshLayout.onRefresh { viewModel.reloadRecycler() }

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
                R.id.menuCat -> {
                    viewModel.filterCat()
                    true
                }
                R.id.menuDog -> {

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

        viewModel.listOfMemes.observe(viewLifecycleOwner) {
            memesAdapter.submitList(it)
        }

        binding.memesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.loadMore()
                }
            }
        })
    }
}