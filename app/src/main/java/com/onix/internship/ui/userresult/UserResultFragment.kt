package com.onix.internship.ui.userresult

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.FragmentUserResultBinding
import com.onix.internship.entity.AgeImgEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserResultFragment : BaseFragment<FragmentUserResultBinding>(R.layout.fragment_user_result) {
    override val viewModel: UserResultViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.userData.observe(viewLifecycleOwner) {
            binding.item = it
        }
        viewModel.userImg.observe(viewLifecycleOwner) {
            setImg(it)
        }
    }

    private fun setImg(it: AgeImgEntity) {
        val img: Int = when (it) {
            AgeImgEntity.BOY_0 -> R.drawable.boy_2
            AgeImgEntity.BOY_5 -> R.drawable.boy_5
            AgeImgEntity.BOY_7 -> R.drawable.boy_7
            AgeImgEntity.BOY_12 -> R.drawable.boy_12
            AgeImgEntity.BOY_16 -> R.drawable.boy_16
            AgeImgEntity.BOY_21 -> R.drawable.boys_21
            AgeImgEntity.BOY_35 -> R.drawable.boy_35
            AgeImgEntity.BOY_50 -> R.drawable.boy_50
            AgeImgEntity.BOY_75 -> R.drawable.boy_75
            AgeImgEntity.BOY_95 -> R.drawable.boy_95

            AgeImgEntity.GIRL_0 -> R.drawable.girl_2
            AgeImgEntity.GIRL_5 -> R.drawable.girl_5
            AgeImgEntity.GIRL_7 -> R.drawable.girl_7
            AgeImgEntity.GIRL_12 -> R.drawable.girl_12
            AgeImgEntity.GIRL_16 -> R.drawable.girl_16
            AgeImgEntity.GIRL_21 -> R.drawable.girl_21
            AgeImgEntity.GIRL_35 -> R.drawable.girl_35
            AgeImgEntity.GIRL_50 -> R.drawable.girl_50
            AgeImgEntity.GIRL_75 -> R.drawable.girl_75
            AgeImgEntity.GIRL_95 -> R.drawable.girl_95
        }
        binding.userImg.setImageDrawable(AppCompatResources.getDrawable(requireContext(), img))
    }
}