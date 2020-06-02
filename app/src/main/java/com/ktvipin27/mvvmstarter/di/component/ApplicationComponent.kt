package com.ktvipin27.mvvmstarter.di.component

import com.ktvipin27.mvvmstarter.MVVMStarter
import com.ktvipin27.mvvmstarter.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class,
        ServiceModule::class, BroadcastReceiverModule::class, WorkerModule::class, TimberModule::class]
)
interface ApplicationComponent : AndroidInjector<MVVMStarter> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MVVMStarter): Builder

        fun build(): ApplicationComponent
    }
}