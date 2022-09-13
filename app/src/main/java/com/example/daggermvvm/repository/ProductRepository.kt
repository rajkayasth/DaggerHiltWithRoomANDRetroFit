package com.example.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggermvvm.db.FakerDB
import com.example.daggermvvm.model.Product
import com.example.daggermvvm.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi,private val fakerDB: FakerDB) {

    private val _productsData = MutableLiveData<List<Product>>()
    val product :LiveData<List<Product>>
    get() = _productsData

    suspend fun getProducts(){
        val result = fakerApi.getProducts()
        if (result.isSuccessful && result.body() != null){
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _productsData.postValue(result.body())
        }
    }
}