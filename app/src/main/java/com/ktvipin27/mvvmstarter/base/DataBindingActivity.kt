package com.ktvipin27.mvvmstarter.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class DataBindingActivity<DB : ViewDataBinding> : SimpleActivity() {

    protected lateinit var binding: DB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }
}