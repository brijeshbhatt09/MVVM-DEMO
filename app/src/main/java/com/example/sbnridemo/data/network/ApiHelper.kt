package com.example.sbnridemo.data.network

import retrofit2.Call;
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

interface ApiHelper {

    fun callHomeApi(page : Int, url: String): Call<List<RowModel>>
}