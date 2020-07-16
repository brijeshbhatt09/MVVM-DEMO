package com.example.sbnridemo.data.Persistence

import androidx.room.TypeConverter
import com.example.sbnridemo.model.RowModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by ${Brijesh.Bhatt} on 16/07/20.
 */
class Converters {

    @TypeConverter
    fun fromString(value: String?): List<RowModel?>? {
        val listType =
            object : TypeToken<List<RowModel?>?>() {}.type
        return Gson().fromJson<List<RowModel?>>(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<RowModel?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}