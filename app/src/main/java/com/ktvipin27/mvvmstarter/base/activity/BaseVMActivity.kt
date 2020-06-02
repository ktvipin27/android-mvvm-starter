package com.ktvipin27.mvvmstarter.base.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ktvipin27.mvvmstarter.base.viewmodel.BaseViewModel
import com.ktvipin27.mvvmstarter.di.qualifier.ActivityContext
import javax.inject.Inject

/**
 * Created by Vipin KT on 21/05/20
 */
abstract class BaseVMActivity<VM : BaseViewModel> : BaseActivity() {

    @Inject
    @field:ActivityContext
    protected lateinit var viewModelProvider: ViewModelProvider

    protected abstract val viewModelClass: Class<VM>

    lateinit var viewModel: VM
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelProvider.get(viewModelClass)
    }

}