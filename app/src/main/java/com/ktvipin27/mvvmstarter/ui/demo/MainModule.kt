package com.ktvipin27.mvvmstarter.ui.demo

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.ktvipin27.mvvmstarter.di.key.ViewModelKey
import com.ktvipin27.mvvmstarter.di.module.ViewModelFactoryModule
import com.ktvipin27.mvvmstarter.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class MainModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel

    companion object {
        /*@Provides
        fun viewBinding(activity: MainActivity): ActivityMainBinding {
            return ActivityMainBinding
                .inflate(activity.layoutInflater)
        }*/
    }
}