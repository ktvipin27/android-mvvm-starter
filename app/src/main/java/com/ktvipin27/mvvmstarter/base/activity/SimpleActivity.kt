package com.ktvipin27.mvvmstarter.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class SimpleActivity : BaseActivity() {

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}