package com.ktvipin.mvvmstarter.di.module

import com.ktvipin.mvvmstarter.data.remote.api.DemoApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideDemoApi(retrofit: Retrofit): DemoApi =
        retrofit.create(DemoApi::class.java)

    /*@Provides
    @Singleton
    @Named("TokenAuthApi")
    fun provideTokenAuthenticatorApi(
        @Named("TokenAuthRetrofit") retrofit: Retrofit
    ): AuthenticationApi = retrofit.create(AuthenticationApi::class.java)*/
}