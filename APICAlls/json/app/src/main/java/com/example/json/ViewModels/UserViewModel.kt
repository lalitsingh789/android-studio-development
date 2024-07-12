package com.example.json.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.json.model.data.User
import kotlinx.coroutines.launch
import com.example.json.model.API.RetrofitClient
import com.example.json.model.Repository.UserRepository

class UserViewModel: ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    private val repository = UserRepository(RetrofitClient.apiService)

    init {
        fetchUsers()
    }
    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = repository.getUsers()
                _users.postValue(userList)
            } catch (e: Exception) {

            }
        }
    }
}
