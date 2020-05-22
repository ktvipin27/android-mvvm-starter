package com.ktvipin27.mvvmstarter.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.ktvipin27.mvvmstarter.extensions.viewBinding
import kotlin.reflect.KFunction1

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class ViewBindingActivity<VB : ViewBinding> : BaseActivity() {

    protected val binding: VB by viewBinding(viewBinding)
    protected abstract val viewBinding: KFunction1<LayoutInflater, VB>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}