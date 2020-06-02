package com.ktvipin.mvvmstarter.di.module

import android.app.Application
import android.content.Context
import com.ktvipin.mvvmstarter.MVVMStarter
import com.ktvipin.mvvmstarter.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: MVVMStarter): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}