package com.example.database.CRUD

import android.content.ContentValues.TAG
import android.util.Log

import com.example.database.Model.User
import com.example.database.db


fun readUser(onResult: (List<User>) -> Unit){
    db.collection("users")
        .get()
        .addOnSuccessListener { result ->
            val userList=result.map { document ->document.toObject(User::class.java) }
            onResult(userList)
        }
        .addOnFailureListener { e->
            Log.w(TAG, "Error adding document", e)
        }

}