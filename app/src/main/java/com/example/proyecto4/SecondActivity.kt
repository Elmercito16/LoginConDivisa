package com.example.proyecto4


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Obtener las referencias de los elementos de la interfaz
        val etAmount: EditText = findViewById(R.id.etAmount)
        val spinnerCurrency: Spinner = findViewById(R.id.spinnerCurrency)
        val btnConvert: Button = findViewById(R.id.btnConvert)
        val tvResult: TextView = findViewById(R.id.tvResult)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        // Lista de divisas para el Spinner
        val currencies = arrayOf("Soles a Dólares", "Dólares a Soles")

        // Configuración del adaptador del Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCurrency.adapter = adapter

        // Acción del botón Convertir
        btnConvert.setOnClickListener {
            val amountText = etAmount.text.toString()
            if (amountText.isNotEmpty()) {
                val amount = amountText.toDouble()
                val selectedCurrency = spinnerCurrency.selectedItem.toString()
                var result = 0.0

                // Conversión de monedas según la selección
                result = when (selectedCurrency) {
                    "Soles a Dólares" -> amount / 3.7 // Tipo de cambio de ejemplo
                    "Dólares a Soles" -> amount * 3.7
                    else -> 0.0
                }

                // Mostrar el resultado
                tvResult.text = "Resultado: $result"
            } else {
                Toast.makeText(this, "Por favor ingrese una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón Cerrar sesión11
        btnLogout.setOnClickListener {
            // Regresar a la actividad de login (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Cierra la actividad actual para evitar que el usuario pueda volver presionando el botón 'Atrás'
        }
    }
}