package com.example.sbnridemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.sbnridemo.data.AppDataManager
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.model.RowModel
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
    fun getHomeResponse(page : Int, url: String): MutableLiveData<HomeResponse?> {
        viewResponseMutableLiveData = MutableLiveData<HomeResponse?>()
        val Call: Call<List<RowModel>> = AppDataManager.callHomeApi(page, url)
        Call.enqueue(object : Callback<List<RowModel>?> {

            override fun onResponse(call: Call<List<RowModel>?>?, response: Response<List<RowModel>?>?) {
                var homeresponse : HomeResponse = HomeResponse()
                homeresponse.setData(response!!.body())
                viewResponseMutableLiveData.postValue(homeresponse)
            }

            override fun onFailure(call: Call<List<RowModel>?>, t: Throwable) {
                viewResponseMutableLiveData.postValue(null)
            }
        })
        return viewResponseMutableLiveData
    }
}