package com.example.database.CRUD

import android.content.ContentValues.TAG
import android.util.Log
import com.example.database.Model.User
import com.example.database.db


fun addUser(name:String,age:Int,gender:String){
    val user = User(name,age)
    db.collection("users")
        .document(gender)
        .set(user)
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}