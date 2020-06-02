package com.ktvipin27.mvvmstarter.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class DataBindingActivity<DB : ViewDataBinding> : SimpleActivity() {

    protected val binding: DB by lazy { DataBindingUtil.setContentView(this, layoutId) as DB }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
    }
}