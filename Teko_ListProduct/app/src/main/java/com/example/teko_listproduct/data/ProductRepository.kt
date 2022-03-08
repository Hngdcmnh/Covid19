package com.example.teko_listproduct.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.teko_listproduct.models.Product

class ProductRepository(private var productDao: ProductDao) {
    var getAllProduct:LiveData<List<Product>> = productDao.getAllProduct()

    suspend fun addProduct(product: Product)
    {
        productDao.insertProduct(product)
    }

    suspend fun deleteAll()
    {
        productDao.deleteAll()
    }



}