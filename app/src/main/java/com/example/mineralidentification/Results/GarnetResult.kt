package com.example.mineralidentification.Results

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mineralidentification.R

class GarnetResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garnet_result)
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            finish()
        }
    }
}
