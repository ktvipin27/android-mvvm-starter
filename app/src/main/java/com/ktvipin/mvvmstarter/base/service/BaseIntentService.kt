package com.ktvipin.mvvmstarter.base.service

import dagger.android.DaggerIntentService

/**
 * Created by Vipin KT on 03/06/20
 */
abstract class BaseIntentService(val name: String) : DaggerIntentService(name)