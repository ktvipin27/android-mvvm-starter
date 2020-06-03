package com.ktvipin.mvvmstarter.data.remote.response


import com.google.gson.annotations.SerializedName

data class DemoResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
)