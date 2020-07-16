package com.example.sbnridemo.data.Persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sbnridemo.model.HomeResponse

/**
 * Created by ${Brijesh.Bhatt} on 16/07/20.
 */
@Database(
    entities = [HomeResponse::class],
    version = 1
)
@TypeConverters(*[Converters::class])
abstract class AppDatabase : RoomDatabase(){

    abstract fun homeDao(): HomeDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "sbnri.db")
            .build()
    }
}