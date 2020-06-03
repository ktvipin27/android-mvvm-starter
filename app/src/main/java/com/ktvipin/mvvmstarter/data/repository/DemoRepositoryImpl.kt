package com.ktvipin.mvvmstarter.data.repository

import com.ktvipin.mvvmstarter.data.remote.api.DemoApi
import com.ktvipin.mvvmstarter.data.remote.request.DemoRequest
import com.ktvipin.mvvmstarter.data.remote.response.DemoResponse
import com.ktvipin.mvvmstarter.network.ApiResponse
import javax.inject.Inject

/**
 * Created by Vipin KT on 03/06/20
 */
class DemoRepositoryImpl @Inject constructor(
    private val demoApi: DemoApi
) : DemoRepository {

    override suspend fun getDemo(userId: String): ApiResponse<DemoResponse> {
        val request = DemoRequest(userId)
        return demoApi.getDemo(request)
    }
}