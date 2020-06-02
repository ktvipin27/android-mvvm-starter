package com.ktvipin.mvvmstarter.ui.demo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.ktvipin.mvvmstarter.R
import com.ktvipin.mvvmstarter.base.activity.DataBindingVMActivity
import com.ktvipin.mvvmstarter.databinding.ActivityMainBinding

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
