package com.ktvipin.mvvmstarter.di.module

import com.ktvipin.mvvmstarter.data.remote.api.DemoApi
import com.ktvipin.mvvmstarter.data.repository.DemoRepository
import com.ktvipin.mvvmstarter.data.repository.DemoRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNewsRepository(
        demoApi: DemoApi
    ): DemoRepository = DemoRepositoryImpl(demoApi)
}