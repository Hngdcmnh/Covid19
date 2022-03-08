package com.example.coroutinescovid19.data

import androidx.lifecycle.LiveData
import com.example.coroutinescovid19.models.Infor

class InforRepository(private var inforDao:InforDao) {
    var allInfor:LiveData<List<Infor>> = inforDao.getAllInfor()

    suspend fun addInfor(infor: Infor)
    {
        inforDao.insertInfor(infor)
    }

}