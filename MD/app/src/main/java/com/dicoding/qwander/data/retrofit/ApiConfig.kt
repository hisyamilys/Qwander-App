package com.dicoding.qwander.data.retrofit

import com.dicoding.qwander.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
//    fun getApiService(): ApiService {
//        val client = OkHttpClient.Builder()
//            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://qwander-iyshdlmyxq-et.a.run.app/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//        return retrofit.create(ApiService::class.java)
//    }

//    fun getApiService(): ApiService {
////        val loggingInterceptor =
////            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        val client = OkHttpClient.Builder()
////            .addInterceptor(loggingInterceptor)
//            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://qwander-iyshdlmyxq-et.a.run.app/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//        return retrofit.create(ApiService::class.java)
//
//
//    }

    fun getApiService(): ApiService {
        val loggingInterceptor = if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://qwander-iyshdlmyxq-et.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

}