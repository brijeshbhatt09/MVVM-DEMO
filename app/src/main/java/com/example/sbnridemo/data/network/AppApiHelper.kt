package com.example.sbnridemo.data.network

import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

object AppApiHelper : ApiHelper{

    val TIME_OUT = 60


    fun apiClient(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val gson = GsonBuilder().setLenient().create()
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/orgs/octokit/")
            .client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    override fun callHomeApi(page : Int, url: String): Call<List<RowModel>> {
        return apiClient().create(ApiRequest::class.java).callHomeApi(url, page, 10)
    }
}