package com.ktvipin27.mvvmstarter.ui.demo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.ktvipin27.mvvmstarter.R
import com.ktvipin27.mvvmstarter.base.activity.DataBindingVMActivity
import com.ktvipin27.mvvmstarter.databinding.ActivityMainBinding

class MainActivity : DataBindingVMActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
