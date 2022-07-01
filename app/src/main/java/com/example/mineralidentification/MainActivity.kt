package com.example.mineralidentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mineralidentification.objectClasses.Mineral
import com.example.mineralidentification.objectClasses.Rock

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        //init database
        val db = DataBaseHandler(context)

        //check if minerals are already in database
        val minerals = db.readMinerals()
        val rocks = db.readRocks()
        if (minerals.size == 0) {
            //create minerals
            val quartz = Mineral("Quartz", "Colorless", "White", "Metallic",
                7.0, "Indistinct", 2.6, "It is this and that", "Conchoidal")


            db.insertMinerals(quartz)

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        if (minerals.size > 0) {
            val pyrite = Mineral("Pyrite", "Yellow", "Greenish-black", "Metallic", 6.0, "Indistinct",
                5.0, "It is this and that", "Conchoidal")
            db.insertMinerals(pyrite)
            val calcite = Mineral("Calcite", "Brown", "White", "Vitreous", 3.0,
                "Rhombohedral", 2.7, "It is this and that", "Conchoidal")
            val magnetite = Mineral("Magnetite", "Black", "Black", "Metallic", 6.0,
                "Indistinct", 5.2, "It is this and that", "Uneven")
            val bauxite = Mineral("Bauxite", "Brown", "White", "Earthy", 2.0,
                "None", 2.6, "It is this and that", "Earthy")
            val uranium = Mineral("Uranium", "Gray", "Black", "Sub-Metallic", 6.0,
                "Indistinct", 19.0, "It is this and that", "None")
            val monazite = Mineral("Monazite", "Brown", "White", "Vitreous", 5.0,
                "Distinct", 5.7, "It is this and that", "Conchoidal")
            val vermiculite = Mineral("Vermiculite", "Silver", "White", "Vitreous", 1.5,
                "Basal", 0.9, "It is this and that", "Uneven")
            val gypsum = Mineral("Gypsum", "White", "White", "Vitreous", 2.0,
                "Distinct", 2.3, "It is this and that", "Conchoidal")
            val dolomite = Mineral("Dolomite", "White", "White", "Vitreous", 4.0,
                "Rhombohedral", 2.9, "It is this and that", "Conchoidal")
            val talc = Mineral("Talc", "White", "White", "Pearly", 1.0,
                "Basal", 2.8, "It is this and that", "Irregular")
            val gold = Mineral("Gold", "Yellow", "Yellow", "Metallic", 2.5,
                "None", 19.3, "It is this and that", "Hackly")
            val graphite = Mineral("Graphite", "Black", "Black", "Metallic", 3.0,
                "Basal", 2.2, "It is this and that", "Flaky")
            val sulfur = Mineral("Sulfur", "Yellow", "Yellow", "Resinous", 2.0,
                "None", 2.1, "It is this and that", "Conchoidal")
            val diamond = Mineral("Diamond", "White", "Colorless", "Adamantine", 10.0,
                "Rhombohedral", 3.5, "It is this and that", "Irregular")
            val halite = Mineral("Halite", "Colorless", "White", "Vitreous", 2.0,
                "Cubic", 2.2, "It is this and that", "Conchoidal")
            val hematite = Mineral("Hematite", "Black", "Red", "Metallic", 5.0,
                "None", 5.3, "It is this and that", "Sub-Conchoidal")
            val nickel = Mineral("Nickel", "Silver", "Gray", "Metallic", 4.0,
                "None", 8.9, "It is this and that", "Hackly")
            val kyanite = Mineral("Kyanite", "Blue", "White", "Vitreous", 7.0,
                "Uneven", 3.6, "It is this and that", "Splintery")
            val corundum = Mineral("Corundum", "Colorless", "White", "Adamantine", 9.0,
                "None", 3.9, "It is this and that", "Conchoidal")
            val pegmatite = Mineral("Pegmatite", "Gray", "White", "Vitreous", 7.0,
                "Distinct", 2.7, "It is this and that", "Conchoidal")
            val muscovite = Mineral("Muscovite", "Silver", "White", "Vitreous", 2.0,
                "Basal", 2.8, "It is this and that", "Micaceous")
            val apatite = Mineral("Apatite", "Blue", "White", "Vitreous", 5.0,
                "Indistinct", 3.2, "It is this and that", "Conchoidal")
            val garnet = Mineral("Garnet", "Red", "White", "Vitreous", 7.0,
                "None", 3.5, "It is this and that", "Conchoidal")
            val olivine = Mineral("Olivine", "Green", "White", "Glassy", 6.0,
                "Distinct", 3.3, "It is this and that", "Conchoidal")
            val sillimanite = Mineral("Sillimanite", "Brown", "White", "Vitreous", 7.0,
                "Distinct", 3.2, "It is this and that", "Splintery")
            val epidote = Mineral("Epidote", "Green", "White", "Vitreous", 7.0,
                "Basal", 3.2, "It is this and that", "Uneven")
            val chlorite = Mineral("Chlorite", "Green", "Green", "Vitreous", 2.0,
                "Basal", 2.7, "It is this and that", "Lamellar")
            val biotite = Mineral("Biotite", "Black", "White", "Vitreous", 3.0,
                "Basal", 2.8, "It is this and that", "Micaceous")
            val tourmaline = Mineral("Tourmaline", "Black", "White", "Vitreous", 7.0,
                "Indistinct", 3.2, "It is this and that", "Uneven")
            val rutile = Mineral("Rutile", "Black", "Red", "Adamantine", 6.0,
                "Basal", 4.2, "It is this and that", "Conchoidal")
            val fluorite = Mineral("Fluorite", "Purple", "White", "Vitreous", 4.0,
                "Octahedral", 3.2, "It is this and that", "Sub-Conchoidal")
            val zircon = Mineral("Zircon", "Brown", "White", "Adamantine", 7.5,
                "Indistinct", 4.7, "It is this and that", "Conchoidal")
            val nepheline = Mineral("Nepheline", "Gray", "White", "Vitreous", 6.0,
                "Indistinct", 2.5, "It is this and that", "Sub-Conchoidal")
            val microcline = Mineral("Microcline", "Green", "White", "Vitreous", 6.0,
                "Indistinct", 2.6, "It is this and that", "Conchoidal")
            val andesine = Mineral("Andesine", "Green", "White", "Vitreous", 6.0,
                "Basal", 2.6, "It is this and that", "Irregular")
            val cordierite = Mineral("Cordierite", "Brown", "White", "Vitreous", 7.0,
                "Indistinct", 2.5, "It is this and that", "Sub-Conchoidal")
            val tremolite = Mineral("Tremolite", "White", "White", "Vitreous", 5.0,
                "Distinct", 3.0, "It is this and that", "Splintery")
            val titanite = Mineral("Titanite", "Green", "White", "Adamantine", 5.0,
                "Distinct", 4.5, "It is this and that", "Sub-Conchoidal")
            val orthpyroxene = Mineral("Orthopyroxene", "Gray", "White", "Vitreous", 5.0,
                "Basal", 2.3, "It is this and that", "Conchoidal")


            db.insertMinerals(calcite)
            db.insertMinerals(orthpyroxene)
            db.insertMinerals(tremolite)
            db.insertMinerals(titanite)
            db.insertMinerals(andesine)
            db.insertMinerals(cordierite)
            db.insertMinerals(microcline)
            db.insertMinerals(nepheline)
            db.insertMinerals(zircon)
            db.insertMinerals(fluorite)
            db.insertMinerals(rutile)
            db.insertMinerals(tourmaline)
            db.insertMinerals(chlorite)
            db.insertMinerals(biotite)
            db.insertMinerals(epidote)
            db.insertMinerals(sillimanite)
            db.insertMinerals(olivine)
            db.insertMinerals(garnet)
            db.insertMinerals(apatite)
            db.insertMinerals(muscovite)
            db.insertMinerals(pegmatite)
            db.insertMinerals(corundum)
            db.insertMinerals(kyanite)
            db.insertMinerals(nickel)
            db.insertMinerals(hematite)
            db.insertMinerals(halite)
            db.insertMinerals(diamond)
            db.insertMinerals(sulfur)
            db.insertMinerals(graphite)
            db.insertMinerals(gold)
            db.insertMinerals(talc)
            db.insertMinerals(dolomite)
            db.insertMinerals(gypsum)
            db.insertMinerals(vermiculite)
            db.insertMinerals(monazite)
            db.insertMinerals(uranium)
            db.insertMinerals(bauxite)
            db.insertMinerals(magnetite)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        if (rocks.size == 0) {
           val coal = Rock("Coal", "Black", "Quartz", "Pyrite", "Calcite",
               "Aphanitic", 3.0)
            val andesite = Rock("Andesite", "Gray", "Quartz", "P-Feldspar", "Amphibole",
                "Porphyritic", 7.0)

            db.insertRocks(coal)
            db.insertRocks(andesite)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        if (rocks.size > 0) {
            val andesite = Rock("Andesite", "Gray", "Quartz", "P-Feldspar", "Amphibole",
                "Porphyritic", 7.0)

            db.insertRocks(andesite)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}
