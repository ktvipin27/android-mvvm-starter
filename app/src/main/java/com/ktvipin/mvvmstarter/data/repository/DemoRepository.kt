package com.ktvipin.mvvmstarter.data.repository

import com.ktvipin.mvvmstarter.data.remote.response.DemoResponse
import com.ktvipin.mvvmstarter.network.ApiResponse

/**
 * Created by Vipin KT on 03/06/20
 */
interface DemoRepository {
    suspend fun getDemo(userId: String): ApiResponse<DemoResponse>
}