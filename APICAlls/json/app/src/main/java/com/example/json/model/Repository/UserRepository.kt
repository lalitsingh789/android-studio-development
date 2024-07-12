package com.example.json.model.Repository

import com.example.json.model.API.ApiService
import com.example.json.model.data.User

class UserRepository(private val apiService: ApiService) {
    suspend fun getUsers(): List<User> {
        return  apiService.getUsers()
    }
}
