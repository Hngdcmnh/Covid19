package com.example.coroutinescovid19.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coroutinescovid19.models.Infor

@Dao
interface InforDao {
    @Insert
    suspend fun insertInfor(infor:Infor)

    @Query("SELECT * FROM infor_table ORDER BY id ASC")
    fun getAllInfor():LiveData<List<Infor>>
}