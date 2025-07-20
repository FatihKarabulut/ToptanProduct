package com.ahbap.android.app.productapp.retrofit.module

import com.ahbap.android.app.productapp.retrofit.IProduct
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {
    const val BASE_URL = "http://10.0.2.2:7272/"


    @Singleton
    @Provides
    fun ProductCreat(retrofit: Retrofit) : IProduct = retrofit.create(IProduct::class.java)
    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        val loggin = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val clients = OkHttpClient().newBuilder()
            .addInterceptor(BasicAuthonticationIntercaptor("admin", "admin123"))
            .addInterceptor(loggin).build()
        val gson = GsonConverterFactory.create(GsonBuilder().create())

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(gson)
            .client(clients).build()
    }
}