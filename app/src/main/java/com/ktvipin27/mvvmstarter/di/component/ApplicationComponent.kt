package com.ktvipin27.mvvmstarter.di.component

import com.ktvipin27.mvvmstarter.MVVMStarter
import com.ktvipin27.mvvmstarter.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<MVVMStarter> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MVVMStarter): Builder

        fun build(): ApplicationComponent
    }
}