package Popups

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mineralidentification.R

class CleavagePopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cleavage_popup)

        val back = findViewById<Button>(R.id.back5)

        back.setOnClickListener {
            finish()
        }
    }
}