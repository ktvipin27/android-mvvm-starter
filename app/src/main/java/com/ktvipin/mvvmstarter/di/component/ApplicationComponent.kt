package com.ktvipin.mvvmstarter.di.component

import com.ktvipin.mvvmstarter.MVVMStarter
import com.ktvipin.mvvmstarter.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class,
        ServiceModule::class, BroadcastReceiverModule::class, WorkerModule::class,
        DatabaseModule::class, TimberModule::class]
)
interface ApplicationComponent : AndroidInjector<MVVMStarter> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MVVMStarter): Builder

        fun build(): ApplicationComponent
    }
}