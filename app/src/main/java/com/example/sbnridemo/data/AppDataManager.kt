package com.example.sbnridemo.data

import com.example.sbnridemo.data.network.AppApiHelper
import com.example.sbnridemo.model.RowModel
import retrofit2.Call

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

object AppDataManager : DataManager {

    override fun callHomeApi(page : Int, url: String): Call<List<RowModel>> {
        return AppApiHelper.callHomeApi(page, url)
    }
}