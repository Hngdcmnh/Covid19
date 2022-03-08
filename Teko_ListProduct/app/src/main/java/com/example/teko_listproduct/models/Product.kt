package com.example.teko_listproduct.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "product_table")
data class Product (
        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("imageUrl")
        val imageUrl: String,
        @SerializedName("dateAdded")
        val dateAdded: String,
        @SerializedName("dateUpdated")
        val dateUpdated: String,
        @SerializedName("price")
        val price: Double,
        @SerializedName("brand")
        val brand: String,
        @SerializedName("code")
        val code: String,
    ):Serializable