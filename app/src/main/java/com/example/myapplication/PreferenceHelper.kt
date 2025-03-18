package com.example.myapplication

import android.content.Context
import android.content.Context.MODE_PRIVATE

class PreferenceHelper (context: Context) {
    private val sharedPreferences = context.getSharedPreferences("Duong", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun save(username: String , password:String) {
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }

    fun getUser(): Pair<String?, String?> {
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        return Pair(username, password)
    }

    fun clearUser() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply() // hoặc editor.commit()
    }
}