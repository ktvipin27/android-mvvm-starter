package com.ktvipin.mvvmstarter.worker

import android.content.Context
import androidx.work.*
import com.ktvipin.mvvmstarter.MVVMStarter
import com.ktvipin.mvvmstarter.base.worker.IWorkerFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DemoWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    class Factory @Inject constructor(
    ) : IWorkerFactory<DemoWorker> {

        override fun create(appContext: Context, params: WorkerParameters): DemoWorker {
            return DemoWorker(appContext, params)
        }
    }

    companion object {
        fun start() {
            val request = OneTimeWorkRequest.Builder(DemoWorker::class.java)
                .setConstraints(
                    Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build()
                )
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(MVVMStarter.applicationContext)
                .enqueueUniqueWork(
                    DemoWorker::class.java.simpleName,
                    ExistingWorkPolicy.REPLACE,
                    request
                )
        }
    }

    override fun doWork(): Result {
        return Result.success()
    }
}