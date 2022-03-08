package com.example.teko_listproduct.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teko_listproduct.R
import com.example.teko_listproduct.models.Product
import com.example.teko_listproduct.services.ProductService
import com.example.teko_listproduct.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Response
import kotlin.concurrent.thread

class ListProductFragment : Fragment() {

    lateinit var listProductViewModel: ListProductViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return  inflater.inflate(R.layout.fragment_list_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bt_back = view.findViewById<ImageButton>(R.id.bt_back)
        bt_back.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_listProductFragment_to_homeFragment)
        }

        val productRecycler = view.findViewById<RecyclerView>(R.id.product_recycler)
        productRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }


        /**
         * load data form API
         */
        loadAllProducts(view,productRecycler)
        val searchView = view.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_view)
        val searchList:ArrayList<Product> = arrayListOf()


        /**
         * update data from database
         */
        listProductViewModel= ViewModelProvider(this).get(ListProductViewModel::class.java)
        listProductViewModel._allProduct.observe(viewLifecycleOwner, Observer { it-> productRecycler.adapter = ListProductAdapter(it) })


        /**
         * update change of search view
         */
        searchList.addAll(listProductViewModel.allProduct)

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.lowercase()
                if(searchText!="")
                {
                    for(product in listProductViewModel._allProduct.value!!)
                    {
                        if(searchText.contains(product.brand.lowercase()))
                        {
                            searchList.add(product)
                        }
                    }
                    productRecycler.adapter = ListProductAdapter(searchList)
                    productRecycler.adapter?.notifyDataSetChanged()
                }
                else
                {
                    searchList.addAll(listProductViewModel._allProduct.value!!)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.lowercase()
                if(searchText!="")
                {
                    for(product in listProductViewModel._allProduct.value!!)
                    {
                        if(searchText.contains(product.brand.lowercase()))
                        {
                            searchList.add(product)
                        }
                    }
                    productRecycler.adapter = ListProductAdapter(searchList)
                    productRecycler.adapter?.notifyDataSetChanged()
                }
                else
                {
                    searchList.addAll(listProductViewModel._allProduct.value!!)
                }
                return false
            }
        })
    }

    private fun loadAllProducts(view:View,productRecycler:RecyclerView) {
        val destinationService = ServiceBuilder.buildService(ProductService::class.java)
        val requestCall = destinationService.getAllProducts()

        requestCall.enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    thread {
                            listProductViewModel.addAllProduct(response.body()!! as ArrayList)
                        }
                } else {
                    Toast.makeText(
                        context,
                        "Something went wrong ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(context, "Something went wrong $t", Toast.LENGTH_LONG).show()
            }
        })
    }

}