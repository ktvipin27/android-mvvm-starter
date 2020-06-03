package com.ktvipin.mvvmstarter.ui.demo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.ktvipin.mvvmstarter.R
import com.ktvipin.mvvmstarter.base.activity.DataBindingVMActivity
import com.ktvipin.mvvmstarter.databinding.ActivityDemoBinding

class DemoActivity : DataBindingVMActivity<ActivityDemoBinding, DemoViewModel>() {

    override val viewModelClass: Class<DemoViewModel>
        get() = DemoViewModel::class.java

    override val layoutId: Int
        get() = R.layout.activity_demo

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
