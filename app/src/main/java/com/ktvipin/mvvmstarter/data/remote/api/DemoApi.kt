package com.ktvipin.mvvmstarter.data.remote.api

import com.ktvipin.mvvmstarter.data.remote.request.DemoRequest
import com.ktvipin.mvvmstarter.data.remote.response.DemoResponse
import com.ktvipin.mvvmstarter.network.ApiResponse
import com.ktvipin.mvvmstarter.network.Urls
import retrofit2.http.Body
import retrofit2.http.POST

interface DemoApi {

    @POST(Urls.Demo.GET_DEMO)
    suspend fun getDemo(@Body request: DemoRequest): ApiResponse<DemoResponse>
}