package com.example.myapplication.ui.theme.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _clicksValue = MutableLiveData<Int>(0)
    val clicksValue = _clicksValue

    fun onIncrementClicked(){
        _clicksValue.value = _clicksValue.value?.plus(1)
    }

    fun onDecrementClicked(){
        _clicksValue.value = _clicksValue.value?.minus(1)
    }
}
