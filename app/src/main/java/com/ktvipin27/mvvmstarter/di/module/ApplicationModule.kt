package com.ktvipin27.mvvmstarter.di.module

import android.app.Application
import android.content.Context
import com.ktvipin27.mvvmstarter.MVVMStarter
import com.ktvipin27.mvvmstarter.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [AndroidSupportInjectionModule::class, ActivityModule::class,
        ServiceModule::class, BroadcastReceiverModule::class, WorkerModule::class]
)
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: MVVMStarter): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}