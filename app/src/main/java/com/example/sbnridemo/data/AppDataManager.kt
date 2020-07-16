package com.example.sbnridemo.data

import android.content.Context
import com.example.sbnridemo.data.Persistence.AppDatabase
import com.example.sbnridemo.data.network.AppApiHelper
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel
import kotlinx.coroutines.GlobalScope
import retrofit2.Call

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

object AppDataManager : DataManager {

    override fun callHomeApi(page : Int, url: String): Call<List<RowModel>> {
        return AppApiHelper.callHomeApi(page, url)
    }

    override fun insertData(context: Context, homeResponse: HomeResponse) {
        val dao = AppDatabase(context).homeDao()
        dao.insertResponse(homeResponse)
    }

    override fun fetchData(context: Context, id: Int) : HomeResponse{
       val dao = AppDatabase(context).homeDao()
        return dao.fetchResponse(id)
    }
}