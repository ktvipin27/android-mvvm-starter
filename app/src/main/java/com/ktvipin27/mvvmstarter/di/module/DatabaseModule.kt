package com.ktvipin27.mvvmstarter.di.module

import android.app.Application
import com.ktvipin27.mvvmstarter.data.local.db.AppDatabase
import com.ktvipin27.mvvmstarter.data.local.db.dao.PersonDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase =
        AppDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providesPersonDao(appDatabase: AppDatabase): PersonDao = appDatabase.personDao()
}