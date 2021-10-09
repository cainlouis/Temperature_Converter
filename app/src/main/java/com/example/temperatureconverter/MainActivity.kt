package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.CalculateButton)
        val img = findViewById<ImageView>(R.id.imageView)
        val userInput = findViewById<EditText>(R.id.InputTextNumber)
        val result = findViewById<TextView>(R.id.ResultTextView)

        button.setOnClickListener {
            val input = userInput.text.toString().toInt()
            val minTemp = -50
            val maxTemp = 50
            if ((input > maxTemp) || (input < minTemp)) {
                val errorMessage = Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT)
                errorMessage.show()
            }
            else {
                val fahrenheit = calculateTemperature(input)
                result.text = fahrenheit.toString()
            }
        }

    }

    private fun calculateTemperature(temp: Int): Double {
        return temp * 1.8 + 32
    }

}