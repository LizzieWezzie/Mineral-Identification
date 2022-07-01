package com.example.mineralidentification.ui.properties

import Popups.ColorPopup
import Popups.CompositionPopup
import Popups.HardnessPopup
import Popups.TexturePopup
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.example.mineralidentification.*

class GalleryViewModel : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.rock_property, container, false)

        val color = root.findViewById<RelativeLayout>(R.id.one)
        val hardness = root.findViewById<RelativeLayout>(R.id.two)
        val composition = root.findViewById<RelativeLayout>(R.id.three)
        val texture = root.findViewById<RelativeLayout>(R.id.four)

        color.setOnClickListener {
            val intent = Intent(context, ColorPopup::class.java)
            startActivity(intent)
        }
        hardness.setOnClickListener {
            val intent = Intent(context, HardnessPopup::class.java)
            startActivity(intent)
        }
        composition.setOnClickListener {
            val intent = Intent(context, CompositionPopup::class.java)
            startActivity(intent)
        }
        texture.setOnClickListener {
            val intent = Intent(context, TexturePopup::class.java)
            startActivity(intent)
        }
        return root
    }
}