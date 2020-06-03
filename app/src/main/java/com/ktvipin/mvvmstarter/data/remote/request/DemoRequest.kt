package com.ktvipin.mvvmstarter.data.remote.request

import com.google.gson.annotations.SerializedName

data class DemoRequest(
    @SerializedName("userId")
    val userId: String
)