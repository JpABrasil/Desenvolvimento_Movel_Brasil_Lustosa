package com.example.projetofaculdade

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException



class NetworkClient {
    private val client = OkHttpClient()
    @Throws(IOException::class)
    fun run(url: String): String{
        val response:Response
        val request = Request.Builder().url(url).build()
        response = this.client.newCall(request).execute()
        return response.body!!.string() //Obrigatório colocar as aspas para falar para o compilar que o valor não será nulo
    }
}

