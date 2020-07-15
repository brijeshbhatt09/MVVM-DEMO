package com.example.sbnridemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.sbnridemo.data.AppDataManager
import com.example.sbnridemo.model.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

/*This Class is a Middle Layer between viewmodel and dataproviders*/

object ProjectRepository {

    private val viewResponseMutableLiveData: MutableLiveData<HomeResponse> =
        MutableLiveData<HomeResponse>()

    /*API CALL to get response*/
    fun getHomeResponse(url: String): MutableLiveData<HomeResponse> {
        val Call: Call<HomeResponse> =
            AppDataManager.callHomeApi(url)
        Call.enqueue(object : Callback<HomeResponse?> {
            override fun onResponse(
                call: Call<HomeResponse?>,
                response: Response<HomeResponse?>
            ) {
                if (response.isSuccessful()) {
                    viewResponseMutableLiveData.postValue(response.body())
                } else {
                    viewResponseMutableLiveData.postValue(null)
                }
            }

            override fun onFailure(
                call: Call<HomeResponse?>,
                t: Throwable
            ) {
                viewResponseMutableLiveData.postValue(null)
            }
        })
        return viewResponseMutableLiveData
    }
}