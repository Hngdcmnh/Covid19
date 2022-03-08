package com.example.teko_listproduct.fragments.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teko_listproduct.R
import com.example.teko_listproduct.fragments.DetailProductFragment
import com.example.teko_listproduct.models.Product
import com.squareup.picasso.Picasso

class ListProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {
    lateinit var view:View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
        view.setOnClickListener {
            var bundle = bundleOf(Pair("detail_product", productList[position]))
            Navigation.findNavController(view).navigate(R.id.action_listProductFragment_to_detailProductFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imgProduct = itemView.findViewById<ImageView>(R.id.imv_image_product)
        var nameProduct = itemView.findViewById<TextView>(R.id.tv_name_product)
        var priceProduct = itemView.findViewById<TextView>(R.id.tv_price_product)
        fun bind(product:Product) {
            if(product.name.length >200) {
                nameProduct.text = product.name.subSequence(0,200).toString()+"..."
            }
            else
            {
                nameProduct.text = product.name
            }
            priceProduct.text = product.price.toString() + "$"
            Picasso.get().load(product.imageUrl)
                .fit()
                .centerInside()
                .into(imgProduct)
            Log.e(this.javaClass.simpleName,product.imageUrl)
        }
    }
}