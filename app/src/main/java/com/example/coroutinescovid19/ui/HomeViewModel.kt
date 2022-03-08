package com.example.coroutinescovid19.ui
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.coroutinescovid19.data.InforRepository
import com.example.coroutinescovid19.models.Infor

class HomeViewModel:ViewModel() {

//    private var inforRepository:InforRepository
    private var listInfor: MutableList<Infor> = mutableListOf()
//    var listInfor: List<Infor> = listOf()
//
//    init {
//        var
//    }

    fun addAllInfors(mutableList: MutableList<Infor>)
    {
        listInfor.addAll(mutableList)
        Log.e(this.javaClass.simpleName,listInfor.size.toString())
    }

    fun getFirstInfor():Infor
    {
        return listInfor[0]
    }

}