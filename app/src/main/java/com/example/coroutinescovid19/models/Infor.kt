package com.example.coroutinescovid19.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "infor_table")
data class Infor(
    @PrimaryKey
    val id:Int,
    val countryCode: String,
    val country: String,
    val lat: Float,
    val lng: Float,
    val totalConfirmed: Int,
    val totalDeaths: Int,
    val totalRecovered: Int,
    val dailyConfirmed: Int,
    val dailyDeaths: Int,
    val activeCases: Int,
    val totalCritical: Int,
    val totalConfirmedPerMillionPopulation: Int,
    val totalDeathsPerMillionPopulationl: Int,
    val FR: Float,
    val PR: Float,
    val lastUpadated: String
)