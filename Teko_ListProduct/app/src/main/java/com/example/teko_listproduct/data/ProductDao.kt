package com.example.teko_listproduct.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.teko_listproduct.models.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: Product)

    @Query("DELETE FROM product_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM product_table ORDER BY id ASC ")
    fun getAllProduct() : LiveData<List<Product>>


}