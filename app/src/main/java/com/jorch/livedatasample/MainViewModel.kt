package com.jorch.livedatasample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {
    
    private val _count = MutableLiveData(state["count"] ?: 0)
    val count: LiveData<Int> get() = _count


    fun incrementCount() {
        _count.value = _count.value?.plus(1) ?: 1
        state["count"] = _count.value
    }
}