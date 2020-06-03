package com.ktvipin.mvvmstarter.network

import com.ktvipin.mvvmstarter.network.Header.AUTHORIZATION
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.io.IOException
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    //private val userManager: UserManager,
) : Authenticator {

    @Throws(IOException::class)
    override fun authenticate(route: Route?, response: Response): Request? {
        //todo handle authentication
        return newRequest(response)
    }

    private fun newRequest(
        response: Response
    ): Request = response.request.newBuilder()
        .headers(response.request.headers)
        .removeHeader(AUTHORIZATION)
        /*.header(
            AUTHORIZATION,
            "${userManager.tokenDetails?.tokenType} ${userManager.tokenDetails?.accessToken}"
        )*/
        .build()
}
