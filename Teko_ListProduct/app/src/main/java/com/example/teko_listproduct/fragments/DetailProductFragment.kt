package com.example.teko_listproduct.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.teko_listproduct.R
import com.example.teko_listproduct.models.Product
import com.squareup.picasso.Picasso

class DetailProductFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        super.onViewCreated(view, bundle)

        /**
         * get product from list fragment
         */
        var productDetail = arguments?.get("detail_product") as Product
        Log.e("ll",productDetail.name)

        var bt_back = view.findViewById<ImageButton>(R.id.bt_back_detail_product)
        var tv_header_name = view.findViewById<TextView>(R.id.tv_header_name_detail_product)
        var tv_header_price = view.findViewById<TextView>(R.id.tv_header_price_detail_product)
        var tv_name = view.findViewById<TextView>(R.id.tv_name_detail_product)
        var tv_price = view.findViewById<TextView>(R.id.tv_price_detail_product)
        var tv_code = view.findViewById<TextView>(R.id.tv_code_detail_product)
        var image = view.findViewById<ImageView>(R.id.imv_image_detail_product)
        Picasso.get().load(productDetail.imageUrl)
            .fit()
            .centerInside()
            .into(image)

        if(productDetail.name.length >30) {
            tv_header_name.text = productDetail.name.subSequence(0,30).toString()+"..."
        }
        else
        {
            tv_header_name.text = productDetail.name
        }
        tv_header_price.text = productDetail.price.toString()+"$"
        tv_name.text = productDetail.name
        tv_price.text = productDetail.price.toString()+"$"
        tv_code.text = productDetail.code


        bt_back.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailProductFragment_to_listProductFragment)
        }
    }


}