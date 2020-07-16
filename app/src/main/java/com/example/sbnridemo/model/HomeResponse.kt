package com.example.sbnridemo.model

import java.util.*

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class HomeResponse {

    private var data: List<RowModel?>? = null

    open fun getData(): List<RowModel?>? {
        return data
    }

    open fun setData(data: List<RowModel?>?) {
        this.data = data
    }
}