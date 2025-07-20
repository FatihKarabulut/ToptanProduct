package com.ahbap.android.app.productapp.retrofit.module

import android.net.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthonticationIntercaptor(var username : String,
                                    var password : String): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val credential = okhttp3.Credentials.basic(username,password)
        val request = chain.request().newBuilder()
            .addHeader("Authorization",credential).build()

        return chain.proceed(request)

    }
}