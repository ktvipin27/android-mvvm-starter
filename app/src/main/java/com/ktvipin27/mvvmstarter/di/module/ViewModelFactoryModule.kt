package com.ktvipin27.mvvmstarter.di.module

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ktvipin27.mvvmstarter.base.viewmodel.factory.ViewModelFactory
import com.ktvipin27.mvvmstarter.di.qualifier.ActivityContext
import com.ktvipin27.mvvmstarter.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Vipin KT on 02/06/20
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    @ActivityScope
    abstract fun bindViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Module
    companion object {
        @Provides
        @ActivityScope
        @ActivityContext
        fun provideViewModelProvider(
            activity: AppCompatActivity,
            viewModelFactory: ViewModelProvider.Factory
        ): ViewModelProvider = ViewModelProvider(activity, viewModelFactory)
    }
}