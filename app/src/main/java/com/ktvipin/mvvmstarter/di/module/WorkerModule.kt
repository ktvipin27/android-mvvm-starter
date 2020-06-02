package com.ktvipin.mvvmstarter.di.module

import android.util.Log
import androidx.work.Configuration
import androidx.work.ListenableWorker
import com.ktvipin.mvvmstarter.base.worker.IWorkerFactory
import com.ktvipin.mvvmstarter.base.worker.WorkerInjectorFactory
import com.ktvipin.mvvmstarter.di.key.WorkerKey
import com.ktvipin.mvvmstarter.worker.DemoWorker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
abstract class WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(DemoWorker::class)
    abstract fun bindDemoWorker(worker: DemoWorker.Factory): IWorkerFactory<out ListenableWorker>

    companion object {
        @Singleton
        @Provides
        fun providesWorkerConfig(workerInjectorFactory: WorkerInjectorFactory) =
            Configuration.Builder()
                .setMinimumLoggingLevel(Log.VERBOSE)
                .setTaskExecutor(Executors.newFixedThreadPool(10))
                .setExecutor(Executors.newFixedThreadPool(10))
                .setWorkerFactory(workerInjectorFactory)
                .build()
    }
}