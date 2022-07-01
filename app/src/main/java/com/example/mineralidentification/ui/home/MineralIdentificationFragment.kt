package com.example.mineralidentification.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.mineralidentification.DataBaseHandler
import com.example.mineralidentification.R
import com.example.mineralidentification.ResultHandler
import kotlinx.android.synthetic.main.activity_mineral_page.*

class MineralIdentificationFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.activity_mineral_page, container, false)

        //init views

        val rlColor = root.findViewById<RelativeLayout>(R.id.rlColor)
        val rlStreak = root.findViewById<RelativeLayout>(R.id.rlStreak)
        val rlLuster = root.findViewById<RelativeLayout>(R.id.rlLuster)
        val rlCleavage = root.findViewById<RelativeLayout>(R.id.rlCleavage)
        val rlFracture = root.findViewById<RelativeLayout>(R.id.rlFracture)
        val rlHardness = root.findViewById<RelativeLayout>(R.id.rlHardnesss)
        val rlDensity = root.findViewById<RelativeLayout>(R.id.rlDensity)
        val tvColorHint = root.findViewById<TextView>(R.id.tvColorHint)
        val tvCleavageHint = root.findViewById<TextView>(R.id.tvCleavageHint)
        val tvLusterHint = root.findViewById<TextView>(R.id.tvLusterHint)
        val tvStreakHint = root.findViewById<TextView>(R.id.tvStreakHint)
        val tvHardnessHint1 = root.findViewById<TextView>(R.id.tvHardnessHint1)
        val tvDensityHint = root.findViewById<TextView>(R.id.tvDensityHint)
        val tvFractureHint = root.findViewById<TextView>(R.id.tvFractureHint)
        val identify = root.findViewById<Button>(R.id.identify)
        val clean = root.findViewById<Button>(R.id.clean)

        var word1 = ""
        var word2 = ""
        var word3 = ""
        var word4 = ""
        var word5 = ""
        var word6 = ""
        var word7 = ""

        //init database

        clean.setOnClickListener {
            tvColorHint.text = "Physical appearance of a mineral"
            tvCleavageHint.text = "How a mineral breaks"
            tvDensityHint.text = "Mass per unit volume"
            tvFractureHint.text = "How a mineral breaks at random"
            tvHardnessHint1.text = "Mineral's resistance to being scratched"
            tvLusterHint.text = "How a mineral reflects light"
            tvStreakHint.text = "Color of powdered form of mineral"
            word1 = ""
            word2 = ""
            word3 = ""
            word4 = ""
            word5 = ""
            word6 = ""
            word7 = ""
        }
        rlColor.setOnClickListener {
            val popupMenu = PopupMenu(context, rlColor)
            popupMenu.inflate(R.menu.dropdown_colors)
            popupMenu.setOnMenuItemClickListener {
                tvColorHint.text = it.title
                word1 = tvColorHint.text as String
                true
            }
            popupMenu.show()
        }

        rlHardness.setOnClickListener {
            val popupMenu = PopupMenu(context, rlHardness)
            popupMenu.inflate(R.menu.dropdown_hardness)
            popupMenu.setOnMenuItemClickListener {
                tvHardnessHint1.text = it.title
                word5 = tvHardnessHint1.text as String
                true
            }
            popupMenu.show()
        }

        rlStreak.setOnClickListener {
            val popupMenu = PopupMenu(context, rlStreak)
            popupMenu.inflate(R.menu.dropdown_colors)
            popupMenu.setOnMenuItemClickListener {
                tvStreakHint.text = it.title
                word7 = tvStreakHint.text as String
                true
            }
            popupMenu.show()
        }

        rlDensity.setOnClickListener {
            val popupMenu = PopupMenu(context, rlDensity)
            popupMenu.inflate(R.menu.dropdown_density)
            popupMenu.setOnMenuItemClickListener {
                tvDensityHint.text = it.title
                word3 = tvDensityHint.text as String
                true
            }
            popupMenu.show()
        }
        rlCleavage.setOnClickListener {
            val popupMenu = PopupMenu(context, rlCleavage)
            popupMenu.inflate(R.menu.dropdown_cleavage)
            popupMenu.setOnMenuItemClickListener {
                tvCleavageHint.text = it.title
                word2 = tvCleavageHint.text as String
                true
            }
            popupMenu.show()
        }

        rlFracture.setOnClickListener {
            val popupMenu = PopupMenu(context, rlFracture)
            popupMenu.inflate(R.menu.dropdown_fracture)
            popupMenu.setOnMenuItemClickListener {
                tvFractureHint.text = it.title
                word4 = tvFractureHint.text as String
                true
            }
            popupMenu.show()
        }


        rlLuster.setOnClickListener {
            val popupMenu = PopupMenu(context, rlLuster)
            popupMenu.inflate(R.menu.dropdown_luster)
            popupMenu.setOnMenuItemClickListener {
                tvLusterHint.text = it.title
                word6 = tvLusterHint.text as String
                true
            }
            popupMenu.show()
        }

        //init database

        identify.setOnClickListener {
            if (tvColorHint.text == "Physical appearance of a mineral" && tvCleavageHint.text == "How a mineral breaks" &&
                tvDensityHint.text == "Mass per unit volume"
                && tvFractureHint.text == "How a mineral breaks at random" && tvHardnessHint1.text == "Mineral's resistance to being scratched"
                && tvLusterHint.text == "How a mineral reflects light" && tvStreakHint.text == "Color of powdered form of mineral") {
                Toast.makeText(activity, "Enter at least ONE property", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(context, ResultHandler::class.java)
                intent.putExtra("color", word1)
                intent.putExtra("streak", word7)
                intent.putExtra("luster", word6)
                intent.putExtra("cleavage", word2)
                intent.putExtra("fracture", word4)
                intent.putExtra("hardness", word5)
                intent.putExtra("density", word3)
                startActivity(intent)
            }

        }

        return root
    }

}