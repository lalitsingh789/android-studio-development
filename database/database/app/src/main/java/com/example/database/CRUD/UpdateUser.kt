package com.example.database.CRUD

import com.example.database.db

fun updateUser(name: String, age: Int, gender: String) {

    val updates = mapOf(
        "name" to name,
        "gender" to gender
    )

    db.collection("users").document(gender)
        .update(updates)
        .addOnSuccessListener {
            println("User successfully updated")
        }
        .addOnFailureListener { e ->
            println("Error updating user: $e")
        }
}