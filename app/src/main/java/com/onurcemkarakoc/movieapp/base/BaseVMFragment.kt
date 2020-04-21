package com.onurcemkarakoc.movieapp.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseVMFragment<VM : ViewModel> : Fragment() {

    lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor().newInstance()
            }
        }).get(getViewModel())
    }
}