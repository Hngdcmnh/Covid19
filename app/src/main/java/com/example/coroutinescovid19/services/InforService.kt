package com.example.coroutinescovid19.services


import com.example.coroutinescovid19.models.Infor
import retrofit2.Response
import retrofit2.http.GET

interface InforService{
    @GET("v3/stats/worldometer/country?countryCode=VN&fbclid=IwAR0axCTO3NbY8z2UV7cdPizAparA1dMLEV4tZOh316oJkDuMa185An5tqQI")
    suspend fun getAllInfors(): Response<List<Infor>>

}