package com.example.projetofaculdade
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Define o layout da tela principal

        val btnLogin = findViewById<Button>(R.id.button)
        btnLogin.setOnClickListener { // Defina o ouvinte de clique
            val login = Login()
            val response = login.login("username", "password")
            println(response)
        }
    }

}


