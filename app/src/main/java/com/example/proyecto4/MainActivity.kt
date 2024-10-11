package com.example.proyecto4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declarar el binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón de inicio de sesión
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Validar solo para un usuario específico
            if (username == "ElmerPineda" && password == "elmer12345") {
                // Credenciales correctas, navega a SecondActivity
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            } else {
                // Credenciales incorrectas, muestra un mensaje de error
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}