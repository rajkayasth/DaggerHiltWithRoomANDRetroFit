package com.example.daggermvvm.retrofit

import com.example.daggermvvm.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}