package com.example.mineralidentification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView

class RockPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock_page)

        //init views
        val rlColor = findViewById<RelativeLayout>(R.id.rlColor)
        val rlHardness = findViewById<RelativeLayout>(R.id.rlHardnesss)
        val rlComposition = findViewById<RelativeLayout>(R.id.rlComposition)
        val rlTexture = findViewById<RelativeLayout>(R.id.rlTexture)
        val tvColorHint = findViewById<TextView>(R.id.tvColorHint)
        val tvHardnessHint = findViewById<TextView>(R.id.tvHardnessHint)
        val tvCompositionHint = findViewById<TextView>(R.id.tvCompositionHint)
        val tvTextureHint = findViewById<TextView>(R.id.tvTextureHint)

        rlColor.setOnClickListener {
            val popupMenu = PopupMenu(this, rlColor)
            popupMenu.inflate(R.menu.dropdown_rock_color)
            popupMenu.setOnMenuItemClickListener {
                tvColorHint.text = it.title
                true
            }
            popupMenu.show()
        }
        rlHardness.setOnClickListener {
            val popupMenu = PopupMenu(this, rlHardness)
            popupMenu.inflate(R.menu.dropdown_hardness)
            popupMenu.setOnMenuItemClickListener {
                tvHardnessHint.text = it.title
                true
            }
            popupMenu.show()
        }
        rlComposition.setOnClickListener {
            val popupMenu = PopupMenu(this, rlComposition)
            popupMenu.inflate(R.menu.dropdown_composition)
            popupMenu.setOnMenuItemClickListener {
                tvCompositionHint.text = it.title
                true
            }
            popupMenu.show()
        }
        rlTexture.setOnClickListener {
            val popupMenu = PopupMenu(this, rlTexture)
            popupMenu.inflate(R.menu.dropdown_texture)
            popupMenu.setOnMenuItemClickListener {
                tvTextureHint.text = it.title
                true
            }
            popupMenu.show()
        }
    }
}
