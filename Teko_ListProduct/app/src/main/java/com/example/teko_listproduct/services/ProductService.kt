package com.example.teko_listproduct.services

import com.example.teko_listproduct.models.Product
import retrofit2.Call
import retrofit2.http.GET


interface ProductService {
    @GET("products")
    fun getAllProducts() : Call<List<Product>>
}