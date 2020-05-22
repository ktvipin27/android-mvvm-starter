package com.ktvipin27.mvvmstarter.ui.demo

import androidx.appcompat.app.AppCompatActivity
import com.ktvipin27.mvvmstarter.base.BaseActivityModule
import com.ktvipin27.mvvmstarter.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module(includes = [BaseActivityModule::class])
abstract class MainModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    /*companion object {
        @Provides
        fun viewBinding(activity: MainActivity): ActivityMainBinding {
            return ActivityMainBinding
                .inflate(activity.layoutInflater)
        }
    }*/
}