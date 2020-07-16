package com.example.sbnridemo.repository

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sbnridemo.data.AppDataManager
import com.example.sbnridemo.data.Persistence.AppDatabase
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

/*This Class is a Middle Layer between viewmodel and dataproviders*/

object ProjectRepository {

    lateinit var viewResponseMutableLiveData: MutableLiveData<HomeResponse?>

    /*API CALL to get response*/
    fun getHomeResponse(page : Int, url: String, contex: Context): MutableLiveData<HomeResponse?> {
        viewResponseMutableLiveData = MutableLiveData<HomeResponse?>()
        val Call: Call<List<RowModel>> = AppDataManager.callHomeApi(page, url)
        Call.enqueue(object : Callback<List<RowModel>?> {

            override fun onResponse(call: Call<List<RowModel>?>?, response: Response<List<RowModel>?>?) {
                var homeresponse : HomeResponse = HomeResponse(page)
                homeresponse.setData(response!!.body())
                viewResponseMutableLiveData.postValue(homeresponse)
                GlobalScope.launch {
                    AppDataManager.insertData(contex, homeresponse)
                }
            }

            override fun onFailure(call: Call<List<RowModel>?>, t: Throwable) {
                GlobalScope.launch {
                    var homeresponse : HomeResponse = AppDataManager.fetchData(contex, page)
                    viewResponseMutableLiveData.postValue(homeresponse)
                }
            }
        })
        return viewResponseMutableLiveData
    }
}