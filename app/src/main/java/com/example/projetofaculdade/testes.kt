package com.example.projetofaculdade

fun main() {
    val login = Login()
    val response = login.login("username", "password")
    println(response)
}