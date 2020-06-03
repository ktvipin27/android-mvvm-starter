package com.ktvipin.mvvmstarter.network

import com.ktvipin.mvvmstarter.BuildConfig

/**
 * Created by Vipin KT on 03/06/20
 */
object Urls {
    var BASE_URL = BuildConfig.API_DOMAIN

    object Demo {
        const val GET_DEMO = "demo/v1/get-demo"
    }
}