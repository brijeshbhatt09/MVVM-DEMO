package com.example.sbnridemo.data.network

import retrofit2.Call;
import com.example.sbnridemo.model.HomeResponse

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

interface ApiHelper {

    fun callHomeApi(url: String): Call<HomeResponse>
}