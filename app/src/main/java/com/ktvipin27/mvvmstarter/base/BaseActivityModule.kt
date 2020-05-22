package com.ktvipin27.mvvmstarter.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.ktvipin27.mvvmstarter.di.qualifier.ActivityContext
import com.ktvipin27.mvvmstarter.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule {
    @Binds
    @ActivityScope
    @ActivityContext
    abstract fun bindActivityContext(activity: AppCompatActivity): Context

    /*@Binds
    @ActivityScope
    abstract fun bindViewModelFactory(
        viewModelFactory: ActivityViewModelFactory
    ): ViewModelProvider.Factory

    @Module
    companion object {
        @Provides
        @ActivityScope
        @ActivityContext
        @JvmStatic
        fun provideViewModelProvider(
            activity: AppCompatActivity,
            viewModelFactory: ViewModelProvider.Factory
        ): ViewModelProvider = ViewModelProvider(activity, viewModelFactory)
    }*/
}