package com.example.teko_listproduct.fragments.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.teko_listproduct.R
import com.example.teko_listproduct.fragments.DetailProductFragment


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_home, container, false)
        var bt_list = view.findViewById<Button>(R.id.bt_list_product)
        bt_list.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_listProductFragment)
        }
        return view

    }




}