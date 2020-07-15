package com.example.sbnridemo.model

import java.util.*

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class HomeResponse {

    private var data: ArrayList<RowModel?>? = null

    fun getData(): ArrayList<RowModel?>? {
        return data
    }

    fun setData(data: ArrayList<RowModel?>?) {
        this.data = data
    }
}