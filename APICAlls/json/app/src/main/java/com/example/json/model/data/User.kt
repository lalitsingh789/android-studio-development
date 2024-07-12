package com.example.json.model.data

data class User (
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val name: Name
    )
data class Name(
    val firstname: String,
    val lastname: String
)