package com.example.sbnridemo.data.Persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.sbnridemo.model.HomeResponse

/**
 * Created by ${Brijesh.Bhatt} on 16/07/20.
 */
@Dao
interface HomeDao {

    @Insert(onConflict = REPLACE)
    fun insertResponse(homeResponse: HomeResponse?)

    @Query("SELECT * FROM homeresponse WHERE id LIKE :id")
    fun fetchResponse(id: Int): HomeResponse
}