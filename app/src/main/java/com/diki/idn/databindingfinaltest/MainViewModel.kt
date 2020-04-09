package com.diki.idn.databindingfinaltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _likesNumber = MutableLiveData(0)

    val likeNumbers: LiveData<Int> = _likesNumber

    val popularity: LiveData<MainObservableViewModel.LikesNumber> =
        Transformations.map(_likesNumber) {
            when {
                it > 30 -> MainObservableViewModel.LikesNumber.FAMOUS
                it > 20 -> MainObservableViewModel.LikesNumber.POPULAR
                else -> MainObservableViewModel.LikesNumber.NORMAL
            }
        }

    fun onLike() {
        _likesNumber.value = (_likesNumber.value ?: 0) + 1
    }
}

class MainObservableViewModel : MainBaseObservableViewModel() {
    enum class LikesNumber {
        NORMAL, POPULAR, FAMOUS
    }
}