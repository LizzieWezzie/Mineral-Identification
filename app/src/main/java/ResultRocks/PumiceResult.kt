package ResultRocks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mineralidentification.R

class PumiceResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pumice_result)
        val back = findViewById<Button>(R.id.back)

        back.setOnClickListener {
            finish()
        }
    }
}