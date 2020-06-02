package com.ktvipin27.mvvmstarter

import com.ktvipin27.mvvmstarter.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class MVVMStarter : DaggerApplication() {

    @Inject
    lateinit var timberTree: Timber.Tree

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(timberTree)
    }
}