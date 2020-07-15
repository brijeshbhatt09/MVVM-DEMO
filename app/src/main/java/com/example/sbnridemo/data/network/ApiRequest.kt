package com.example.sbnridemo.data.network

import com.example.sbnridemo.model.HomeResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Url

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

interface ApiRequest {

    @POST
    fun callHomeApi(@Url url: String): Call<HomeResponse>
}