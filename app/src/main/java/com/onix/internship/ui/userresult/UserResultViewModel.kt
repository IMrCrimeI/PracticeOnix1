package com.onix.internship.ui.userresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.network.onSuccess
import com.onix.internship.data.repository.NetworkRepository
import com.onix.internship.entity.AgeImgEntity
import com.onix.internship.entity.UserInfo
import com.onix.internship.ui.user.UserModel

class UserResultViewModel(
    private val networkRepository: NetworkRepository,
    private val model: UserModel
) : BaseViewModel() {

    private val _userData = MutableLiveData<UserInfo>()
    val userData: LiveData<UserInfo> = _userData

    private val _userImg = MutableLiveData<AgeImgEntity>()
    val userImg: LiveData<AgeImgEntity> = _userImg

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        launch {
            networkRepository.getMem(model.name.get() ?: "")
                .onSuccess {
                    _userData.value = it
                    checkAge(it)
                }
        }
    }

    private fun checkAge(it: UserInfo) {
        if (!it.name.endsWith("a")) {
            _userImg.value = setImgBoy(it)
        } else {
            _userImg.value = setImgGirl(it)
        }
    }

    private fun setImgBoy(it: UserInfo): AgeImgEntity {
        return when (it.age) {
            in 0..2 -> {
                AgeImgEntity.BOY_0
            }
            in 2..5 -> {
                AgeImgEntity.BOY_5
            }
            in 5..7 -> {
                AgeImgEntity.BOY_7
            }
            in 7..12 -> {
                AgeImgEntity.BOY_12
            }
            in 12..16 -> {
                AgeImgEntity.BOY_16
            }
            in 16..21 -> {
                AgeImgEntity.BOY_21
            }
            in 21..35 -> {
                AgeImgEntity.BOY_35
            }
            in 35..50 -> {
                AgeImgEntity.BOY_50
            }
            in 50..75 -> {
                AgeImgEntity.BOY_75
            }
            in 35..95 -> {
                AgeImgEntity.BOY_95
            }
            else -> {
                AgeImgEntity.BOY_21
            }
        }
    }

    private fun setImgGirl(it: UserInfo): AgeImgEntity {
        return when (it.age) {
            in 0..2 -> {
                AgeImgEntity.GIRL_0
            }
            in 2..5 -> {
                AgeImgEntity.GIRL_5
            }
            in 5..7 -> {
                AgeImgEntity.GIRL_7
            }
            in 7..12 -> {
                AgeImgEntity.GIRL_12
            }
            in 12..16 -> {
                AgeImgEntity.GIRL_16
            }
            in 16..21 -> {
                AgeImgEntity.GIRL_21
            }
            in 21..35 -> {
                AgeImgEntity.GIRL_35
            }
            in 35..50 -> {
                AgeImgEntity.GIRL_50
            }
            in 50..75 -> {
                AgeImgEntity.GIRL_75
            }
            in 35..95 -> {
                AgeImgEntity.GIRL_95
            }
            else -> {
                AgeImgEntity.GIRL_21
            }
        }
    }
}