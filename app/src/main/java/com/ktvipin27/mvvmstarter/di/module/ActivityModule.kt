package com.ktvipin27.mvvmstarter.di.module

import com.ktvipin27.mvvmstarter.di.scope.ActivityScope
import com.ktvipin27.mvvmstarter.ui.demo.MainActivity
import com.ktvipin27.mvvmstarter.ui.demo.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity
}