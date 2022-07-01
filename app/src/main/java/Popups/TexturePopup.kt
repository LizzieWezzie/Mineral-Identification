package Popups

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mineralidentification.R

class TexturePopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.texture_popup)

        val back = findViewById<Button>(R.id.back2)

        back.setOnClickListener {
            finish()
        }
    }
}