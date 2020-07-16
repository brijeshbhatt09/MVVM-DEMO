package com.example.sbnridemo.data.Persistence

import android.content.Context
import com.example.sbnridemo.model.HomeResponse

/**
 * Created by ${Brijesh.Bhatt} on 16/07/20.
 */
interface DataHelper {

    fun insertData(context : Context, homeResponse: HomeResponse)
    fun fetchData(context: Context, id : Int) : HomeResponse
}