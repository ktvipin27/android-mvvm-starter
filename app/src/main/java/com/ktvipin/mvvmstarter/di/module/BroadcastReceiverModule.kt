package com.ktvipin.mvvmstarter.di.module

import com.ktvipin.mvvmstarter.receiver.DemoReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BroadcastReceiverModule {

    @ContributesAndroidInjector
    abstract fun contributeDemoReceiver(): DemoReceiver
}