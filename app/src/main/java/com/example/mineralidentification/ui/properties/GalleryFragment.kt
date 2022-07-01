package com.example.mineralidentification.ui.properties

import Popups.*
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.mineralidentification.*

class GalleryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val root = inflater.inflate(R.layout.mineral_property, container, false)

        val color = root.findViewById<RelativeLayout>(R.id.one)
        val hardness = root.findViewById<RelativeLayout>(R.id.two)
        val streak = root.findViewById<RelativeLayout>(R.id.three)
        val luster = root.findViewById<RelativeLayout>(R.id.four)
        val cleavage = root.findViewById<RelativeLayout>(R.id.five)
        val fracture = root.findViewById<RelativeLayout>(R.id.six)
        val density = root.findViewById<RelativeLayout>(R.id.seven)

        color.setOnClickListener {
            val intent = Intent(context, ColorPopup::class.java)
            startActivity(intent)
        }
        streak.setOnClickListener {
            val intent = Intent(context, StreakPopup::class.java)
            startActivity(intent)
        }
        hardness.setOnClickListener {
            val intent = Intent(context, HardnessPopup::class.java)
            startActivity(intent)
        }
        luster.setOnClickListener {
            val intent = Intent(context, LusterPopup::class.java)
            startActivity(intent)
        }
        cleavage.setOnClickListener {
            val intent = Intent(context, CleavagePopup::class.java)
            startActivity(intent)
        }
        fracture.setOnClickListener {
            val intent = Intent(context, FracturePopup::class.java)
            startActivity(intent)
        }
        density.setOnClickListener {
            val intent = Intent(context, DensityPopup::class.java)
            startActivity(intent)
        }

        return root
    }
}
