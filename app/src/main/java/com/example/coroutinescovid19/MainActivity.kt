package com.example.coroutinescovid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinescovid19.ui.HomeFragment
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container,homeFragment).commit()
    }



}