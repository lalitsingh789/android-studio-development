package com.example.json.model.Repository

import com.example.json.model.API.ApiService
import com.example.json.model.data.Product

class ProductRepository(private val apiService: ApiService) {
    suspend fun getProducts(): List<Product> {
        return  apiService.getProducts()
    }
}