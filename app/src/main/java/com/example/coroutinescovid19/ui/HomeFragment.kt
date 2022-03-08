package com.example.coroutinescovid19.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinescovid19.R
import com.example.coroutinescovid19.models.Infor
import com.example.coroutinescovid19.services.InforService
import com.example.coroutinescovid19.services.ServiceBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    var homeViewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCountry = view.findViewById<TextView>(R.id.tv_country)
        val tvDailyConfirmed = view.findViewById<TextView>(R.id.tv_daily_confirmed)
        val tvDailyDeaths = view.findViewById<TextView>(R.id.tv_daily_deaths)
        val tvTotalConfirmed = view.findViewById<TextView>(R.id.tv_total_confirmed)
        val tvTotalDeaths = view.findViewById<TextView>(R.id.tv_total_deaths)



        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO)
            {
                val destinationService = ServiceBuilder.buildService(InforService::class.java)
                val requestInformation = try {
                    destinationService.getAllInfors().body()
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
                homeViewModel.addAllInfors(requestInformation as MutableList<Infor>)

            }

            withContext(Dispatchers.Main)
            {
                var infor = homeViewModel.getFirstInfor()
                tvCountry.text = "Country: "+infor.country
                tvDailyConfirmed.text = "Daily Confirmed: "+infor.dailyConfirmed.toString()
                tvDailyDeaths.text = "Daily Deaths: "+infor.dailyDeaths.toString()
                tvTotalConfirmed.text ="Total Confirmed: "+infor.totalConfirmed.toString()
                tvTotalDeaths.text = "Total Deaths: "+infor.totalDeaths.toString()
            }
        }
    }


}