package com.ktvipin.mvvmstarter.di.module

import android.app.Application
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ktvipin.mvvmstarter.BuildConfig
import com.ktvipin.mvvmstarter.network.Header.APP_VERSION
import com.ktvipin.mvvmstarter.network.Header.AUTHORIZATION
import com.ktvipin.mvvmstarter.network.Header.DEVICE
import com.ktvipin.mvvmstarter.network.Header.REMOVE_AUTH
import com.ktvipin.mvvmstarter.network.TokenAuthenticator
import com.ktvipin.mvvmstarter.network.Urls
import com.ktvipin.mvvmstarter.network.enableTls12
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Vipin KT on 03/06/20
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache = Cache(
        application.cacheDir,
        CACHE_MAX_SIZE
    )

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: Interceptor,
        tokenAuthenticator: TokenAuthenticator,
        flipperOkHttpInterceptor: FlipperOkhttpInterceptor
    ): OkHttpClient {
        /*val certificatePinner = CertificatePinner.Builder()
            .add(BuildConfig.DOMAIN, BuildConfig.PUBLIC_KEY)
            .build()*/
        val okHttpClient = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .authenticator(tokenAuthenticator)
            //.certificatePinner(certificatePinner)
            .enableTls12()
        if (BuildConfig.DEBUG) {
            okHttpClient.addNetworkInterceptor(flipperOkHttpInterceptor)
            okHttpClient.addNetworkInterceptor(StethoInterceptor())
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    @Named("TokenAuthOkHttpClient")
    fun provideAuthOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: Interceptor,
        flipperOkHttpInterceptor: FlipperOkhttpInterceptor
    ): OkHttpClient {
        /*val certificatePinner = CertificatePinner.Builder()
            .add(BuildConfig.DOMAIN, BuildConfig.PUBLIC_KEY)
            .build()*/
        val okHttpClient = OkHttpClient.Builder()
            .dispatcher(Dispatcher().apply {
                maxRequests = 1
                maxRequestsPerHost = 1
            })
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            //.certificatePinner(certificatePinner)
            .enableTls12()
        if (BuildConfig.DEBUG) {
            okHttpClient.addNetworkInterceptor(flipperOkHttpInterceptor)
            okHttpClient.addNetworkInterceptor(StethoInterceptor())
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideNetworkFlipperPlugin() = NetworkFlipperPlugin()

    @Provides
    @Singleton
    fun provideFlipperOkhttpInterceptor(networkFlipperPlugin: NetworkFlipperPlugin) =
        FlipperOkhttpInterceptor(networkFlipperPlugin)

    @Provides
    @Singleton
    fun provideRequestInterceptor(
    ): Interceptor = Interceptor { chain ->
        val request = chain.request()
        val url = request.url.toUrl().toString()

        val httpUrl = url.toHttpUrlOrNull()

        val newBuilder = request.newBuilder()
        if (httpUrl != null)
            newBuilder.url(httpUrl)
        /*userManager.tokenDetails?.let { tokenDetails ->
            newBuilder.addHeader(
                AUTHORIZATION,
                "${tokenDetails.tokenType} ${tokenDetails.accessToken}"
            )
        }*/
        newBuilder.addHeader(DEVICE, "Android")
        newBuilder.addHeader(APP_VERSION, BuildConfig.VERSION_NAME)

        val removeAuthHeader = request.header(REMOVE_AUTH)?.toBoolean() ?: false
        if (removeAuthHeader) newBuilder.removeHeader(AUTHORIZATION)
        newBuilder.removeHeader(REMOVE_AUTH)

        chain.proceed(newBuilder.build())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideNullOrEmptyConverterFactory(): Converter.Factory = object : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<out Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, Any?> {
            val nextResponseBodyConverter = retrofit.nextResponseBodyConverter<Any?>(
                this,
                type,
                annotations
            )

            return Converter { body: ResponseBody ->
                if (body.contentLength() == 0L) null
                else nextResponseBodyConverter.convert(body)
            }
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        nullOrEmptyConverterFactory: Converter.Factory,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(nullOrEmptyConverterFactory)
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(Urls.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    @Named("TokenAuthRetrofit")
    fun provideAuthRetrofit(
        @Named("TokenAuthOkHttpClient")
        okHttpClient: OkHttpClient,
        nullOrEmptyConverterFactory: Converter.Factory,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(nullOrEmptyConverterFactory)
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(Urls.BASE_URL)
            .build()
    }

    companion object {
        const val CACHE_MAX_SIZE = 20L * 1024 * 1024 //20 mo
    }
}