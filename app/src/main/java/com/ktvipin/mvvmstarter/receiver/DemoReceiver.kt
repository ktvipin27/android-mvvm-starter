package com.ktvipin.mvvmstarter.receiver

import android.content.Context
import android.content.Intent
import com.ktvipin.mvvmstarter.data.local.db.dao.PersonDao
import dagger.android.DaggerBroadcastReceiver
import javax.inject.Inject

class DemoReceiver : DaggerBroadcastReceiver() {

    @Inject
    lateinit var personDao: PersonDao

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
    }
}