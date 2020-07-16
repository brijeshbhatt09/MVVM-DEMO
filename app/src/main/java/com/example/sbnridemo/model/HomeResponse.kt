package com.example.sbnridemo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

@Entity
data class HomeResponse(@PrimaryKey var id: Int) {

    @ColumnInfo(name = "data")
    private var data: List<RowModel?>? = null

    open fun getData(): List<RowModel?>? {
        return data
    }

    open fun setData(data: List<RowModel?>?) {
        this.data = data
    }
}