package com.ktvipin.mvvmstarter.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.ktvipin.mvvmstarter.base.viewmodel.BaseViewModel

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class SimpleVMActivity<VM : BaseViewModel> : BaseVMActivity<VM>() {

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}