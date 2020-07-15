package com.example.sbnridemo.data

import com.example.sbnridemo.data.network.AppApiHelper
import com.example.sbnridemo.model.HomeResponse
import retrofit2.Call

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

object AppDataManager : DataManager {

    override fun callHomeApi(url: String): Call<HomeResponse> {
        return AppApiHelper.callHomeApi(url)
    }
}