package com.example.database.CRUD


import com.example.database.db


fun deleteUser(gender: String) {
    db.collection("users").document(gender)
        .delete()
        .addOnSuccessListener {
            println("User successfully deleted")
        }
        .addOnFailureListener { e ->
            println("Error deleting user: $e")
        }
}