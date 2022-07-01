package com.example.mineralidentification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_mineral_page.*

class  MineralPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mineral_page)

        //init views

        val rlColor = findViewById<RelativeLayout>(R.id.rlColor)
        val rlStreak = findViewById<RelativeLayout>(R.id.rlStreak)
        val rlLuster = findViewById<RelativeLayout>(R.id.rlLuster)
        val rlCleavage = findViewById<RelativeLayout>(R.id.rlCleavage)
        val rlHardness = findViewById<RelativeLayout>(R.id.rlHardnesss)
        val rlFracture = findViewById<RelativeLayout>(R.id.rlFracture)
        val rlDensity = findViewById<RelativeLayout>(R.id.rlDensity)
        val tvColorHint = findViewById<TextView>(R.id.tvColorHint)
        val tvCleavageHint = findViewById<TextView>(R.id.tvCleavageHint)
        val tvFractureHint = findViewById<TextView>(R.id.tvFractureHint)
        val tvDensityHint = findViewById<TextView>(R.id.tvDensityHint)
        val tvLusterHint = findViewById<TextView>(R.id.tvLusterHint)
        val tvStreakHint = findViewById<TextView>(R.id.tvStreakHint)
        val tvHardnessHint = findViewById<TextView>(R.id.tvHardnessHint1)
        val identify =findViewById<Button>(R.id.identify)
        val context = this

        rlColor.setOnClickListener {
            val popupMenu = PopupMenu(this, rlColor)
            popupMenu.inflate(R.menu.dropdown_colors)
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
                tvHardnessHint1.text = it.title
                true
            }
            popupMenu.show()
        }
        rlDensity.setOnClickListener {
            val popupMenu = PopupMenu(this, rlDensity)
            popupMenu.inflate(R.menu.dropdown_density)
            popupMenu.setOnMenuItemClickListener {
                tvDensityHint.text = it.title
                true
            }
            popupMenu.show()
        }

        rlStreak.setOnClickListener {
            val popupMenu = PopupMenu(this, rlStreak)
            popupMenu.inflate(R.menu.dropdown_colors)
            popupMenu.setOnMenuItemClickListener {
                tvStreakHint.text = it.title
                true
            }
            popupMenu.show()
        }

        rlCleavage.setOnClickListener {
            val popupMenu = PopupMenu(this, rlCleavage)
            popupMenu.inflate(R.menu.dropdown_cleavage)
            popupMenu.setOnMenuItemClickListener {
                tvCleavageHint.text = it.title
                true
            }
            popupMenu.show()
        }

        rlFracture.setOnClickListener {
            val popupMenu = PopupMenu(this, rlFracture)
            popupMenu.inflate(R.menu.dropdown_fracture)
            popupMenu.setOnMenuItemClickListener {
                tvFractureHint.text = it.title
                true
            }
            popupMenu.show()
        }

        rlLuster.setOnClickListener {
            val popupMenu = PopupMenu(this, rlLuster)
            popupMenu.inflate(R.menu.dropdown_luster)
            popupMenu.setOnMenuItemClickListener {
                tvLusterHint.text = it.title
                true
            }
            popupMenu.show()
        }
        var db = DataBaseHandler(context)
        identify.setOnClickListener {

        }
    }
}