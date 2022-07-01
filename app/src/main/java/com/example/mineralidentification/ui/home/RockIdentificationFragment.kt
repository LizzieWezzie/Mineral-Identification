package com.example.mineralidentification.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.mineralidentification.Composition
import com.example.mineralidentification.R
import com.example.mineralidentification.ResultHandler
import com.example.mineralidentification.ResultHandlerRock
import kotlinx.android.synthetic.main.activity_rock_page.*

class RockIdentificationFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.activity_rock_page, container, false)

        //init views
        val rlColor = root.findViewById<RelativeLayout>(R.id.rlColor)
        val rlHardness = root.findViewById<RelativeLayout>(R.id.rlHardnesss)
        val rlComposition = root.findViewById<RelativeLayout>(R.id.rlComposition)
        val rlTexture = root.findViewById<RelativeLayout>(R.id.rlTexture)
        val tvColorHint = root.findViewById<TextView>(R.id.tvColorHint)
        val tvHardnessHint = root.findViewById<TextView>(R.id.tvHardnessHint)
        val tvCompositionHint = root.findViewById<TextView>(R.id.tvCompositionHint)
        val tvCompositionHint2 = root.findViewById<TextView>(R.id.tvCompositionHint2)
        val tvCompositionHint3 = root.findViewById<TextView>(R.id.tvCompositionHint3)
        val tvTextureHint = root.findViewById<TextView>(R.id.tvTextureHint)
        val identify = root.findViewById<Button>(R.id.identify)
        val clear = root.findViewById<Button>(R.id.clear)
        val quartzCheck = root.findViewById<CheckBox>(R.id.quartzCheck)
        val kfeldCheck = root.findViewById<CheckBox>(R.id.kfeldCheck)
        val pfeldCheck = root.findViewById<CheckBox>(R.id.pfeldCheck)
        val pyroCheck = root.findViewById<CheckBox>(R.id.pyroCheck)
        val hornCheck = root.findViewById<CheckBox>(R.id.hornCheck)
        val amphiCheck = root.findViewById<CheckBox>(R.id.amphiCheck)
        val biotiteCheck = root.findViewById<CheckBox>(R.id.biotiteCheck)
        val olivineCheck = root.findViewById<CheckBox>(R.id.olivineCheck)
        val done = root.findViewById<Button>(R.id.done)
        val clean = root.findViewById<Button>(R.id.cycle)

        fun insertText() {
            if (quartzCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
            }
            if (kfeldCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
            }
            if (pfeldCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
            }
            if (pyroCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
            }
            if (hornCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
            }
            if (amphiCheck.isChecked) {
                tvCompositionHint.text = "Amphibole"
            }
            if (biotiteCheck.isChecked) {
                tvCompositionHint.text = "Biotite"
            }
            if (olivineCheck.isChecked) {
                tvCompositionHint.text = "Olivine"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
            }
            if (quartzCheck.isChecked && pfeldCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "P-Feldspar"
            }
            if (quartzCheck.isChecked && pyroCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Pyroxene"
            }
            if (quartzCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Hornblende"
            }
            if (quartzCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Amphibole"
            }
            if (quartzCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Biotite"
            }
            if (quartzCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Olivine"
            }
            if (kfeldCheck.isChecked && pfeldCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "P-Feldspar"
            }
            if (kfeldCheck.isChecked && pyroCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
            }
            if (kfeldCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Hornblende"
            }
            if (kfeldCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Amphibole"
            }
            if (kfeldCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Biotite"
            }
            if (kfeldCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Olivine"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
            }
            if (pfeldCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Hornblende"
            }
            if (pfeldCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Amphibole"
            }
            if (pfeldCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Biotite"
            }
            if (pfeldCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Olivine"
            }
            if (pyroCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Hornblende"
            }
            if (pyroCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Amphibole"
            }
            if (pyroCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Biotite"
            }
            if (pyroCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Olivine"
            }
            if (hornCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
                tvCompositionHint2.text = "Amphibole"
            }
            if (hornCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
                tvCompositionHint2.text = "Biotite"
            }
            if (hornCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
                tvCompositionHint2.text = "Olivine"
            }
            if (amphiCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Amphibole"
                tvCompositionHint2.text = "Biotite"
            }
            if (amphiCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Amphibole"
                tvCompositionHint2.text = "Olivine"
            }
            if (biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Biotite"
                tvCompositionHint2.text = "Olivine"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked && pfeldCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
                tvCompositionHint3.text = "P-Feldspar"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked && pyroCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
                tvCompositionHint3.text = "Pyroxene"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
                tvCompositionHint3.text = "Hornblende"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
                tvCompositionHint3.text = "Amphibole"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
                tvCompositionHint3.text = "Biotite"
            }
            if (quartzCheck.isChecked && kfeldCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "K-Feldspar"
                tvCompositionHint3.text = "Olivine"
            }
            if (quartzCheck.isChecked && pfeldCheck.isChecked && pyroCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Pyroxene"
            }
            if (quartzCheck.isChecked && pfeldCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Hornblende"
            }
            if (quartzCheck.isChecked && pfeldCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Amphibole"
            }
            if (quartzCheck.isChecked && pfeldCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Biotite"
            }
            if (quartzCheck.isChecked && pfeldCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Olivine"
            }
            if (quartzCheck.isChecked && pyroCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Hornblende"
            }
            if (kfeldCheck.isChecked && pyroCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Amphibole"
            }
            if (kfeldCheck.isChecked && pyroCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Biotite"
            }
            if (kfeldCheck.isChecked && pyroCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Olivine"
            }
            if (kfeldCheck.isChecked && hornCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Amphibole"
            }
            if (kfeldCheck.isChecked && hornCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Biotite"
            }
            if (kfeldCheck.isChecked && hornCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Olivine"
            }
            if (kfeldCheck.isChecked && amphiCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Biotite"
            }
            if (kfeldCheck.isChecked && amphiCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Olivine"
            }
            if (kfeldCheck.isChecked && biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Biotite"
                tvCompositionHint3.text = "Olivine"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Hornblende"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Amphibole"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Biotite"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Amphibole"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Biotite"
            }
            if (pfeldCheck.isChecked && pyroCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Olivine"
            }
            if (pfeldCheck.isChecked && hornCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Amphibole"
            }
            if (pfeldCheck.isChecked && hornCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Biotite"
            }
            if (pfeldCheck.isChecked && hornCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Olivine"
            }
            if (pfeldCheck.isChecked && amphiCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Biotite"
            }
            if (pfeldCheck.isChecked && amphiCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Olivine"
            }
            if (pfeldCheck.isChecked && biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "P-Feldspar"
                tvCompositionHint2.text = "Biotite"
                tvCompositionHint3.text = "Olivine"
            }
            if (pyroCheck.isChecked && hornCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Amphibole"
            }
            if (pyroCheck.isChecked && hornCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Biotite"
            }
            if (pyroCheck.isChecked && hornCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Olivine"
            }
            if (pyroCheck.isChecked && amphiCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Biotite"
            }
            if (quartzCheck.isChecked && pyroCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Amphibole"
            }
            if (quartzCheck.isChecked && pyroCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Biotite"
            }
            if (quartzCheck.isChecked && pyroCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Olivine"
            }
            if (quartzCheck.isChecked && hornCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Amphibole"
            }
            if (quartzCheck.isChecked && hornCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Biotite"
            }
            if (quartzCheck.isChecked && hornCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Hornblende"
                tvCompositionHint3.text = "Olivine"
            }
            if (quartzCheck.isChecked && amphiCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Biotite"
            }
            if (quartzCheck.isChecked && amphiCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Olivine"
            }
            if (quartzCheck.isChecked && biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Quartz"
                tvCompositionHint2.text = "Biotite"
                tvCompositionHint3.text = "Olivine"
            }
            if (kfeldCheck.isChecked && pfeldCheck.isChecked && pyroCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Pyroxene"
            }
            if (kfeldCheck.isChecked && pfeldCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Hornblende"
            }
            if (kfeldCheck.isChecked && pfeldCheck.isChecked && amphiCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Amphibole"
            }
            if (kfeldCheck.isChecked && pfeldCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Biotite"
            }
            if (kfeldCheck.isChecked && pfeldCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "P-Feldspar"
                tvCompositionHint3.text = "Olivine"
            }
            if (kfeldCheck.isChecked && pyroCheck.isChecked && hornCheck.isChecked) {
                tvCompositionHint.text = "K-Feldspar"
                tvCompositionHint2.text = "Pyroxene"
                tvCompositionHint3.text = "Hornblende"
            }
            if (amphiCheck.isChecked && biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Amphibole"
                tvCompositionHint2.text = "Biotite"
                tvCompositionHint3.text = "Olivine"
            }
            if (pyroCheck.isChecked && amphiCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Olivine"
            }
            if (pyroCheck.isChecked && biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Pyroxene"
                tvCompositionHint2.text = "Biotite"
                tvCompositionHint3.text = "Olivine"
            }
            if (hornCheck.isChecked && amphiCheck.isChecked && biotiteCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Biotite"
            }
            if (hornCheck.isChecked && amphiCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
                tvCompositionHint2.text = "Amphibole"
                tvCompositionHint3.text = "Olivine"
            }
            if (hornCheck.isChecked && biotiteCheck.isChecked && olivineCheck.isChecked) {
                tvCompositionHint.text = "Hornblende"
                tvCompositionHint2.text = "Biotite"
                tvCompositionHint3.text = "Olivine"
            }
        }

        var hint1 = ""
        var hint2 = ""
        var hint3 = ""
        var hint4 = ""
        var hint5 = ""
        var hint6 = ""

        clean.setOnClickListener {
            tvCompositionHint.text = "Mineral's that make up the rock"
            tvCompositionHint2.text = ""
            tvCompositionHint3.text = ""
            hint3 = ""
            hint5 = ""
            hint6 = ""
        }

        done.setOnClickListener {
            if (!quartzCheck.isChecked && !kfeldCheck.isChecked && !pfeldCheck.isChecked &&
                !biotiteCheck.isChecked && !pyroCheck.isChecked && !hornCheck.isChecked && !amphiCheck.isChecked && !olivineCheck.isChecked) {
                Toast.makeText(activity, "Check at least ONE Mineral", Toast.LENGTH_SHORT).show()
            }
            else {
                insertText()
                hint3 = tvCompositionHint.text as String
                hint5 = tvCompositionHint2.text as String
                hint6 = tvCompositionHint3.text as String
            }
        }

        clear.setOnClickListener {
            tvColorHint.text = "Physical appearance of a mineral"
            tvHardnessHint.text = "Mineral's resistance to being scratched"
            tvCompositionHint.text = "Mineral's that make up the rock"
            tvTextureHint.text = "The size, shape, and arrangement of the grains"
            hint1 = ""
            hint2 = ""
            hint3 = ""
            hint4 = ""
            hint5 = ""
            hint6 = ""
        }
        rlColor.setOnClickListener {
            val popupMenu = PopupMenu(context, rlColor)
            popupMenu.inflate(R.menu.dropdown_colors)
            popupMenu.setOnMenuItemClickListener {
                tvColorHint.text = it.title
                hint1 = tvColorHint.text as String
                true
            }
            popupMenu.show()
        }
        rlHardness.setOnClickListener {
            val popupMenu = PopupMenu(context, rlHardness)
            popupMenu.inflate(R.menu.dropdown_hardness)
            popupMenu.setOnMenuItemClickListener {
                tvHardnessHint.text = it.title
                hint2 = tvHardnessHint.text as String
                true
            }
            popupMenu.show()
        }
        rlComposition.setOnClickListener {

        }
        rlTexture.setOnClickListener {
            val popupMenu = PopupMenu(context, rlTexture)
            popupMenu.inflate(R.menu.dropdown_texture)
            popupMenu.setOnMenuItemClickListener {
                tvTextureHint.text = it.title
                hint4 = tvTextureHint.text as String
                true
            }
            popupMenu.show()
        }
        identify.setOnClickListener {
            if (tvColorHint.text == "Physical appearance of a mineral" && tvHardnessHint.text == "Mineral's resistance to being scratched" &&
                tvCompositionHint.text == "Mineral's that make up the rock"
                && tvTextureHint.text == "The size, shape, and arrangement of the grains") {
                Toast.makeText(activity, "Enter at least ONE property", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(context, ResultHandlerRock::class.java)
                intent.putExtra("colorRock", hint1)
                intent.putExtra("hardnessRock", hint2)
                intent.putExtra("composition", hint3)
                intent.putExtra("two", hint5)
                intent.putExtra("three", hint6)
                intent.putExtra("texture", hint4)
                startActivity(intent)
            }
        }

        return root
    }
}