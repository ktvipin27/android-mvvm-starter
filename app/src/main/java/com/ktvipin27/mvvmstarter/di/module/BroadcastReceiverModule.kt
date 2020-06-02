package com.ktvipin27.mvvmstarter.di.module

import com.ktvipin27.mvvmstarter.receiver.DemoReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BroadcastReceiverModule {

    @ContributesAndroidInjector
    abstract fun contributeDemoReceiver(): DemoReceiver
}