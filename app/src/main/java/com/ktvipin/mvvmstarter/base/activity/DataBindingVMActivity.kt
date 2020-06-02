package com.ktvipin.mvvmstarter.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.ktvipin.mvvmstarter.base.viewmodel.BaseViewModel

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class DataBindingVMActivity<DB : ViewDataBinding, VM : BaseViewModel> :
    SimpleVMActivity<VM>() {

    protected val binding: DB by lazy { DataBindingUtil.setContentView(this, layoutId) as DB }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding.setVariable(BR.viewModel,viewModel)
        binding.lifecycleOwner = this
    }
}