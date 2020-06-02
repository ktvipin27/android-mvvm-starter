package com.ktvipin.mvvmstarter

import androidx.work.Configuration
import androidx.work.WorkManager
import com.ktvipin.mvvmstarter.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class MVVMStarter : DaggerApplication() {

    @Inject
    lateinit var timberTree: Timber.Tree

    @Inject
    lateinit var workerConfig: Configuration

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(timberTree)
        WorkManager.initialize(this, workerConfig)
    }

    companion object {
        private var instance: MVVMStarter? = null

        val applicationContext: MVVMStarter
            get() = instance as MVVMStarter
    }
}