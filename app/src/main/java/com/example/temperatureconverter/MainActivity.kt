package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var img: ImageView
    private lateinit var userInput: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.CalculateButton)
        img = findViewById(R.id.imageView)
        userInput = findViewById(R.id.InputTextNumber)
        result = findViewById(R.id.ResultTextView)

        button.setOnClickListener {
            var input = userInput.text.toString().toDouble()
            val minTemp = -50
            val maxTemp = 50
            if ((input > maxTemp) || (input < minTemp)) {
                displayToast()
            }
            else {
                var fahrenheit = calculateTemperature(input)
                var roundFahrenheit = String.format("%.1f", fahrenheit)
                result.text = roundFahrenheit
                displayImage(input)
            }
        }

    }

    //return the result of the conversion from C to F
    private fun calculateTemperature(temp: Double): Double {
        return temp * 1.8 + 32
    }

    //Display the toast message
    private fun displayToast() {
        val errorMessage = Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT)
        errorMessage.show()
    }

    //Display the right image according to the input
    private fun displayImage(input: Double) {
        when {
            input < 19 -> {
                img.setImageResource(R.drawable.cold_weather)
            }
            input in 19.0..24.0 -> {
                img.setImageResource(R.drawable.good_weather)
            }
            else -> {
                img.setImageResource(R.drawable.hot_weather)
            }
        }
    }

}