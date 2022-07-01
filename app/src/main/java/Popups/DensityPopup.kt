package Popups

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mineralidentification.R

class DensityPopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.density_popup)

        val back = findViewById<Button>(R.id.back7)

        back.setOnClickListener {
            finish()
        }
    }
}