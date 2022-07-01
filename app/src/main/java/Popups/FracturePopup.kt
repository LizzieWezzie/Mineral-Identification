package Popups

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mineralidentification.R

class FracturePopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fracture_popup)

        val back = findViewById<Button>(R.id.back6)

        back.setOnClickListener {
            finish()
        }
    }
}