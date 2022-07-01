package Popups

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mineralidentification.R

class HardnessPopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hardness_popup)

        val back = findViewById<Button>(R.id.back3)

        back.setOnClickListener {
            finish()
        }
    }
}