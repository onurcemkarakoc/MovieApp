package com.onurcemkarakoc.movieapp.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    lateinit var dataBinding: DB
    lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor().newInstance()
            }
        }).get(getViewModel())
    }


}