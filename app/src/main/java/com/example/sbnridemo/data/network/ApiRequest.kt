package com.example.sbnridemo.data.network

import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

interface ApiRequest {

    @GET
    fun callHomeApi( @Url url: String, @Query("page")  page : Int, @Query("per_page")  num : Int): Call<List<RowModel>>
}