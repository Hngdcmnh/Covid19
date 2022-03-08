package com.example.teko_listproduct.fragments.list

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.teko_listproduct.data.ProductDatabase
import com.example.teko_listproduct.data.ProductRepository
import com.example.teko_listproduct.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductViewModel(application: Application): AndroidViewModel(application){
    var productRepository:ProductRepository

    var  allProduct:ArrayList<Product> = ArrayList()
    var _allProduct: LiveData<List<Product>> = MutableLiveData()

    init {
        var productDao = ProductDatabase.getDatabase(application).productDao()
        productRepository = ProductRepository(productDao)
        _allProduct = productRepository.getAllProduct
    }

    fun addProduct(product:Product)
    {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.addProduct(product)
        }
    }

    fun addAllProduct(list:ArrayList<Product>)
    {
        viewModelScope.launch(Dispatchers.IO) {
            for (product in list) {
                if(!productRepository.getAllProduct.value!!.contains(product)) {
                    productRepository.addProduct(product)
                }
            }
        }
    }

    fun deleteAll()
    {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.deleteAll()
        }
    }


}