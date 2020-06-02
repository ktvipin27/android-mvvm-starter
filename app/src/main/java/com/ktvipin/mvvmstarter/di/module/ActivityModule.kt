package com.ktvipin.mvvmstarter.di.module

import com.ktvipin.mvvmstarter.di.scope.ActivityScope
import com.ktvipin.mvvmstarter.ui.demo.MainActivity
import com.ktvipin.mvvmstarter.ui.demo.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity
}