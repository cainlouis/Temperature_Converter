package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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
            val input = userInput.text.toString().toInt()
            val minTemp = -50
            val maxTemp = 50
            if ((input > maxTemp) || (input < minTemp)) {
                displayToast()
            }
            else {
                val fahrenheit = calculateTemperature(input)
                result.text = fahrenheit.toString()
                displayImage(input)
            }
        }

    }

    //return the result of the conversion from C to F
    private fun calculateTemperature(temp: Int): Double {
        return temp * 1.8 + 32
    }

    //Display the toast message
    private fun displayToast() {
        val errorMessage = Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT)
        errorMessage.show()
    }

    //Display the right image according to the input
    private fun displayImage(input: Int) {
        when {
            input < 19 -> {
                img.setImageResource(R.drawable.cold_weather)
            }
            input in 20..23 -> {
                img.setImageResource(R.drawable.good_weather)
            }
            else -> {
                img.setImageResource(R.drawable.hot_weather)
            }
        }
    }

}