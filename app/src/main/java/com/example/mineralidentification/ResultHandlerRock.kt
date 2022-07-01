package com.example.mineralidentification

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView

class ResultHandlerRock : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_handler_rock)
        val result2 = findViewById<TextView>(R.id.result2)
        val back = findViewById<Button>(R.id.back)
        val db = DataBaseHandler(this)

        back.setOnClickListener {
            finish()
        }

        val bundle: Bundle? = intent.extras
        val msg1 = bundle!!.getString("colorRock")
        val msg2 = bundle.getString("hardnessRock")
        val msg3 = bundle.getString("composition")
        val msg5 = bundle.getString("two")
        val msg6 = bundle.getString("three")
        val msg4 = bundle.getString("texture")

        val info = db.readRocks()

        //White and composition1
        val infoWhiteOlivine = db.readRocksForColorAndComp1("White", "Olivine")
        val infoWhiteKfeldspa = db.readRocksForColorAndComp1("White", "K-Feldspar")
        val infoWhitePfeldspa = db.readRocksForColorAndComp1("White", "P-Feldspar")
        val infoWhiteQuartz = db.readRocksForColorAndComp1("White", "Quartz")
        val infoWhitePyroxene = db.readRocksForColorAndComp1("White", "Pyroxene")
        val infoWhiteHornblende = db.readRocksForColorAndComp1("White", "Hornblende")
        val infoWhiteAmphibole = db.readRocksForColorAndComp1("White", "Amphibole")
        val infoWhiteBiotite = db.readRocksForColorAndComp1("White", "Biotite")

        //Red and composition1
        val infoRedOlivine = db.readRocksForColorAndComp1("Red", "Olivine")
        val infoRedKfeldspa = db.readRocksForColorAndComp1("Red", "K-Feldspar")
        val infoRedPfeldspa = db.readRocksForColorAndComp1("Red", "P-Feldspar")
        val infoRedQuartz = db.readRocksForColorAndComp1("Red", "Quartz")
        val infoRedPyroxene = db.readRocksForColorAndComp1("Red", "Pyroxene")
        val infoRedHornblende = db.readRocksForColorAndComp1("Red", "Hornblende")
        val infoRedAmphibole = db.readRocksForColorAndComp1("Red", "Amphibole")
        val infoRedBiotite = db.readRocksForColorAndComp1("Red", "Biotite")

        //Pink and composition1
        val infoPinkOlivine = db.readRocksForColorAndComp1("Pink", "Olivine")
        val infoPinkKfeldspa = db.readRocksForColorAndComp1("Pink", "K-Feldspar")
        val infoPinkPfeldspa = db.readRocksForColorAndComp1("Pink", "P-Feldspar")
        val infoPinkQuartz = db.readRocksForColorAndComp1("Pink", "Quartz")
        val infoPinkPyroxene = db.readRocksForColorAndComp1("Pink", "Pyroxene")
        val infoPinkHornblende = db.readRocksForColorAndComp1("Pink", "Hornblende")
        val infoPinkAmphibole = db.readRocksForColorAndComp1("Pink", "Amphibole")
        val infoPinkBiotite = db.readRocksForColorAndComp1("Pink", "Biotite")

        //hardness searches
        val infoOne = db.readRocksForHardness("1.0")
        val infoTwo = db.readRocksForHardness("2.0")
        val infoThree = db.readRocksForHardness("3.0")
        val infoFour = db.readRocksForHardness("4.0")
        val infoFive = db.readRocksForHardness("5.0")
        val infoSix = db.readRocksForHardness("6.0")
        val infoSeven = db.readRocksForHardness("7.0")
        val infoEight = db.readRocksForHardness("8.0")
        val infoNine = db.readRocksForHardness("9.0")
        val infoTen = db.readRocksForHardness("10.0")

        //texture searches
        val infoPhaneritic = db.readRocksForTexture("Phaneritic")
        val infoAphanitic = db.readRocksForTexture("Aphanitic")
        val infoPorphyritic = db.readRocksForTexture("Porphyritic")
        val infoGlassy = db.readRocksForTexture("Glassy")
        val infoVesicular = db.readRocksForTexture("Vesicular")
        val infoFoliated = db.readRocksForTexture("Foliated")
        val infoNonfoliated = db.readRocksForTexture("Non-foliated")

        //composition1 searches
        val infoQuarts1 = db.readRocksForComposition1("Quartz")
        val infoKFeldspar1 = db.readRocksForComposition1("K-Feldspar")
        val infoPFeldspar1 = db.readRocksForComposition1("P-Feldspar")
        val infoPyroxene1 = db.readRocksForComposition1("Pyroxene")
        val infoHornblende1 = db.readRocksForComposition1("Hornblende")
        val infoAmphibole1 = db.readRocksForComposition1("Amphibole")
        val infoBiotite1 = db.readRocksForComposition1("Biotite")
        val infoOlivine1 = db.readRocksForComposition1("Olivine")

        //color searches
        val infoWhite = db.readRocksForColor("White")
        val infoRed = db.readRocksForColor("Red")
        val infoPink = db.readRocksForColor("Pink")
        val infoGreen = db.readRocksForColor("Green")
        val infoGray = db.readRocksForColor("Gray")
        val infoYellow = db.readRocksForColor("Yellow")
        val infoGold = db.readRocksForColor("Gold")
        val infoBlack = db.readRocksForColor("Black")
        val infoBrown = db.readRocksForColor("Brown")
        val infoBlue = db.readRocksForColor("Blue")
        val infoOrange = db.readRocksForColor("Orange")
        val infoPurple = db.readRocksForColor("Purple")
        val infoViolet = db.readRocksForColor("Violet")

        //color and texture
        val infoBlackAphanitic = db.readRocksForColorAndTexture("Black", "Aphanitic")
        val infoGrayPorphyritic = db.readRocksForColorAndTexture("Gray", "Porphyritic")

        //color and comp1
        val infoBlackQuartz = db.readRocksForColorAndComp1("Black", "Quartz")
        val infoGrayQuartz = db.readRocksForColorAndComp1("Gray", "Quartz")

        //color and comp2
        val infoGrayQuartzPFeld = db.readRocksForColorComp1AndComp2("Gray", "Quartz", "P-Feldspar")
        fun onClick() {
            result2.text = ""
            //color comp1 and comp2
            if (msg1 == "Gray" && msg2 == "" && msg3 == "Quartz" && msg4 == "" && msg5 == "P-Feldspar" && msg6 == "") {
                for (i in 0 until infoGrayQuartzPFeld.size){
                    result2.append(infoGrayQuartzPFeld[i].name + "\n" + "Color:                      " + infoGrayQuartzPFeld[i].color +
                            "\n" + "Composition:        " + infoGrayQuartzPFeld[i].composition1 + ", " +
                            infoGrayQuartzPFeld[i].composition2 + ", " + "\n" + "                                " + infoGrayQuartzPFeld[i].composition3 + "\n" +
                            "Hardness:              " + infoGrayQuartzPFeld[i].hardness + "\n" + "Texture:                 " +
                            infoGrayQuartzPFeld[i].texture + "\n" + "\n")
                }
            }
            //color and comp1
            if (msg1 == "Black" && msg2 == "" && msg3 == "Quartz" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoBlackQuartz.size){
                    result2.append(infoBlackQuartz[i].name + "\n" + "Color:                      " + infoBlackQuartz[i].color +
                            "\n" + "Composition:        " + infoBlackQuartz[i].composition1 + ", " +
                            infoBlackQuartz[i].composition2 + ", " + "\n" + "                                " + infoBlackQuartz[i].composition3 + "\n" +
                            "Hardness:              " + infoBlackQuartz[i].hardness + "\n" + "Texture:                 " +
                            infoBlackQuartz[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "Quartz" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoGrayQuartz.size){
                    result2.append(infoGrayQuartz[i].name + "\n" + "Color:                      " + infoGrayQuartz[i].color +
                            "\n" + "Composition:        " + infoGrayQuartz[i].composition1 + ", " +
                            infoGrayQuartz[i].composition2 + ", " + "\n" + "                                " + infoGrayQuartz[i].composition3 + "\n" +
                            "Hardness:              " + infoGrayQuartz[i].hardness + "\n" + "Texture:                 " +
                            infoGrayQuartz[i].texture + "\n" + "\n")
                }
            }
            //color and texture
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "Aphanitic" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoBlackAphanitic.size){
                    result2.append(infoBlackAphanitic[i].name + "\n" + "Color:                      " + infoBlackAphanitic[i].color +
                            "\n" + "Composition:        " + infoBlackAphanitic[i].composition1 + ", " +
                            infoBlackAphanitic[i].composition2 + ", " + "\n" + "                                " + infoBlackAphanitic[i].composition3 + "\n" +
                            "Hardness:              " + infoBlackAphanitic[i].hardness + "\n" + "Texture:                 " +
                            infoBlackAphanitic[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "Porphyritic" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoGrayPorphyritic.size){
                    result2.append(infoGrayPorphyritic[i].name + "\n" + "Color:                      " + infoGrayPorphyritic[i].color +
                            "\n" + "Composition:        " + infoGrayPorphyritic[i].composition1 + ", " +
                            infoGrayPorphyritic[i].composition2 + ", " + "\n" + "                                " + infoGrayPorphyritic[i].composition3 + "\n" +
                            "Hardness:              " + infoGrayPorphyritic[i].hardness + "\n" + "Texture:                 " +
                            infoGrayPorphyritic[i].texture + "\n" + "\n")
                }
            }
            //color and comp1
            if (msg1 == "White" && msg2 == "" && msg3 == "Olivine" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoWhiteOlivine.size){
                    result2.append(infoWhiteOlivine[i].name + "\n" + "Color:                      " + infoWhiteOlivine[i].color +
                            "\n" + "Composition:        " + infoWhiteOlivine[i].composition1 + ", " +
                            infoWhiteOlivine[i].composition2 + ", " + "\n" + "                                " + infoWhiteOlivine[i].composition3 + "\n" +
                            "Hardness:              " + infoWhiteOlivine[i].hardness + "\n" + "Texture:                 " +
                            infoWhiteOlivine[i].texture + "\n" + "\n")
                }
            }
            //color lone searches
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoWhite.size){
                    result2.append(infoWhite[i].name + "\n" + "Color:                      " + infoWhite[i].color +
                            "\n" + "Composition:        " + infoWhite[i].composition1 + ", " +
                            infoWhite[i].composition2 + ", " + "\n" + "                                " + infoWhite[i].composition3 + "\n" +
                            "Hardness:              " + infoWhite[i].hardness + "\n" + "Texture:                 " +
                            infoWhite[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Red" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoRed.size){
                    result2.append(infoRed[i].name + "\n" + "Color:                      " + infoRed[i].color +
                            "\n" + "Composition:        " + infoRed[i].composition1 + ", " +
                            infoRed[i].composition2 + ", " + "\n" + "                                " + infoRed[i].composition3 + "\n" +
                            "Hardness:              " + infoRed[i].hardness + "\n" + "Texture:                 " +
                            infoRed[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Pink" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoPink.size){
                    result2.append(infoPink[i].name + "\n" + "Color:                      " + infoPink[i].color +
                            "\n" + "Composition:        " + infoPink[i].composition1 + ", " +
                            infoPink[i].composition2 + ", " + "\n" + "                                " + infoPink[i].composition3 + "\n" +
                            "Hardness:              " + infoPink[i].hardness + "\n" + "Texture:                 " +
                            infoPink[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoGreen.size){
                    result2.append(infoGreen[i].name + "\n" + "Color:                      " + infoGreen[i].color +
                            "\n" + "Composition:        " + infoGreen[i].composition1 + ", " +
                            infoGreen[i].composition2 + ", " + "\n" + "                                " + infoGreen[i].composition3 + "\n" +
                            "Hardness:              " + infoGreen[i].hardness + "\n" + "Texture:                 " +
                            infoGreen[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoGray.size){
                    result2.append(infoGray[i].name + "\n" + "Color:                      " + infoGray[i].color +
                            "\n" + "Composition:        " + infoGray[i].composition1 + ", " +
                            infoGray[i].composition2 + ", " + "\n" + "                                " + infoGray[i].composition3 + "\n" +
                            "Hardness:              " + infoGray[i].hardness + "\n" + "Texture:                 " +
                            infoGray[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoYellow.size){
                    result2.append(infoYellow[i].name + "\n" + "Color:                      " + infoYellow[i].color +
                            "\n" + "Composition:        " + infoYellow[i].composition1 + ", " +
                            infoYellow[i].composition2 + ", " + "\n" + "                                " + infoYellow[i].composition3 + "\n" +
                            "Hardness:              " + infoYellow[i].hardness + "\n" + "Texture:                 " +
                            infoYellow[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Gold" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoGold.size){
                    result2.append(infoGold[i].name + "\n" + "Color:                      " + infoGold[i].color +
                            "\n" + "Composition:        " + infoGold[i].composition1 + ", " +
                            infoGold[i].composition2 + ", " + "\n" + "                                " + infoGold[i].composition3 + "\n" +
                            "Hardness:              " + infoGold[i].hardness + "\n" + "Texture:                 " +
                            infoGold[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoBlack.size){
                    result2.append(infoBlack[i].name + "\n" + "Color:                      " + infoBlack[i].color +
                            "\n" + "Composition:        " + infoBlack[i].composition1 + ", " +
                            infoBlack[i].composition2 + ", " + "\n" + "                                " + infoBlack[i].composition3 + "\n" +
                            "Hardness:              " + infoBlack[i].hardness + "\n" + "Texture:                 " +
                            infoBlack[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Blue" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoBlue.size){
                    result2.append(infoBlue[i].name + "\n" + "Color:                      " + infoBlue[i].color +
                            "\n" + "Composition:        " + infoBlue[i].composition1 + ", " +
                            infoBlue[i].composition2 + ", " + "\n" + "                                " + infoBlue[i].composition3 + "\n" +
                            "Hardness:              " + infoBlue[i].hardness + "\n" + "Texture:                 " +
                            infoBlue[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoBrown.size){
                    result2.append(infoBrown[i].name + "\n" + "Color:                      " + infoBrown[i].color +
                            "\n" + "Composition:        " + infoBrown[i].composition1 + ", " +
                            infoBrown[i].composition2 + ", " + "\n" + "                                " + infoBrown[i].composition3 + "\n" +
                            "Hardness:              " + infoBrown[i].hardness + "\n" + "Texture:                 " +
                            infoBrown[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Orange" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoOrange.size){
                    result2.append(infoOrange[i].name + "\n" + "Color:                      " + infoOrange[i].color +
                            "\n" + "Composition:        " + infoOrange[i].composition1 + ", " +
                            infoOrange[i].composition2 + ", " + "\n" + "                                " + infoOrange[i].composition3 + "\n" +
                            "Hardness:              " + infoOrange[i].hardness + "\n" + "Texture:                 " +
                            infoOrange[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Purple" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoPurple.size){
                    result2.append(infoPurple[i].name + "\n" + "Color:                      " + infoPurple[i].color +
                            "\n" + "Composition:        " + infoPurple[i].composition1 + ", " +
                            infoPurple[i].composition2 + ", " + "\n" + "                                " + infoPurple[i].composition3 + "\n" +
                            "Hardness:              " + infoPurple[i].hardness + "\n" + "Texture:                 " +
                            infoPurple[i].texture + "\n" + "\n")
                }
            }
            if (msg1 == "Violet" && msg2 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoViolet.size){
                    result2.append(infoViolet[i].name + "\n" + "Color:                      " + infoViolet[i].color +
                            "\n" + "Composition:        " + infoViolet[i].composition1 + ", " +
                            infoViolet[i].composition2 + ", " + "\n" + "                                " + infoViolet[i].composition3 + "\n" +
                            "Hardness:              " + infoViolet[i].hardness + "\n" + "Texture:                 " +
                            infoViolet[i].texture + "\n" + "\n")
                }
            }

            //hardness lone searches
            if (msg2 == "1.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoOne.size){
                    result2.append(infoOne[i].name + "\n" + "Color:                      " + infoOne[i].color +
                            "\n" + "Composition:        " + infoOne[i].composition1 + ", " +
                            infoOne[i].composition2 + ", " + "\n" + "                                " + infoOne[i].composition3 + "\n" +
                            "Hardness:              " + infoOne[i].hardness + "\n" + "Texture:                 " +
                            infoOne[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "2.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoTwo.size){
                    result2.append(infoTwo[i].name + "\n" + "Color:                      " + infoTwo[i].color +
                            "\n" + "Composition:        " + infoTwo[i].composition1 + ", " +
                            infoTwo[i].composition2 + ", " + "\n" + "                                " + infoTwo[i].composition3 + "\n" +
                            "Hardness:              " + infoTwo[i].hardness + "\n" + "Texture:                 " +
                            infoTwo[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "3.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoThree.size){
                    result2.append(infoThree[i].name + "\n" + "Color:                      " + infoThree[i].color +
                            "\n" + "Composition:        " + infoThree[i].composition1 + ", " +
                            infoThree[i].composition2 + ", " + "\n" + "                                " + infoThree[i].composition3 + "\n" +
                            "Hardness:              " + infoThree[i].hardness + "\n" + "Texture:                 " +
                            infoThree[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "4.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoFour.size){
                    result2.append(infoFour[i].name + "\n" + "Color:                      " + infoFour[i].color +
                            "\n" + "Composition:        " + infoFour[i].composition1 + ", " +
                            infoFour[i].composition2 + ", " + "\n" + "                                " + infoFour[i].composition3 + "\n" +
                            "Hardness:              " + infoFour[i].hardness + "\n" + "Texture:                 " +
                            infoFour[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "5.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoFive.size){
                    result2.append(infoFive[i].name + "\n" + "Color:                      " + infoFive[i].color +
                            "\n" + "Composition:        " + infoFive[i].composition1 + ", " +
                            infoFive[i].composition2 + ", " + "\n" + "                                " + infoFive[i].composition3 + "\n" +
                            "Hardness:              " + infoFive[i].hardness + "\n" + "Texture:                 " +
                            infoFive[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "6.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoSix.size){
                    result2.append(infoSix[i].name + "\n" + "Color:                      " + infoSix[i].color +
                            "\n" + "Composition:        " + infoSix[i].composition1 + ", " +
                            infoSix[i].composition2 + ", " + "\n" + "                                " + infoSix[i].composition3 + "\n" +
                            "Hardness:              " + infoSix[i].hardness + "\n" + "Texture:                 " +
                            infoSix[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "7.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoSeven.size){
                    result2.append(infoSeven[i].name + "\n" + "Color:                      " + infoSeven[i].color +
                            "\n" + "Composition:        " + infoSeven[i].composition1 + ", " +
                            infoSeven[i].composition2 + ", " + "\n" + "                                " + infoSeven[i].composition3 + "\n" +
                            "Hardness:              " + infoSeven[i].hardness + "\n" + "Texture:                 " +
                            infoSeven[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "8.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoEight.size){
                    result2.append(infoEight[i].name + "\n" + "Color:                      " + infoEight[i].color +
                            "\n" + "Composition:        " + infoEight[i].composition1 + ", " +
                            infoEight[i].composition2 + ", " + "\n" + "                                " + infoEight[i].composition3 + "\n" +
                            "Hardness:              " + infoEight[i].hardness + "\n" + "Texture:                 " +
                            infoEight[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "9.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoNine.size){
                    result2.append(infoNine[i].name + "\n" + "Color:                      " + infoNine[i].color +
                            "\n" + "Composition:        " + infoNine[i].composition1 + ", " +
                            infoNine[i].composition2 + ", " + "\n" + "                                " + infoNine[i].composition3 + "\n" +
                            "Hardness:              " + infoNine[i].hardness + "\n" + "Texture:                 " +
                            infoNine[i].texture + "\n" + "\n")
                }
            }
            if (msg2 == "10.0" && msg1 == "" && msg3 == "" && msg4 == "") {
                for (i in 0 until infoTen.size){
                    result2.append(infoTen[i].name + "\n" + "Color:                      " + infoTen[i].color +
                            "\n" + "Composition:        " + infoTen[i].composition1 + ", " +
                            infoTen[i].composition2 + ", " + "\n" + "                                " + infoTen[i].composition3 + "\n" +
                            "Hardness:              " + infoTen[i].hardness + "\n" + "Texture:                 " +
                            infoTen[i].texture + "\n" + "\n")
                }
            }

            //texture lone searches
            if (msg4 == "Glassy" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoGlassy.size){
                    result2.append(infoGlassy[i].name + "\n" + "Color:                      " + infoGlassy[i].color +
                            "\n" + "Composition:        " + infoGlassy[i].composition1 + ", " +
                            infoGlassy[i].composition2 + ", " + "\n" + "                                " + infoGlassy[i].composition3 + "\n" +
                            "Hardness:              " + infoGlassy[i].hardness + "\n" + "Texture:                 " +
                            infoGlassy[i].texture + "\n" + "\n")
                }
            }
            if (msg4 == "Aphanitic" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoAphanitic.size){
                    result2.append(infoAphanitic[i].name + "\n" + "Color:                      " + infoAphanitic[i].color +
                            "\n" + "Composition:        " + infoAphanitic[i].composition1 + ", " +
                            infoAphanitic[i].composition2 + ", " + "\n" + "                                " + infoAphanitic[i].composition3 + "\n" +
                            "Hardness:              " + infoAphanitic[i].hardness + "\n" + "Texture:                 " +
                            infoAphanitic[i].texture + "\n" + "\n")
                }
            }
            if (msg4 == "Phaneritic" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoPhaneritic.size){
                    result2.append(infoPhaneritic[i].name + "\n" + "Color:                      " + infoPhaneritic[i].color +
                            "\n" + "Composition:        " + infoPhaneritic[i].composition1 + ", " +
                            infoPhaneritic[i].composition2 + ", " + "\n" + "                                " + infoPhaneritic[i].composition3 + "\n" +
                            "Hardness:              " + infoPhaneritic[i].hardness + "\n" + "Texture:                 " +
                            infoPhaneritic[i].texture + "\n" + "\n")
                }
            }
            if (msg4 == "Foliated" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoFoliated.size){
                    result2.append(infoFoliated[i].name + "\n" + "Color:                      " + infoFoliated[i].color +
                            "\n" + "Composition:        " + infoFoliated[i].composition1 + ", " +
                            infoFoliated[i].composition2 + ", " + "\n" + "                                " + infoFoliated[i].composition3 + "\n" +
                            "Hardness:              " + infoFoliated[i].hardness + "\n" + "Texture:                 " +
                            infoFoliated[i].texture + "\n" + "\n")
                }
            }
            if (msg4 == "Non-foliated" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoNonfoliated.size){
                    result2.append(infoNonfoliated[i].name + "\n" + "Color:                      " + infoNonfoliated[i].color +
                            "\n" + "Composition:        " + infoNonfoliated[i].composition1 + ", " +
                            infoNonfoliated[i].composition2 + ", " + "\n" + "                                " + infoNonfoliated[i].composition3 + "\n" +
                            "Hardness:              " + infoNonfoliated[i].hardness + "\n" + "Texture:                 " +
                            infoNonfoliated[i].texture + "\n" + "\n")
                }
            }
            if (msg4 == "Vesicular" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoVesicular.size){
                    result2.append(infoVesicular[i].name + "\n" + "Color:                      " + infoVesicular[i].color +
                            "\n" + "Composition:        " + infoVesicular[i].composition1 + ", " +
                            infoVesicular[i].composition2 + ", " + "\n" + "                                " + infoVesicular[i].composition3 + "\n" +
                            "Hardness:              " + infoVesicular[i].hardness + "\n" + "Texture:                 " +
                            infoVesicular[i].texture + "\n" + "\n")
                }
            }
            if (msg4 == "Porphyritic" && msg2 == "" && msg3 == "" && msg1 == "") {
                for (i in 0 until infoPorphyritic.size){
                    result2.append(infoPorphyritic[i].name + "\n" + "Color:                      " + infoPorphyritic[i].color +
                            "\n" + "Composition:        " + infoPorphyritic[i].composition1 + ", " +
                            infoPorphyritic[i].composition2 + ", " + "\n" + "                                " + infoPorphyritic[i].composition3 + "\n" +
                            "Hardness:              " + infoPorphyritic[i].hardness + "\n" + "Texture:                 " +
                            infoPorphyritic[i].texture + "\n" + "\n")
                }
            }

            //composition lone searches
            if (msg3 == "Olivine" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoOlivine1.size){
                    result2.append(infoOlivine1[i].name + "\n" + "Color:                      " + infoOlivine1[i].color +
                            "\n" + "Composition:        " + infoOlivine1[i].composition1 + ", " +
                            infoOlivine1[i].composition2 + ", " + "\n" + "                                " + infoOlivine1[i].composition3 + "\n" +
                            "Hardness:              " + infoOlivine1[i].hardness + "\n" + "Texture:                 " +
                            infoOlivine1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "Quartz" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoQuarts1.size){
                    result2.append(infoQuarts1[i].name + "\n" + "Color:                      " + infoQuarts1[i].color +
                            "\n" + "Composition:        " + infoQuarts1[i].composition1 + ", " +
                            infoQuarts1[i].composition2 + ", " + "\n" + "                                " + infoQuarts1[i].composition3 + "\n" +
                            "Hardness:              " + infoQuarts1[i].hardness + "\n" + "Texture:                 " +
                            infoQuarts1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "Pyroxene" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoPyroxene1.size){
                    result2.append(infoPyroxene1[i].name + "\n" + "Color:                      " + infoPyroxene1[i].color +
                            "\n" + "Composition:        " + infoPyroxene1[i].composition1 + ", " +
                            infoPyroxene1[i].composition2 + ", " + "\n" + "                                " + infoPyroxene1[i].composition3 + "\n" +
                            "Hardness:              " + infoPyroxene1[i].hardness + "\n" + "Texture:                 " +
                            infoPyroxene1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "Hornblende" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoHornblende1.size){
                    result2.append(infoHornblende1[i].name + "\n" + "Color:                      " + infoHornblende1[i].color +
                            "\n" + "Composition:        " + infoHornblende1[i].composition1 + ", " +
                            infoHornblende1[i].composition2 + ", " + "\n" + "                                " + infoHornblende1[i].composition3 + "\n" +
                            "Hardness:              " + infoHornblende1[i].hardness + "\n" + "Texture:                 " +
                            infoHornblende1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "Amphibole" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoAmphibole1.size){
                    result2.append(infoAmphibole1[i].name + "\n" + "Color:                      " + infoAmphibole1[i].color +
                            "\n" + "Composition:        " + infoAmphibole1[i].composition1 + ", " +
                            infoAmphibole1[i].composition2 + ", " + "\n" + "                                " + infoAmphibole1[i].composition3 + "\n" +
                            "Hardness:              " + infoAmphibole1[i].hardness + "\n" + "Texture:                 " +
                            infoAmphibole1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "Biotite" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoBiotite1.size){
                    result2.append(infoBiotite1[i].name + "\n" + "Color:                      " + infoBiotite1[i].color +
                            "\n" + "Composition:        " + infoBiotite1[i].composition1 + ", " +
                            infoBiotite1[i].composition2 + ", " + "\n" + "                                " + infoBiotite1[i].composition3 + "\n" +
                            "Hardness:              " + infoBiotite1[i].hardness + "\n" + "Texture:                 " +
                            infoBiotite1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "P-Feldspar" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoPFeldspar1.size){
                    result2.append(infoPFeldspar1[i].name + "\n" + "Color:                      " + infoPFeldspar1[i].color +
                            "\n" + "Composition:        " + infoPFeldspar1[i].composition1 + ", " +
                            infoPFeldspar1[i].composition2 + ", " + "\n" + "                                " + infoPFeldspar1[i].composition3 + "\n" +
                            "Hardness:              " + infoPFeldspar1[i].hardness + "\n" + "Texture:                 " +
                            infoPFeldspar1[i].texture + "\n" + "\n")
                }
            }
            if (msg3 == "K-Feldspar" && msg2 == "" && msg1 == "" && msg4 == "" && msg5 == "" && msg6 == "") {
                for (i in 0 until infoKFeldspar1.size){
                    result2.append(infoKFeldspar1[i].name + "\n" + "Color:                      " + infoKFeldspar1[i].color +
                            "\n" + "Composition:        " + infoKFeldspar1[i].composition1 + ", " +
                            infoKFeldspar1[i].composition2 + ", " + "\n" + "                                " + infoKFeldspar1[i].composition3 + "\n" +
                            "Hardness:              " + infoKFeldspar1[i].hardness + "\n" + "Texture:                 " +
                            infoKFeldspar1[i].texture + "\n" + "\n")
                }
            }

        }
        onClick()
    }
}
