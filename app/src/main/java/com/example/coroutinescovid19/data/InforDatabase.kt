package com.example.coroutinescovid19.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coroutinescovid19.models.Infor

@Database(entities = [Infor::class], version = 1, exportSchema = false)
abstract class InforDatabase : RoomDatabase() {
    abstract fun inforDao(): InforDao

    companion object {
        @Volatile
        private var INSTANCE: InforDatabase? = null

        fun getDatabase(context: Context): InforDatabase {
            val instance = INSTANCE
            if (instance != null) {
                return instance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InforDatabase::class.java,
                    "infor_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}