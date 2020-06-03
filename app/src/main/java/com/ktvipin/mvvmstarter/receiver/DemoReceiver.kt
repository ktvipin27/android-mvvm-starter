package com.ktvipin.mvvmstarter.receiver

import android.content.Context
import android.content.Intent
import com.ktvipin.mvvmstarter.base.receiver.BaseBroadcastReceiver
import com.ktvipin.mvvmstarter.data.local.db.dao.DemoDao
import javax.inject.Inject

class DemoReceiver : BaseBroadcastReceiver() {

    @Inject
    lateinit var demoDao: DemoDao

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
    }
}