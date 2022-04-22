package com.wayne.porttotask.di

import com.wayne.porttotask.Constant
import com.wayne.porttotask.data.remote.OpenseaService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { createOkHttpClient() }
    single { createOpenseaService(get()) }
}

fun createOkHttpClient() : OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}

fun createOpenseaService(okHttpClient: OkHttpClient): OpenseaService {
    val retrofit =  Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constant.OPENSEA_URL)
        .build()
    return retrofit.create(OpenseaService::class.java)
}

