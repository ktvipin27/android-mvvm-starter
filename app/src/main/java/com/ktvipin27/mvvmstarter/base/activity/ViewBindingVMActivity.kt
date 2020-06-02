package com.ktvipin27.mvvmstarter.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.ktvipin27.mvvmstarter.base.viewmodel.BaseViewModel
import kotlin.reflect.KFunction1

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class ViewBindingVMActivity<VB : ViewBinding, VM : BaseViewModel> : BaseVMActivity<VM>() {

    protected val binding: VB by lazy(LazyThreadSafetyMode.NONE) { viewBinding(layoutInflater) }

    protected abstract val viewBinding: KFunction1<LayoutInflater, VB>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}