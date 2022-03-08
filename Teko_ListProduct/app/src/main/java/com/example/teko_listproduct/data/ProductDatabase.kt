package com.example.teko_listproduct.data

import android.content.Context
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.teko_listproduct.models.Product
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [Product::class],version = 1,exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getDatabase(context: Context): ProductDatabase {
            val instance= INSTANCE
            if(instance!=null)
            {
                return instance
            }
            synchronized(this)
            {
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }

        fun isNull():Boolean
        {
            return (INSTANCE == null)
        }
    }
}
