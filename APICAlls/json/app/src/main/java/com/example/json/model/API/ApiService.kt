package com.example.json.model.API

import com.example.json.model.data.Product
import com.example.json.model.data.User
import retrofit2.http.GET

interface  ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("Users")
    suspend fun getUsers(): List<User>
}
