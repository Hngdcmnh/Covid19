package com.example.learnrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TestAdapter(prepareList()) { num: Int -> testItemClickListener(num) }
    }

    private fun testItemClickListener(num: Int) {
        Toast.makeText(this,num.toString(),Toast.LENGTH_LONG).show()
    }

    private fun prepareList(): MutableList<Int> {
        val contactList: MutableList<Int> = mutableListOf()
        for (i in 1..10) {
            contactList.add(i)
        }
        return contactList
    }




}