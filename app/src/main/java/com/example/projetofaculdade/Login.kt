package com.example.projetofaculdade
import okhttp3.OkHttpClient

class Login {
    fun login(username: String, password: String): String {
        val client = NetworkClient()
        val response = client.run("http://20.206.248.196:3000/api/logins")
        return  response
    }
}