package com.ktvipin.mvvmstarter.network


class ApiResponse<T> {
    var status: Status? = null
    var response: T? = null

    val isSuccess: Boolean
        get() = status?.code == 1000

    val isError: Boolean
        get() = status?.code != 1000
}