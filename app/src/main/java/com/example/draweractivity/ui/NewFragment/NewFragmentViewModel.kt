package com.example.draweractivity.ui.NewFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewFragmentViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is New Fragment"
    }
    val text: LiveData<String> = _text
}