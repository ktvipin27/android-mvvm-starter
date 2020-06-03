package com.ktvipin.mvvmstarter.di.module

import com.ktvipin.mvvmstarter.di.scope.ActivityScope
import com.ktvipin.mvvmstarter.ui.demo.DemoActivity
import com.ktvipin.mvvmstarter.ui.demo.DemoModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [DemoModule::class])
    @ActivityScope
    abstract fun contributeMainActivity(): DemoActivity
}