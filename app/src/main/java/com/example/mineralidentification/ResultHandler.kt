package com.example.mineralidentification

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColorInt
import androidx.core.text.toSpannable
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_mineral_page.*
import kotlinx.android.synthetic.main.activity_rock_page.*
import kotlinx.android.synthetic.main.activity_rock_page.tvColorHint
import kotlinx.android.synthetic.main.mineral_list.*
import kotlinx.android.synthetic.main.result_child.view.*

class ResultHandler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_handler)
        val result1 = findViewById<TextView>(R.id.result1)
        val back = findViewById<Button>(R.id.back)
        val db = DataBaseHandler(this)

        back.setOnClickListener {
            finish()
        }
       /* result_list = findViewById(R.id.result_list)
        result_list.layoutManager = LinearLayoutManager(this)
        result_list.layoutManager = GridLayoutManager(this, 1)*/

        val bundle: Bundle? = intent.extras
        val msg1 = bundle!!.getString("color")
        val msg2 = bundle.getString("cleavage")
        val msg3 = bundle.getString("density")
        val msg4 = bundle.getString("fracture")
        val msg5 = bundle.getString("hardness")
        val msg6 = bundle.getString("luster")
        val msg7 = bundle.getString("streak")

        result1.text = ""
        //general searches

        val data4 = db.readMineralsForColorLusterAndStreak("", "", "")
        val data5 = db.readMineralsForColorLusterAndHardness("", "", "","")
        val data6 = db.readMineralsForColorLusterHardnessAndCleavage("", "", "","", "")

        //color, streak, luster, hardness, cleavage, density
        val dataQuartz = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Colorless", "White", "Glassy",
            "7.0", "Indistinct", "2.6")
        val dataCalcite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Brown", "White", "Vitreous",
            "3.0", "Rhombohedral", "2.7")
        val dataBauxite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Brown", "White", "Earthy",
            "2.0", "None", "2.6")
        val dataPyrite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Yellow", "Black", "Metallic",
            "6.0", "Indistinct", "5.0")
        val dataUranium = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Gray", "Black", "Sub-Metallic",
            "6.0", "Indistinct", "19.0")
        val dataMonazite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Brown", "White", "Vitreous",
            "5.0", "Distinct", "5.7")
        val dataApatite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Blue", "White", "Vitreous",
            "5.0", "Indistinct", "3.2")
        val dataZircon = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Brown", "White", "Adamantine",
            "7.5", "Indistinct", "4.7")
        val dataVermiculite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Silver", "White", "Vitreous",
            "1.5", "Basal", "0.9")
        val dataTremolite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("White", "White", "Vitreous",
            "5.0", "Distinct", "3.0")
        val dataPegmatite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Gray", "White", "Vitreous",
            "7.0", "Distinct", "2.7")
        val dataOrthopyroxene = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Gray", "White", "Vitreous",
            "5.0", "Basal", "2.3")
        val dataOlivine = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Green", "White", "Glassy",
            "6.0", "Distinct", "3.3")
        val dataNickel = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Silver", "Gray", "Metallic",
            "4.0", "None", "8.9")
        val dataNepheline = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Gray", "White", "Vitreous",
            "6.0", "Indistinct", "2.5")
        val dataMuscovite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Silver", "White", "Vitreous",
            "2.0", "Basal", "2.8")
        val dataMicrocline = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Green", "White", "Vitreous",
            "6.0", "Indistinct", "2.6")
        val dataMagnetite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Black", "Black", "Metallic",
            "6.0", "Indistinct", "5.2")
        val dataKyanite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Blue", "White", "Vitreous",
            "7.0", "Uneven", "3.6")
        val dataHematite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Black", "Red", "Metallic",
            "5.0", "None", "5.3")
        val dataHalite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Colorless", "White", "Vitreous",
            "2.0", "Cubic", "2.2")
        val dataGypsum = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("White", "White", "Vitreous",
            "2.0", "Distinct", "2.3")
        val dataGraphite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Black", "Black", "Metallic",
            "3.0", "Basal", "2.2")
        val dataGoldSix = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Yellow", "Yellow", "Metallic",
            "2.5", "None", "19.3")
        val dataGarnet = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Red", "White", "Vitreous",
            "7.0", "None", "3.5")
        val dataFluorite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Purple", "White", "Vitreous",
            "4.0", "Octahedral", "3.2")
        val dataEpidote = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Green", "White", "Vitreous",
            "7.0", "Basal", "3.2")
        val dataDolomite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("White", "White", "Vitreous",
            "4.0", "Rhombohedral", "2.9")
        val dataDiamond = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("White", "Colorless", "Adamantine",
            "10.0", "Rhombohedral", "3.5")
        val dataCorundum = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Colorless", "White", "Adamantine",
            "9.0", "None", "3.9")
        val dataCordierite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Brown", "White", "Vitreous",
            "7.0", "Indistinct", "2.5")
        val dataChlorite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Green", "Green", "Vitreous",
            "2.0", "Basal", "2.7")
        val dataBiotite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Black", "White", "Vitreous",
            "3.0", "Basal", "2.8")
        val dataAndesine = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Green", "White", "Vitreous",
            "6.0", "Basal", "2.6")
        val dataTourmaline = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Black", "White", "Vitreous",
            "7.0", "Indistinct", "3.2")
        val dataTitanite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Green", "White", "Adamantine",
            "5.0", "Distinct", "4.5")
        val dataTalc = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("White", "White", "Pearly",
            "1.0", "Basal", "2.8")
        val dataSulfur = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Yellow", "Yellow", "Resinous",
            "2.0", "None", "2.1")
        val dataSillimanite = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Brown", "White", "Vitreous",
            "7.0", "Distinct", "3.2")
        val dataRutile = db.readMineralsForColorStreakLusterHardnessCleavageAndDensity("Black", "Red", "Adamantine",
            "6.0", "Basal", "4.2")

        // color and luster
        val data3 = db.readMineralsForColorAndLuster("", "")

        // color and streak
        val dataWhiteColorless = db.readMineralsForColorAndStreak("White", "Colorless")
        val dataWhiteWhite = db.readMineralsForColorAndStreak("White", "White")
        val dataBlackWhite = db.readMineralsForColorAndStreak("Black", "White")
        val dataBlackBlack = db.readMineralsForColorAndStreak("Black", "Black")
        val dataBlackRed = db.readMineralsForColorAndStreak("Black", "Red")
        val dataBrownWhite = db.readMineralsForColorAndStreak("Brown", "White")
        val dataBlueWhite = db.readMineralsForColorAndStreak("Blue", "White")
        val dataRedWhite = db.readMineralsForColorAndStreak("Red", "White")
        val dataGrayColorless = db.readMineralsForColorAndStreak("Gray", "Colorless")
        val dataGrayWhite = db.readMineralsForColorAndStreak("Gray", "White")
        val dataGrayBlack = db.readMineralsForColorAndStreak("Gray", "Black")
        val dataGreenWhite = db.readMineralsForColorAndStreak("Green", "White")
        val dataGreenGreen = db.readMineralsForColorAndStreak("Green", "Green")
        val dataYellowWhite = db.readMineralsForColorAndStreak("Yellow", "White")
        val dataYellowBlack = db.readMineralsForColorAndStreak("Yellow", "Black")
        val dataYellowYellow = db.readMineralsForColorAndStreak("Yellow", "Yellow")
        val dataPurpleWhite = db.readMineralsForColorAndStreak("Purple", "White")
        val dataColorlessWhite = db.readMineralsForColorAndStreak("Colorless", "White")
        val dataSilverWhite = db.readMineralsForColorAndStreak("Silver", "White")
        val dataSilverGray = db.readMineralsForColorAndStreak("Silver", "Gray")

        //streak and cleavage
        val dataColorlessRhombo = db.readMineralsForStreakAndCleavage("Colorless", "Rhombohedral")
        val dataWhiteBasal = db.readMineralsForStreakAndCleavage("White", "Basal")
        val dataWhiteCubic = db.readMineralsForStreakAndCleavage("White", "Cubic")
        val dataWhiteOcta = db.readMineralsForStreakAndCleavage("White", "Octahedral")
        val dataWhiteRhombo = db.readMineralsForStreakAndCleavage("White", "Rhombohedral")
        val dataWhiteIndistinct = db.readMineralsForStreakAndCleavage("White", "Indistinct")
        val dataWhiteDistinct = db.readMineralsForStreakAndCleavage("White", "Distinct")
        val dataGreenBasal = db.readMineralsForStreakAndCleavage("Green", "Basal")
        val dataBlackBasal = db.readMineralsForStreakAndCleavage("Black", "Basal")
        val dataBlackIndistinct = db.readMineralsForStreakAndCleavage("Black", "Indistinct")
        val dataRedBasal = db.readMineralsForStreakAndCleavage("Red", "Basal")
        val dataRedIndistinct = db.readMineralsForStreakAndCleavage("Red", "Indistinct")
        val dataWhiteNone = db.readMineralsForStreakAndCleavage("White", "None")
        val dataYellowNone = db.readMineralsForStreakAndCleavage("Yellow", "None")
        val dataRedNone = db.readMineralsForStreakAndCleavage("Red", "None")
        val dataWhiteUneven = db.readMineralsForStreakAndCleavage("White", "Uneven")
        val dataGrayNone = db.readMineralsForStreakAndCleavage("Gray", "None")

        //cleavage and hardness
        val dataBasalOne = db.readMineralsForCleavageAndHardness("Basal", "1.0")
        val dataBasalTwo = db.readMineralsForCleavageAndHardness("Basal", "2.0")
        val dataBasalThree = db.readMineralsForCleavageAndHardness("Basal", "3.0")
        val dataBasalFive = db.readMineralsForCleavageAndHardness("Basal", "5.0")
        val dataBasalSix = db.readMineralsForCleavageAndHardness("Basal", "6.0")
        val dataBasalSeven = db.readMineralsForCleavageAndHardness("Basal", "7.0")
        val dataCubicTwo = db.readMineralsForCleavageAndHardness("Cubic", "2.0")
        val dataIndistinct75 = db.readMineralsForCleavageAndHardness("Indistinct", "7.5")
        val dataBasal15 = db.readMineralsForCleavageAndHardness("Basal", "1.5")
        val dataNone4 = db.readMineralsForCleavageAndHardness("None", "4.0")
        val dataNone5 = db.readMineralsForCleavageAndHardness("None", "5.0")
        val dataNone9 = db.readMineralsForCleavageAndHardness("None", "9.0")
        val dataNone2 = db.readMineralsForCleavageAndHardness("None", "2.0")
        val dataNone25 = db.readMineralsForCleavageAndHardness("None", "2.5")
        val dataNone7 = db.readMineralsForCleavageAndHardness("None", "7.0")
        val dataUneven7 = db.readMineralsForCleavageAndHardness("Uneven", "7.0")
        val dataOctahedral4 = db.readMineralsForCleavageAndHardness("Octahedral", "4.0")
        val dataRhombohedral3 = db.readMineralsForCleavageAndHardness("Rhombohedral", "3.0")
        val dataRhombohedral4 = db.readMineralsForCleavageAndHardness("Rhombohedral", "4.0")
        val dataRhombohedral10 = db.readMineralsForCleavageAndHardness("Rhombohedral", "10.0")
        val dataIndistinct5 = db.readMineralsForCleavageAndHardness("Indistinct", "5.0")
        val dataIndistinct6 = db.readMineralsForCleavageAndHardness("Indistinct", "6.0")
        val dataIndistinct7 = db.readMineralsForCleavageAndHardness("Indistinct", "7.0")
        val dataDistinct2 = db.readMineralsForCleavageAndHardness("Distinct", "2.0")
        val dataDistinct5 = db.readMineralsForCleavageAndHardness("Distinct", "5.0")
        val dataDistinct6 = db.readMineralsForCleavageAndHardness("Distinct", "6.0")
        val dataDistinct7 = db.readMineralsForCleavageAndHardness("Distinct", "7.0")

        //luster hardness
        val dataGlassy7 = db.readMineralsForLusterAndHardness("Glassy", "7.0")

        //color searches
        val data2 = db.readMineralsForColor("Yellow")
        val dataBlack = db.readMineralsForColor("Black")
        val dataBlue = db.readMineralsForColor("Blue")
        val dataBrown = db.readMineralsForColor("Brown")
        val dataGray = db.readMineralsForColor("Gray")
        val dataOrange = db.readMineralsForColor("Orange")
        val dataPink = db.readMineralsForColor("Pink")
        val dataColorless = db.readMineralsForColor("Colorless")
        val dataRed = db.readMineralsForColor("Red")
        val dataWhite = db.readMineralsForColor("White")
        val dataPurple = db.readMineralsForColor("Purple")
        val dataGold = db.readMineralsForColor("Gold")
        val dataGreen = db.readMineralsForColor("Green")
        val dataViolet = db.readMineralsForColor("Violet")
        val dataSilver = db.readMineralsForColor("Silver")

        //streak searches
        val dataColorlessStreak = db.readMineralsForStreak("Colorless")
        val dataWhiteStreak = db.readMineralsForStreak("White")
        val dataGreenStreak = db.readMineralsForStreak("Green")
        val dataBlackStreak = db.readMineralsForStreak("Black")
        val dataRedStreak = db.readMineralsForStreak("Red")
        val dataShinyStreak = db.readMineralsForStreak("Shiny")
        val dataGrayStreak = db.readMineralsForStreak("Gray")
        val dataBrownStreak = db.readMineralsForStreak("Brown")
        val dataSilverStreak = db.readMineralsForStreak("Silver")
        val dataYellowStreak = db.readMineralsForStreak("Yellow")
        val dataGoldStreak = db.readMineralsForStreak("Gold")

        //luster searches
        val dataMetallic = db.readMineralsForLuster("Metallic")
        val dataNonmetallic = db.readMineralsForLuster("Non-metallic")
        val dataEarthy = db.readMineralsForLuster("Earthy")
        val dataSilky = db.readMineralsForLuster("Silky")
        val dataGlassy = db.readMineralsForLuster("Glassy")
        val dataPearly = db.readMineralsForLuster("Pearly")
        val dataSubmetallic = db.readMineralsForLuster("Sub-metallic")
        val dataDull = db.readMineralsForLuster("Dull")
        val dataVitreous = db.readMineralsForLuster("Vitreous")
        val dataAdamantine = db.readMineralsForLuster("Adamantine")
        val dataGreasy = db.readMineralsForLuster("Greasy")
        val dataWaxy = db.readMineralsForLuster("Waxy")
        val dataResinous = db.readMineralsForLuster("Resinous")

        //hardness searches
        val dataOne = db.readMineralsForHardness("1.0")
        val dataTwo = db.readMineralsForHardness("2.0")
        val dataThree = db.readMineralsForHardness("3.0")
        val dataFour = db.readMineralsForHardness("4.0")
        val dataFive = db.readMineralsForHardness("5.0")
        val dataSix = db.readMineralsForHardness("6.0")
        val dataSeven = db.readMineralsForHardness("7.0")
        val dataEight = db.readMineralsForHardness("8.0")
        val dataNine = db.readMineralsForHardness("9.0")
        val dataTen = db.readMineralsForHardness("10.0")

        //density searches
        val datazero9 = db.readMineralsForDensity("0.9")
        val dataTwo6 = db.readMineralsForDensity("2.6")
        val dataThree33 = db.readMineralsForDensity("3.0")
        val dataTwo7 = db.readMineralsForDensity("2.7")
        val dataFive5 = db.readMineralsForDensity("5.0")
        val dataFive2 = db.readMineralsForDensity("5.2")
        val dataFive7 = db.readMineralsForDensity("5.7")
        val dataTwo3 = db.readMineralsForDensity("2.3")
        val dataTwo9 = db.readMineralsForDensity("2.9")
        val dataTwo8 = db.readMineralsForDensity("2.8")
        val dataNineteen3 = db.readMineralsForDensity("19.3")
        val dataTwo2 = db.readMineralsForDensity("2.2")
        val dataTwo1 = db.readMineralsForDensity("2.1")
        val dataThree5 = db.readMineralsForDensity("3.5")
        val dataFive3 = db.readMineralsForDensity("5.3")
        val dataEight9 = db.readMineralsForDensity("8.9")
        val dataThree6 = db.readMineralsForDensity("3.6")
        val dataThree9 = db.readMineralsForDensity("3.9")
        val dataNineteen = db.readMineralsForDensity("19.0")
        val dataThree2 = db.readMineralsForDensity("3.2")
        val dataThree3 = db.readMineralsForDensity("3.3")
        val dataFour2 = db.readMineralsForDensity("4.2")
        val dataFour7 = db.readMineralsForDensity("4.7")
        val dataTwo5 = db.readMineralsForDensity("2.5")
        val dataFour5 = db.readMineralsForDensity("4.5")

        //cleavage searches
        val dataBasal = db.readMineralsForCleavage("Basal")
        val dataCubic = db.readMineralsForCleavage("Cubic")
        val dataOctahedral = db.readMineralsForCleavage("Octahedral")
        val dataPrismatic = db.readMineralsForCleavage("Prismatic")
        val dataPinicoidal = db.readMineralsForCleavage("Pinicoidal")
        val dataRhombohedral = db.readMineralsForCleavage("Rhombohedral")
        val dataIndistinct = db.readMineralsForCleavage("Indistinct")
        val dataDistinct = db.readMineralsForCleavage("Distinct")
        val dataNone = db.readMineralsForCleavage("None")
        val dataUneven = db.readMineralsForCleavage("Uneven")

        //fracture searches
        val dataConchoidal = db.readMineralsForFracture("Conchoidal")
        val dataFibrous = db.readMineralsForFracture("Fibrous")
        val dataHackly = db.readMineralsForFracture("Hackly")
        val dataIrregular = db.readMineralsForFracture("Irregular")
        val dataSplintery = db.readMineralsForFracture("Splintery")
        val dataNoneFracture = db.readMineralsForFracture("None")
        val dataUnevenFracture = db.readMineralsForFracture("Uneven")

        //luster and cleavage
        val dataIndistinctGlassy = db.readMineralsForCleavageAndLuster("Indistinct", "Glassy")

        //streak and hardness
        val dataWhite7 = db.readMineralsForStreakAndHardness("White", "7.0")

        //color, streak and luster
        val dataGreenWhiteVitreous = db.readMineralsForColorLusterAndStreak("Green", "Vitreous", "White")
        val dataBlueWhiteVitreous = db.readMineralsForColorLusterAndStreak("Blue", "Vitreous", "White")
        val dataBrownWhiteVitreous = db.readMineralsForColorLusterAndStreak("Brown", "Vitreous", "White")
        val dataBlackWhiteVitreous = db.readMineralsForColorLusterAndStreak("Black", "Vitreous", "White")
        val dataGreenGreenVitreous = db.readMineralsForColorLusterAndStreak("Green", "Vitreous", "Green")
        val dataColorlessWhiteAdamantine = db.readMineralsForColorLusterAndStreak("Colorless", "Adamantine", "White")
        val dataWhiteColorlessAdamantine = db.readMineralsForColorLusterAndStreak("White", "Adamantine", "Colorless")
        val dataWhiteWhiteVitreous = db.readMineralsForColorLusterAndStreak("White", "Vitreous", "White")
        val dataPurpleWhiteVitreous = db.readMineralsForColorLusterAndStreak("Purple", "Vitreous", "White")
        val dataRedWhiteVitreous = db.readMineralsForColorLusterAndStreak("Red", "Vitreous", "White")
        val dataYellowYellowMetallic = db.readMineralsForColorLusterAndStreak("Yellow", "Metallic", "Yellow")
        val dataBlackBlackMetallic = db.readMineralsForColorLusterAndStreak("Black", "Metallic", "Black")
        val dataColorlessWhiteVitreous = db.readMineralsForColorLusterAndStreak("Colorless", "Vitreous", "White")
        val dataBlackRedMetallic = db.readMineralsForColorLusterAndStreak("Black", "Metallic", "Red")
        val dataSilverWhiteVitreous = db.readMineralsForColorLusterAndStreak("Silver", "Vitreous", "White")
        val dataGrayWhiteVitreous = db.readMineralsForColorLusterAndStreak("Gray", "Vitreous", "White")
        val dataSilverGrayMetallic = db.readMineralsForColorLusterAndStreak("Silver", "Metallic", "Gray")
        val dataGreenWhiteGlassy = db.readMineralsForColorLusterAndStreak("Green", "Glassy", "White")
        val dataYellowBlackMetallic = db.readMineralsForColorLusterAndStreak("Yellow", "Metallic", "Black")
        val dataColorlessWhiteGlassy = db.readMineralsForColorLusterAndStreak("Colorless", "Glassy", "White")
        val dataBlackRedAdamantine = db.readMineralsForColorLusterAndStreak("Black", "Adamantine", "Red")
        val dataYellowYellowResinous = db.readMineralsForColorLusterAndStreak("Yellow", "Resinous", "Yellow")
        val dataWhiteWhitePearly = db.readMineralsForColorLusterAndStreak("White", "Pearly", "White")
        val dataGreenWhiteAdamantine = db.readMineralsForColorLusterAndStreak("Green", "Adamantine", "White")
        val dataGrayBlackSubmetallic = db.readMineralsForColorLusterAndStreak("Gray", "Sub-metallic", "Black")
        val dataBrownWhiteAdamantine = db.readMineralsForColorLusterAndStreak("Brown", "Adamantine", "White")

        //color streak hardness
        val dataGreenWhite6 = db.readMineralsForColorStreakAndHardness("Green", "White", "6.0")
        val dataBlueWhite5 = db.readMineralsForColorStreakAndHardness("Blue", "White", "5.0")
        val dataBrownWhite2 = db.readMineralsForColorStreakAndHardness("Brown", "White", "2.0")
        val dataBlackWhite3 = db.readMineralsForColorStreakAndHardness("Black", "White", "3.0")
        val dataBrownWhite3 = db.readMineralsForColorStreakAndHardness("Brown", "White", "3.0")
        val dataGreenGreen2 = db.readMineralsForColorStreakAndHardness("Green", "Green", "2.0")
        val dataBrownWhite7 = db.readMineralsForColorStreakAndHardness("Brown", "White", "7.0")
        val dataColorlessWhite9 = db.readMineralsForColorStreakAndHardness("Colorless", "White", "9.0")
        val dataWhiteColorless10 = db.readMineralsForColorStreakAndHardness("White", "Colorless", "10.0")
        val dataWhiteWhite4 = db.readMineralsForColorStreakAndHardness("White", "White", "4.0")
        val dataGreenWhite7 = db.readMineralsForColorStreakAndHardness("Green", "White", "7.0")
        val dataPurpleWhite4 = db.readMineralsForColorStreakAndHardness("Purple", "White", "4.0")
        val dataRedWhite7 = db.readMineralsForColorStreakAndHardness("Red", "White", "7.0")
        val dataYellowYellow25 = db.readMineralsForColorStreakAndHardness("Yellow", "Yellow", "2.5")
        val dataBlackBlack3 = db.readMineralsForColorStreakAndHardness("Black", "Black", "3.0")
        val dataWhiteWhite2 = db.readMineralsForColorStreakAndHardness("White", "White", "2.0")
        val dataColorlessWhite2 = db.readMineralsForColorStreakAndHardness("Colorless", "White", "2.0")
        val dataBlackRed5 = db.readMineralsForColorStreakAndHardness("Black", "Red", "5.0")
        val dataBlueWhite7 = db.readMineralsForColorStreakAndHardness("Blue", "White", "7.0")
        val dataBlackBlack6 = db.readMineralsForColorStreakAndHardness("Black", "Black", "6.0")
        val dataBrownWhite5 = db.readMineralsForColorStreakAndHardness("Brown", "White", "5.0")
        val dataSilverWhite2 = db.readMineralsForColorStreakAndHardness("Silver", "White", "2.0")
        val dataGrayWhite6 = db.readMineralsForColorStreakAndHardness("Gray", "White", "6.0")
        val dataSilverGray4 = db.readMineralsForColorStreakAndHardness("Silver", "Gray", "4.0")
        val dataGrayWhite5 = db.readMineralsForColorStreakAndHardness("Gray", "White", "5.0")
        val dataGrayWhite7 = db.readMineralsForColorStreakAndHardness("Gray", "White", "7.0")
        val dataYellowBlack6 = db.readMineralsForColorStreakAndHardness("Yellow", "Black", "6.0")
        val dataColorlessWhite7 = db.readMineralsForColorStreakAndHardness("Colorless", "White", "7.0")
        val dataBlackRed6 = db.readMineralsForColorStreakAndHardness("Black", "Red", "6.0")
        val dataYellowYellow2 = db.readMineralsForColorStreakAndHardness("Yellow", "Yellow", "2.0")
        val dataWhiteWhite1 = db.readMineralsForColorStreakAndHardness("White", "White", "1.0")
        val dataGreenWhite5 = db.readMineralsForColorStreakAndHardness("Green", "White", "5.0")
        val dataBlackWhite7 = db.readMineralsForColorStreakAndHardness("Black", "White", "7.0")
        val dataWhiteWhite5 = db.readMineralsForColorStreakAndHardness("White", "White", "5.0")
        val dataGrayBlack6 = db.readMineralsForColorStreakAndHardness("Gray", "Black", "6.0")
        val dataSilverWhite15 = db.readMineralsForColorStreakAndHardness("Silver", "White", "1.5")
        val dataBrownWhite75 = db.readMineralsForColorStreakAndHardness("Brown", "White", "7.5")


        //color, streak, cleavage
        val dataGreenWhiteBasal = db.readMineralsForColorStreakAndCleavage("Green", "White", "Basal")
        val dataBlueWhiteIndistinct = db.readMineralsForColorStreakAndCleavage("Blue", "White", "Indistinct")
        val dataBrownWhiteNone = db.readMineralsForColorStreakAndCleavage("Brown", "White", "None")
        val dataBlackWhiteBasal = db.readMineralsForColorStreakAndCleavage("Black", "White", "Basal")

        fun onClickTwo() {
            //color, streak, hardness
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataGrayWhite5.size){
                    result1.append(dataGrayWhite5[i].name + "\n" + "Color:             " + dataGrayWhite5[i].color + "\n" + "Streak:            "
                            + dataGrayWhite5[i].streak + "\n"
                            + "Luster:            " + dataGrayWhite5[i].luster + "\n" + "Hardness:            " + dataGrayWhite5[i].hardness + "\n" +
                            "Cleavage:       " + dataGrayWhite5[i].cleavage + "\n" + "Fracture:            " + dataGrayWhite5[i].fracture + "\n"
                            + "Density:                " + dataGrayWhite5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "4.0" && msg6
                == "" && msg7 == "Gray") {
                for (i in 0 until dataSilverGray4.size){
                    result1.append(dataSilverGray4[i].name + "\n" + "Color:             " + dataSilverGray4[i].color + "\n" + "Streak:            "
                            + dataSilverGray4[i].streak + "\n"
                            + "Luster:            " + dataSilverGray4[i].luster + "\n" + "Hardness:            " + dataSilverGray4[i].hardness + "\n" +
                            "Cleavage:       " + dataSilverGray4[i].cleavage + "\n" + "Fracture:            " + dataSilverGray4[i].fracture + "\n"
                            + "Density:                " + dataSilverGray4[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "6.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataGrayWhite6.size){
                    result1.append(dataGrayWhite6[i].name + "\n" + "Color:             " + dataGrayWhite6[i].color + "\n" + "Streak:            "
                            + dataGrayWhite6[i].streak + "\n"
                            + "Luster:            " + dataGrayWhite6[i].luster + "\n" + "Hardness:            " + dataGrayWhite6[i].hardness + "\n" +
                            "Cleavage:       " + dataGrayWhite6[i].cleavage + "\n" + "Fracture:            " + dataGrayWhite6[i].fracture + "\n"
                            + "Density:                " + dataGrayWhite6[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataSilverWhite2.size){
                    result1.append(dataSilverWhite2[i].name + "\n" + "Color:             " + dataSilverWhite2[i].color + "\n" + "Streak:            "
                            + dataSilverWhite2[i].streak + "\n"
                            + "Luster:            " + dataSilverWhite2[i].luster + "\n" + "Hardness:            " + dataSilverWhite2[i].hardness + "\n" +
                            "Cleavage:       " + dataSilverWhite2[i].cleavage + "\n" + "Fracture:            " + dataSilverWhite2[i].fracture + "\n"
                            + "Density:                " + dataSilverWhite2[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBrownWhite5.size){
                    result1.append(dataBrownWhite5[i].name + "\n" + "Color:             " + dataBrownWhite5[i].color + "\n" + "Streak:            "
                            + dataBrownWhite5[i].streak + "\n"
                            + "Luster:            " + dataBrownWhite5[i].luster + "\n" + "Hardness:            " + dataBrownWhite5[i].hardness + "\n" +
                            "Cleavage:       " + dataBrownWhite5[i].cleavage + "\n" + "Fracture:            " + dataBrownWhite5[i].fracture + "\n"
                            + "Density:                " + dataBrownWhite5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "6.0" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataBlackBlack6.size){
                    result1.append(dataBlackBlack6[i].name + "\n" + "Color:             " + dataBlackBlack6[i].color + "\n" + "Streak:            "
                            + dataBlackBlack6[i].streak + "\n"
                            + "Luster:            " + dataBlackBlack6[i].luster + "\n" + "Hardness:            " + dataBlackBlack6[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackBlack6[i].cleavage + "\n" + "Fracture:            " + dataBlackBlack6[i].fracture + "\n"
                            + "Density:                " + dataBlackBlack6[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Blue" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBlueWhite7.size){
                    result1.append(dataBlueWhite7[i].name + "\n" + "Color:             " + dataBlueWhite7[i].color + "\n" + "Streak:            "
                            + dataBlueWhite7[i].streak + "\n"
                            + "Luster:            " + dataBlueWhite7[i].luster + "\n" + "Hardness:            " + dataBlueWhite7[i].hardness + "\n" +
                            "Cleavage:       " + dataBlueWhite7[i].cleavage + "\n" + "Fracture:            " + dataBlueWhite7[i].fracture + "\n"
                            + "Density:                " + dataBlueWhite7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "Red") {
                for (i in 0 until dataBlackRed5.size){
                    result1.append(dataBlackRed5[i].name + "\n" + "Color:             " + dataBlackRed5[i].color + "\n" + "Streak:            "
                            + dataBlackRed5[i].streak + "\n"
                            + "Luster:            " + dataBlackRed5[i].luster + "\n" + "Hardness:            " + dataBlackRed5[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackRed5[i].cleavage + "\n" + "Fracture:            " + dataBlackRed5[i].fracture + "\n"
                            + "Density:                " + dataBlackRed5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataColorlessWhite2.size){
                    result1.append(dataColorlessWhite2[i].name + "\n" + "Color:             " + dataColorlessWhite2[i].color + "\n" + "Streak:            "
                            + dataColorlessWhite2[i].streak + "\n"
                            + "Luster:            " + dataColorlessWhite2[i].luster + "\n" + "Hardness:            " + dataColorlessWhite2[i].hardness + "\n" +
                            "Cleavage:       " + dataColorlessWhite2[i].cleavage + "\n" + "Fracture:            " + dataColorlessWhite2[i].fracture + "\n"
                            + "Density:                " + dataColorlessWhite2[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteWhite2.size){
                    result1.append(dataWhiteWhite2[i].name + "\n" + "Color:             " + dataWhiteWhite2[i].color + "\n" + "Streak:            "
                            + dataWhiteWhite2[i].streak + "\n"
                            + "Luster:            " + dataWhiteWhite2[i].luster + "\n" + "Hardness:            " + dataWhiteWhite2[i].hardness + "\n" +
                            "Cleavage:       " + dataWhiteWhite2[i].cleavage + "\n" + "Fracture:            " + dataWhiteWhite2[i].fracture + "\n"
                            + "Density:                " + dataWhiteWhite2[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "3.0" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataBlackBlack3.size){
                    result1.append(dataBlackBlack3[i].name + "\n" + "Color:             " + dataBlackBlack3[i].color + "\n" + "Streak:            "
                            + dataBlackBlack3[i].streak + "\n"
                            + "Luster:            " + dataBlackBlack3[i].luster + "\n" + "Hardness:            " + dataBlackBlack3[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackBlack3[i].cleavage + "\n" + "Fracture:            " + dataBlackBlack3[i].fracture + "\n"
                            + "Density:                " + dataBlackBlack3[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "6.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataGreenWhite6.size){
                    result1.append(dataGreenWhite6[i].name + "\n" + "Color:             " + dataGreenWhite6[i].color + "\n" + "Streak:            "
                            + dataGreenWhite6[i].streak + "\n"
                            + "Luster:            " + dataGreenWhite6[i].luster + "\n" + "Hardness:            " + dataGreenWhite6[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenWhite6[i].cleavage + "\n" + "Fracture:            " + dataGreenWhite6[i].fracture + "\n"
                            + "Density:                " + dataGreenWhite6[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Blue" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBlueWhite5.size){
                    result1.append(dataBlueWhite5[i].name + "\n" + "Color:             " + dataBlueWhite5[i].color + "\n" + "Streak:            "
                            + dataBlueWhite5[i].streak + "\n"
                            + "Luster:            " + dataBlueWhite5[i].luster + "\n" + "Hardness:            " + dataBlueWhite5[i].hardness + "\n" +
                            "Cleavage:       " + dataBlueWhite5[i].cleavage + "\n" + "Fracture:            " + dataBlueWhite5[i].fracture + "\n"
                            + "Density:                " + dataBlueWhite5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBrownWhite2.size){
                    result1.append(dataBrownWhite2[i].name + "\n" + "Color:             " + dataBrownWhite2[i].color + "\n" + "Streak:            "
                            + dataBrownWhite2[i].streak + "\n"
                            + "Luster:            " + dataBrownWhite2[i].luster + "\n" + "Hardness:            " + dataBrownWhite2[i].hardness + "\n" +
                            "Cleavage:       " + dataBrownWhite2[i].cleavage + "\n" + "Fracture:            " + dataBrownWhite2[i].fracture + "\n"
                            + "Density:                " + dataBrownWhite2[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "3.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBlackWhite3.size){
                    result1.append(dataBlackWhite3[i].name + "\n" + "Color:             " + dataBlackWhite3[i].color + "\n" + "Streak:            "
                            + dataBlackWhite3[i].streak + "\n"
                            + "Luster:            " + dataBlackWhite3[i].luster + "\n" + "Hardness:            " + dataBlackWhite3[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackWhite3[i].cleavage + "\n" + "Fracture:            " + dataBlackWhite3[i].fracture + "\n"
                            + "Density:                " + dataBlackWhite3[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "3.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBrownWhite3.size){
                    result1.append(dataBrownWhite3[i].name + "\n" + "Color:             " + dataBrownWhite3[i].color + "\n" + "Streak:            "
                            + dataBrownWhite3[i].streak + "\n"
                            + "Luster:            " + dataBrownWhite3[i].luster + "\n" + "Hardness:            " + dataBrownWhite3[i].hardness + "\n" +
                            "Cleavage:       " + dataBrownWhite3[i].cleavage + "\n" + "Fracture:            " + dataBrownWhite3[i].fracture + "\n"
                            + "Density:                " + dataBrownWhite3[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "Green") {
                for (i in 0 until dataGreenGreen2.size){
                    result1.append(dataGreenGreen2[i].name + "\n" + "Color:             " + dataGreenGreen2[i].color + "\n" + "Streak:            "
                            + dataGreenGreen2[i].streak + "\n"
                            + "Luster:            " + dataGreenGreen2[i].luster + "\n" + "Hardness:            " + dataGreenGreen2[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenGreen2[i].cleavage + "\n" + "Fracture:            " + dataGreenGreen2[i].fracture + "\n"
                            + "Density:                " + dataGreenGreen2[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBrownWhite7.size){
                    result1.append(dataBrownWhite7[i].name + "\n" + "Color:             " + dataBrownWhite7[i].color + "\n" + "Streak:            "
                            + dataBrownWhite7[i].streak + "\n"
                            + "Luster:            " + dataBrownWhite7[i].luster + "\n" + "Hardness:            " + dataBrownWhite7[i].hardness + "\n" +
                            "Cleavage:       " + dataBrownWhite7[i].cleavage + "\n" + "Fracture:            " + dataBrownWhite7[i].fracture + "\n"
                            + "Density:                " + dataBrownWhite7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "9.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataColorlessWhite9.size){
                    result1.append(dataColorlessWhite9[i].name + "\n" + "Color:             " + dataColorlessWhite9[i].color + "\n" + "Streak:            "
                            + dataColorlessWhite9[i].streak + "\n"
                            + "Luster:            " + dataColorlessWhite9[i].luster + "\n" + "Hardness:            " + dataColorlessWhite9[i].hardness + "\n" +
                            "Cleavage:       " + dataColorlessWhite9[i].cleavage + "\n" + "Fracture:            " + dataColorlessWhite9[i].fracture + "\n"
                            + "Density:                " + dataColorlessWhite9[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "10.0" && msg6
                == "" && msg7 == "Colorless") {
                for (i in 0 until dataWhiteColorless10.size){
                    result1.append(dataWhiteColorless10[i].name + "\n" + "Color:             " + dataWhiteColorless10[i].color + "\n" + "Streak:            "
                            + dataWhiteColorless10[i].streak + "\n"
                            + "Luster:            " + dataWhiteColorless10[i].luster + "\n" + "Hardness:            " + dataWhiteColorless10[i].hardness + "\n" +
                            "Cleavage:       " + dataWhiteColorless10[i].cleavage + "\n" + "Fracture:            " + dataWhiteColorless10[i].fracture + "\n"
                            + "Density:                " + dataWhiteColorless10[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "4.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteWhite4.size){
                    result1.append(dataWhiteWhite4[i].name + "\n" + "Color:             " + dataWhiteWhite4[i].color + "\n" + "Streak:            "
                            + dataWhiteWhite4[i].streak + "\n"
                            + "Luster:            " + dataWhiteWhite4[i].luster + "\n" + "Hardness:            " + dataWhiteWhite4[i].hardness + "\n" +
                            "Cleavage:       " + dataWhiteWhite4[i].cleavage + "\n" + "Fracture:            " + dataWhiteWhite4[i].fracture + "\n"
                            + "Density:                " + dataWhiteWhite4[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataGreenWhite7.size){
                    result1.append(dataGreenWhite7[i].name + "\n" + "Color:             " + dataGreenWhite7[i].color + "\n" + "Streak:            "
                            + dataGreenWhite7[i].streak + "\n"
                            + "Luster:            " + dataGreenWhite7[i].luster + "\n" + "Hardness:            " + dataGreenWhite7[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenWhite7[i].cleavage + "\n" + "Fracture:            " + dataGreenWhite7[i].fracture + "\n"
                            + "Density:                " + dataGreenWhite7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Purple" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "4.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataPurpleWhite4.size){
                    result1.append(dataPurpleWhite4[i].name + "\n" + "Color:             " + dataPurpleWhite4[i].color + "\n" + "Streak:            "
                            + dataPurpleWhite4[i].streak + "\n"
                            + "Luster:            " + dataPurpleWhite4[i].luster + "\n" + "Hardness:            " + dataPurpleWhite4[i].hardness + "\n" +
                            "Cleavage:       " + dataPurpleWhite4[i].cleavage + "\n" + "Fracture:            " + dataPurpleWhite4[i].fracture + "\n"
                            + "Density:                " + dataPurpleWhite4[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Red" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataRedWhite7.size){
                    result1.append(dataRedWhite7[i].name + "\n" + "Color:             " + dataRedWhite7[i].color + "\n" + "Streak:            "
                            + dataRedWhite7[i].streak + "\n"
                            + "Luster:            " + dataRedWhite7[i].luster + "\n" + "Hardness:            " + dataRedWhite7[i].hardness + "\n" +
                            "Cleavage:       " + dataRedWhite7[i].cleavage + "\n" + "Fracture:            " + dataRedWhite7[i].fracture + "\n"
                            + "Density:                " + dataRedWhite7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "2.5" && msg6
                == "" && msg7 == "Yellow") {
                for (i in 0 until dataYellowYellow25.size){
                    result1.append(dataYellowYellow25[i].name + "\n" + "Color:             " + dataYellowYellow25[i].color + "\n" + "Streak:            "
                            + dataYellowYellow25[i].streak + "\n"
                            + "Luster:            " + dataYellowYellow25[i].luster + "\n" + "Hardness:            " + dataYellowYellow25[i].hardness + "\n" +
                            "Cleavage:       " + dataYellowYellow25[i].cleavage + "\n" + "Fracture:            " + dataYellowYellow25[i].fracture + "\n"
                            + "Density:                " + dataYellowYellow25[i].density + "\n" + "\n")
                }
            }
            //color, streak, luster
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Sub-metallic" && msg7 == "Black") {
                for (i in 0 until dataGrayBlackSubmetallic.size){
                    result1.append(dataGrayBlackSubmetallic[i].name + "\n" + "Color:             " + dataGrayBlackSubmetallic[i].color + "\n" + "Streak:            "
                            + dataGrayBlackSubmetallic[i].streak + "\n"
                            + "Luster:            " + dataGrayBlackSubmetallic[i].luster + "\n" + "Hardness:            " + dataGrayBlackSubmetallic[i].hardness + "\n" +
                            "Cleavage:       " + dataGrayBlackSubmetallic[i].cleavage + "\n" + "Fracture:            " + dataGrayBlackSubmetallic[i].fracture + "\n"
                            + "Density:                " + dataGrayBlackSubmetallic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Adamantine" && msg7 == "White") {
                for (i in 0 until dataGreenWhiteAdamantine.size){
                    result1.append(dataGreenWhiteAdamantine[i].name + "\n" + "Color:             " + dataGreenWhiteAdamantine[i].color + "\n" + "Streak:            "
                            + dataGreenWhiteAdamantine[i].streak + "\n"
                            + "Luster:            " + dataGreenWhiteAdamantine[i].luster + "\n" + "Hardness:            " + dataGreenWhiteAdamantine[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenWhiteAdamantine[i].cleavage + "\n" + "Fracture:            " + dataGreenWhiteAdamantine[i].fracture + "\n"
                            + "Density:                " + dataGreenWhiteAdamantine[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Pearly" && msg7 == "White") {
                for (i in 0 until dataWhiteWhitePearly.size){
                    result1.append(dataWhiteWhitePearly[i].name + "\n" + "Color:             " + dataWhiteWhitePearly[i].color + "\n" + "Streak:            "
                            + dataWhiteWhitePearly[i].streak + "\n"
                            + "Luster:            " + dataWhiteWhitePearly[i].luster + "\n" + "Hardness:            " + dataWhiteWhitePearly[i].hardness + "\n" +
                            "Cleavage:       " + dataWhiteWhitePearly[i].cleavage + "\n" + "Fracture:            " + dataWhiteWhitePearly[i].fracture + "\n"
                            + "Density:                " + dataWhiteWhitePearly[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Adamantine" && msg7 == "White") {
                for (i in 0 until dataBrownWhiteAdamantine.size){
                    result1.append(dataBrownWhiteAdamantine[i].name + "\n" + "Color:             " + dataBrownWhiteAdamantine[i].color + "\n" + "Streak:            "
                            + dataBrownWhiteAdamantine[i].streak + "\n"
                            + "Luster:            " + dataBrownWhiteAdamantine[i].luster + "\n" + "Hardness:            " + dataBrownWhiteAdamantine[i].hardness + "\n" +
                            "Cleavage:       " + dataBrownWhiteAdamantine[i].cleavage + "\n" + "Fracture:            " + dataBrownWhiteAdamantine[i].fracture + "\n"
                            + "Density:                " + dataBrownWhiteAdamantine[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Resinous" && msg7 == "Yellow") {
                for (i in 0 until dataYellowYellowResinous.size){
                    result1.append(dataYellowYellowResinous[i].name + "\n" + "Color:             " + dataYellowYellowResinous[i].color + "\n" + "Streak:            "
                            + dataYellowYellowResinous[i].streak + "\n"
                            + "Luster:            " + dataYellowYellowResinous[i].luster + "\n" + "Hardness:            " + dataYellowYellowResinous[i].hardness + "\n" +
                            "Cleavage:       " + dataYellowYellowResinous[i].cleavage + "\n" + "Fracture:            " + dataYellowYellowResinous[i].fracture + "\n"
                            + "Density:                " + dataYellowYellowResinous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Adamantine" && msg7 == "Red") {
                for (i in 0 until dataBlackRedAdamantine.size){
                    result1.append(dataBlackRedAdamantine[i].name + "\n" + "Color:             " + dataBlackRedAdamantine[i].color + "\n" + "Streak:            "
                            + dataBlackRedAdamantine[i].streak + "\n"
                            + "Luster:            " + dataBlackRedAdamantine[i].luster + "\n" + "Hardness:            " + dataBlackRedAdamantine[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackRedAdamantine[i].cleavage + "\n" + "Fracture:            " + dataBlackRedAdamantine[i].fracture + "\n"
                            + "Density:                " + dataBlackRedAdamantine[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Glassy" && msg7 == "White") {
                for (i in 0 until dataColorlessWhiteGlassy.size){
                    result1.append(dataColorlessWhiteGlassy[i].name + "\n" + "Color:             " + dataColorlessWhiteGlassy[i].color + "\n" + "Streak:            "
                            + dataColorlessWhiteGlassy[i].streak + "\n"
                            + "Luster:            " + dataColorlessWhiteGlassy[i].luster + "\n" + "Hardness:            " + dataColorlessWhiteGlassy[i].hardness + "\n" +
                            "Cleavage:       " + dataColorlessWhiteGlassy[i].cleavage + "\n" + "Fracture:            " + dataColorlessWhiteGlassy[i].fracture + "\n"
                            + "Density:                " + dataColorlessWhiteGlassy[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Red" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataRedWhiteVitreous.size){
                    result1.append(dataRedWhiteVitreous[i].name + "\n" + "Color:             " + dataRedWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataRedWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataRedWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataRedWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataRedWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataRedWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataRedWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Purple" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataPurpleWhiteVitreous.size){
                    result1.append(dataPurpleWhiteVitreous[i].name + "\n" + "Color:             " + dataPurpleWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataPurpleWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataPurpleWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataPurpleWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataPurpleWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataPurpleWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataPurpleWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Metallic" && msg7 == "Yellow") {
                for (i in 0 until dataYellowYellowMetallic.size){
                    result1.append(dataYellowYellowMetallic[i].name + "\n" + "Color:             " + dataYellowYellowMetallic[i].color + "\n" + "Streak:            "
                            + dataYellowYellowMetallic[i].streak + "\n"
                            + "Luster:            " + dataYellowYellowMetallic[i].luster + "\n" + "Hardness:            " + dataYellowYellowMetallic[i].hardness + "\n" +
                            "Cleavage:       " + dataYellowYellowMetallic[i].cleavage + "\n" + "Fracture:            " + dataYellowYellowMetallic[i].fracture + "\n"
                            + "Density:                " + dataYellowYellowMetallic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Metallic" && msg7 == "Black") {
                for (i in 0 until dataBlackBlackMetallic.size){
                    result1.append(dataBlackBlackMetallic[i].name + "\n" + "Color:             " + dataBlackBlackMetallic[i].color + "\n" + "Streak:            "
                            + dataBlackBlackMetallic[i].streak + "\n"
                            + "Luster:            " + dataBlackBlackMetallic[i].luster + "\n" + "Hardness:            " + dataBlackBlackMetallic[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackBlackMetallic[i].cleavage + "\n" + "Fracture:            " + dataBlackBlackMetallic[i].fracture + "\n"
                            + "Density:                " + dataBlackBlackMetallic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataColorlessWhiteVitreous.size){
                    result1.append(dataColorlessWhiteVitreous[i].name + "\n" + "Color:             " + dataColorlessWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataColorlessWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataColorlessWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataColorlessWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataColorlessWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataColorlessWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataColorlessWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Metallic" && msg7 == "Red") {
                for (i in 0 until dataBlackRedMetallic.size){
                    result1.append(dataBlackRedMetallic[i].name + "\n" + "Color:             " + dataBlackRedMetallic[i].color + "\n" + "Streak:            "
                            + dataBlackRedMetallic[i].streak + "\n"
                            + "Luster:            " + dataBlackRedMetallic[i].luster + "\n" + "Hardness:            " + dataBlackRedMetallic[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackRedMetallic[i].cleavage + "\n" + "Fracture:            " + dataBlackRedMetallic[i].fracture + "\n"
                            + "Density:                " + dataBlackRedMetallic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataSilverWhiteVitreous.size){
                    result1.append(dataSilverWhiteVitreous[i].name + "\n" + "Color:             " + dataSilverWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataSilverWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataSilverWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataSilverWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataSilverWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataSilverWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataSilverWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataGrayWhiteVitreous.size){
                    result1.append(dataGrayWhiteVitreous[i].name + "\n" + "Color:             " + dataGrayWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataGrayWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataGrayWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataGrayWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataGrayWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataGrayWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataGrayWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Metallic" && msg7 == "Gray") {
                for (i in 0 until dataSilverGrayMetallic.size){
                    result1.append(dataSilverGrayMetallic[i].name + "\n" + "Color:             " + dataSilverGrayMetallic[i].color + "\n" + "Streak:            "
                            + dataSilverGrayMetallic[i].streak + "\n"
                            + "Luster:            " + dataSilverGrayMetallic[i].luster + "\n" + "Hardness:            " + dataSilverGrayMetallic[i].hardness + "\n" +
                            "Cleavage:       " + dataSilverGrayMetallic[i].cleavage + "\n" + "Fracture:            " + dataSilverGrayMetallic[i].fracture + "\n"
                            + "Density:                " + dataSilverGrayMetallic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Glassy" && msg7 == "White") {
                for (i in 0 until dataGreenWhiteGlassy.size){
                    result1.append(dataGreenWhiteGlassy[i].name + "\n" + "Color:             " + dataGreenWhiteGlassy[i].color + "\n" + "Streak:            "
                            + dataGreenWhiteGlassy[i].streak + "\n"
                            + "Luster:            " + dataGreenWhiteGlassy[i].luster + "\n" + "Hardness:            " + dataGreenWhiteGlassy[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenWhiteGlassy[i].cleavage + "\n" + "Fracture:            " + dataGreenWhiteGlassy[i].fracture + "\n"
                            + "Density:                " + dataGreenWhiteGlassy[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Metallic" && msg7 == "Black") {
                for (i in 0 until dataYellowBlackMetallic.size){
                    result1.append(dataYellowBlackMetallic[i].name + "\n" + "Color:             " + dataYellowBlackMetallic[i].color + "\n" + "Streak:            "
                            + dataYellowBlackMetallic[i].streak + "\n"
                            + "Luster:            " + dataYellowBlackMetallic[i].luster + "\n" + "Hardness:            " + dataYellowBlackMetallic[i].hardness + "\n" +
                            "Cleavage:       " + dataYellowBlackMetallic[i].cleavage + "\n" + "Fracture:            " + dataYellowBlackMetallic[i].fracture + "\n"
                            + "Density:                " + dataYellowBlackMetallic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataWhiteWhiteVitreous.size){
                    result1.append(dataWhiteWhiteVitreous[i].name + "\n" + "Color:             " + dataWhiteWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataWhiteWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataWhiteWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataWhiteWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataWhiteWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataWhiteWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataWhiteWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Adamantine" && msg7 == "Colorless") {
                for (i in 0 until dataWhiteColorlessAdamantine.size){
                    result1.append(dataWhiteColorlessAdamantine[i].name + "\n" + "Color:             " + dataWhiteColorlessAdamantine[i].color + "\n" + "Streak:            "
                            + dataWhiteColorlessAdamantine[i].streak + "\n"
                            + "Luster:            " + dataWhiteColorlessAdamantine[i].luster + "\n" + "Hardness:            " + dataWhiteColorlessAdamantine[i].hardness + "\n" +
                            "Cleavage:       " + dataWhiteColorlessAdamantine[i].cleavage + "\n" + "Fracture:            " + dataWhiteColorlessAdamantine[i].fracture + "\n"
                            + "Density:                " + dataWhiteColorlessAdamantine[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Adamantine" && msg7 == "White") {
                for (i in 0 until dataColorlessWhiteAdamantine.size){
                    result1.append(dataColorlessWhiteAdamantine[i].name + "\n" + "Color:             " + dataColorlessWhiteAdamantine[i].color + "\n" + "Streak:            "
                            + dataColorlessWhiteAdamantine[i].streak + "\n"
                            + "Luster:            " + dataColorlessWhiteAdamantine[i].luster + "\n" + "Hardness:            " + dataColorlessWhiteAdamantine[i].hardness + "\n" +
                            "Cleavage:       " + dataColorlessWhiteAdamantine[i].cleavage + "\n" + "Fracture:            " + dataColorlessWhiteAdamantine[i].fracture + "\n"
                            + "Density:                " + dataColorlessWhiteAdamantine[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "Green") {
                for (i in 0 until dataGreenGreenVitreous.size){
                    result1.append(dataGreenGreenVitreous[i].name + "\n" + "Color:             " + dataGreenGreenVitreous[i].color + "\n" + "Streak:            "
                            + dataGreenGreenVitreous[i].streak + "\n"
                            + "Luster:            " + dataGreenGreenVitreous[i].luster + "\n" + "Hardness:            " + dataGreenGreenVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenGreenVitreous[i].cleavage + "\n" + "Fracture:            " + dataGreenGreenVitreous[i].fracture + "\n"
                            + "Density:                " + dataGreenGreenVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataBlackWhiteVitreous.size){
                    result1.append(dataBlackWhiteVitreous[i].name + "\n" + "Color:             " + dataBlackWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataBlackWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataBlackWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataBlackWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataBlackWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataBlackWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataBlackWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataBrownWhiteVitreous.size){
                    result1.append(dataBrownWhiteVitreous[i].name + "\n" + "Color:             " + dataBrownWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataBrownWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataBrownWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataBrownWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataBrownWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataBrownWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataBrownWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Blue" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataBlueWhiteVitreous.size){
                    result1.append(dataBlueWhiteVitreous[i].name + "\n" + "Color:             " + dataBlueWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataBlueWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataBlueWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataBlueWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataBlueWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataBlueWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataBlueWhiteVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Vitreous" && msg7 == "White") {
                for (i in 0 until dataGreenWhiteVitreous.size){
                    result1.append(dataGreenWhiteVitreous[i].name + "\n" + "Color:             " + dataGreenWhiteVitreous[i].color + "\n" + "Streak:            "
                            + dataGreenWhiteVitreous[i].streak + "\n"
                            + "Luster:            " + dataGreenWhiteVitreous[i].luster + "\n" + "Hardness:            " + dataGreenWhiteVitreous[i].hardness + "\n" +
                            "Cleavage:       " + dataGreenWhiteVitreous[i].cleavage + "\n" + "Fracture:            " + dataGreenWhiteVitreous[i].fracture + "\n"
                            + "Density:                " + dataGreenWhiteVitreous[i].density + "\n" + "\n")
                }
            }
        }
        onClickTwo()
        fun onClick() {
            //cleavage and luster
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "Glassy" && msg7 == "") {
                for (i in 0 until dataIndistinctGlassy.size){
                    result1.append(dataIndistinctGlassy[i].name + "\n" + "Color:             " + dataIndistinctGlassy[i].color + "\n" + "Streak:            "
                            + dataIndistinctGlassy[i].streak + "\n"
                            + "Luster:            " + dataIndistinctGlassy[i].luster + "\n" + "Hardness:            " + dataIndistinctGlassy[i].hardness + "\n" +
                            "Cleavage:       " + dataIndistinctGlassy[i].cleavage + "\n" + "Fracture:            " + dataIndistinctGlassy[i].fracture + "\n"
                            + "Density:                " + dataIndistinctGlassy[i].density + "\n" + "\n")
                }
            }
            //luster and hardness
            if (msg1 == "" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "Glassy" && msg7 == "") {
                for (i in 0 until dataGlassy7.size){
                    result1.append(dataGlassy7[i].name + "\n" + "Color:             " + dataGlassy7[i].color + "\n" + "Streak:            "
                            + dataGlassy7[i].streak + "\n"
                            + "Luster:            " + dataGlassy7[i].luster + "\n" + "Hardness:            " + dataGlassy7[i].hardness + "\n" +
                            "Cleavage:       " + dataGlassy7[i].cleavage + "\n" + "Fracture:            " + dataGlassy7[i].fracture + "\n"
                            + "Density:                " + dataGlassy7[i].density + "\n" + "\n")
                }
            }
            //cleavage and hardness
            if (msg1 == "" && msg2 == "Distinct" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataDistinct7.size){
                    result1.append(dataDistinct7[i].name + "\n" + "Color:             " + dataDistinct7[i].color + "\n" + "Streak:            "
                            + dataDistinct7[i].streak + "\n"
                            + "Luster:            " + dataDistinct7[i].luster + "\n" + "Hardness:            " + dataDistinct7[i].hardness + "\n" +
                            "Cleavage:       " + dataDistinct7[i].cleavage + "\n" + "Fracture:            " + dataDistinct7[i].fracture + "\n"
                            + "Density:                " + dataDistinct7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Distinct" && msg3 == "" && msg4 == "" && msg5 == "6.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataDistinct6.size){
                    result1.append(dataDistinct6[i].name + "\n" + "Color:             " + dataDistinct6[i].color + "\n" + "Streak:            " + dataDistinct6[i].streak + "\n"
                            + "Luster:            " + dataDistinct6[i].luster + "\n" + "Hardness:            " + dataDistinct6[i].hardness + "\n" +
                            "Cleavage:       " + dataDistinct6[i].cleavage + "\n" + "Fracture:            " + dataDistinct6[i].fracture + "Density:                " + dataDistinct6[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Distinct" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataDistinct5.size){
                    result1.append(dataDistinct5[i].name + "\n" + "Color:             " + dataDistinct5[i].color + "\n" + "Streak:            " + dataDistinct5[i].streak + "\n"
                            + "Luster:            " + dataDistinct5[i].luster + "\n" + "Hardness:            " + dataDistinct5[i].hardness + "\n" +
                            "Cleavage:       " + dataDistinct5[i].cleavage + "\n" + "Fracture:            " + dataDistinct5[i].fracture + "Density:                " + dataDistinct5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Distinct" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataDistinct2.size){
                    result1.append(dataDistinct2[i].name + "\n" + "Color:             " + dataDistinct2[i].color + "\n" + "Streak:            " + dataDistinct2[i].streak + "\n"
                            + "Luster:            " + dataDistinct2[i].luster + "\n" + "Hardness:            " + dataDistinct2[i].hardness + "\n" +
                            "Cleavage:       " + dataDistinct2[i].cleavage + "\n" + "Fracture:            " + dataDistinct2[i].fracture + "Density:                " + dataDistinct2[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataIndistinct7.size){
                    result1.append(dataIndistinct7[i].name + "\n" + "Color:             " + dataIndistinct7[i].color + "\n" + "Streak:            " + dataIndistinct7[i].streak + "\n"
                            + "Luster:            " + dataIndistinct7[i].luster + "\n" + "Hardness:            " + dataIndistinct7[i].hardness + "\n" +
                            "Cleavage:       " + dataIndistinct7[i].cleavage + "\n" + "Fracture:            " + dataIndistinct7[i].fracture + "Density:                " + dataIndistinct7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "6.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataIndistinct6.size){
                    result1.append(dataIndistinct6[i].name + "\n" + "Color:            " + dataIndistinct6[i].color + "\n" + "Streak:            " + dataIndistinct6[i].streak + "\n"
                            + "Luster:            " + dataIndistinct6[i].luster + "\n" + "Hardness:            " + dataIndistinct6[i].hardness + "\n" +
                            "Cleavage:        " + dataIndistinct6[i].cleavage + "\n" + "Density:                " + dataIndistinct6[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataIndistinct5.size){
                    result1.append(dataIndistinct5[i].name + "\n" + "Color:            " + dataIndistinct5[i].color + "\n" + "Streak:            " + dataIndistinct5[i].streak + "\n"
                            + "Luster:            " + dataIndistinct5[i].luster + "\n" + "Hardness:            " + dataIndistinct5[i].hardness + "\n" +
                            "Cleavage:        " + dataIndistinct5[i].cleavage + "\n" + "Density:                " + dataIndistinct5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "9.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataNone9.size){
                    result1.append(dataNone9[i].name + "\n" + "Color:            " + dataNone9[i].color + "\n" + "Streak:            " + dataNone9[i].streak + "\n"
                            + "Luster:            " + dataNone9[i].luster + "\n" + "Hardness:            " + dataNone9[i].hardness + "\n" +
                            "Cleavage:        " + dataNone9[i].cleavage + "\n" + "Density:                " + dataNone9[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Rhombohedral" && msg3 == "" && msg4 == "" && msg5 == "10.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataRhombohedral10.size){
                    result1.append(dataRhombohedral10[i].name + "\n" + "Color:            " + dataRhombohedral10[i].color + "\n" + "Streak:            " + dataRhombohedral10[i].streak + "\n"
                            + "Luster:            " + dataRhombohedral10[i].luster + "\n" + "Hardness:            " + dataRhombohedral10[i].hardness + "\n" +
                            "Cleavage:        " + dataRhombohedral10[i].cleavage + "\n" + "Density:                " + dataRhombohedral10[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Rhombohedral" && msg3 == "" && msg4 == "" && msg5 == "4.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataRhombohedral4.size){
                    result1.append(dataRhombohedral4[i].name + "\n" + "Color:            " + dataRhombohedral4[i].color + "\n" + "Streak:            " + dataRhombohedral4[i].streak + "\n"
                            + "Luster:            " + dataRhombohedral4[i].luster + "\n" + "Hardness:            " + dataRhombohedral4[i].hardness + "\n" +
                            "Cleavage:        " + dataRhombohedral4[i].cleavage + "\n" + "Density:                " + dataRhombohedral4[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Rhombohedral" && msg3 == "" && msg4 == "" && msg5 == "3.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataRhombohedral3.size){
                    result1.append(dataRhombohedral3[i].name + "\n" + "Color:            " + dataRhombohedral3[i].color + "\n" + "Streak:            " + dataRhombohedral3[i].streak + "\n"
                            + "Luster:            " + dataRhombohedral3[i].luster + "\n" + "Hardness:            " + dataRhombohedral3[i].hardness + "\n" +
                            "Cleavage:        " + dataRhombohedral3[i].cleavage + "\n" + "Density:                " + dataRhombohedral3[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataNone7.size){
                    result1.append(dataNone7[i].name + "\n" + "Color:            " + dataNone7[i].color + "\n" + "Streak:            " + dataNone7[i].streak + "\n"
                            + "Luster:            " + dataNone7[i].luster + "\n" + "Hardness:            " + dataNone7[i].hardness + "\n" +
                            "Cleavage:        " + dataNone7[i].cleavage + "\n" + "Density:                " + dataNone7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "2.5" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataNone25.size){
                    result1.append(dataNone25[i].name + "\n" + "Color:            " + dataNone25[i].color + "\n" + "Streak:            " + dataNone25[i].streak + "\n"
                            + "Luster:            " + dataNone25[i].luster + "\n" + "Hardness:            " + dataNone25[i].hardness + "\n" +
                            "Cleavage:        " + dataNone25[i].cleavage + "\n" + "Density:                " + dataNone25[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataNone5.size){
                    result1.append(dataNone5[i].name + "\n" + "Color:            " + dataNone5[i].color + "\n" + "Streak:            " + dataNone5[i].streak + "\n"
                            + "Luster:            " + dataNone5[i].luster + "\n" + "Hardness:            " + dataNone5[i].hardness + "\n" +
                            "Cleavage:        " + dataNone5[i].cleavage + "\n" + "Density:                " + dataNone5[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Octahedral" && msg3 == "" && msg4 == "" && msg5 == "4.0" && msg6
                == "" && msg7 == "") {
                    for (i in 0 until dataOctahedral4.size){
                    result1.append(dataOctahedral4[i].name + "\n" + "Color:            " + dataOctahedral4[i].color + "\n" + "Streak:            " + dataOctahedral4[i].streak + "\n"
                            + "Luster:            " + dataOctahedral4[i].luster + "\n" + "Hardness:            " + dataOctahedral4[i].hardness + "\n" +
                            "Cleavage:        " + dataOctahedral4[i].cleavage + "\n" + "Density:                " + dataOctahedral4[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Uneven" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataUneven7.size){
                    result1.append(dataUneven7[i].name + "\n" + "Color:            " + dataUneven7[i].color + "\n" + "Streak:            " + dataUneven7[i].streak + "\n"
                            + "Luster:            " + dataUneven7[i].luster + "\n" + "Hardness:            " + dataUneven7[i].hardness + "\n" +
                            "Cleavage:        " + dataUneven7[i].cleavage + "\n" + "Density:                " + dataUneven7[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "4.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataNone4.size){
                    result1.append(dataNone4[i].name + "\n" + "Color:            " + dataNone4[i].color + "\n" + "Streak:            " + dataNone4[i].streak + "\n"
                            + "Luster:            " + dataNone4[i].luster + "\n" + "Hardness:            " + dataNone4[i].hardness + "\n" +
                            "Cleavage:        " + dataNone4[i].cleavage + "\n" + "Density:                " + dataNone4[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "1.5" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasal15.size){
                    result1.append(dataBasal15[i].name + "\n" + "Color:            " + dataBasal15[i].color + "\n" + "Streak:            " + dataBasal15[i].streak + "\n"
                            + "Luster:            " + dataBasal15[i].luster + "\n" + "Hardness:            " + dataBasal15[i].hardness + "\n" +
                            "Cleavage:        " + dataBasal15[i].cleavage + "\n" + "Density:                " + dataBasal15[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "7.5" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataIndistinct75.size){
                    result1.append(dataIndistinct75[i].name + "\n" + "Color:            " + dataIndistinct75[i].color + "\n" + "Streak:            " + dataIndistinct75[i].streak + "\n"
                            + "Luster:            " + dataIndistinct75[i].luster + "\n" + "Hardness:            " + dataIndistinct75[i].hardness + "\n" +
                            "Cleavage:        " + dataIndistinct75[i].cleavage + "\n" + "Density:                " + dataIndistinct75[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Cubic" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataCubicTwo.size){
                    result1.append(dataCubicTwo[i].name + "\n" + "Color:            " + dataCubicTwo[i].color + "\n" + "Streak:            " + dataCubicTwo[i].streak + "\n"
                            + "Luster:            " + dataCubicTwo[i].luster + "\n" + "Hardness:            " + dataCubicTwo[i].hardness + "\n" +
                            "Cleavage:        " + dataCubicTwo[i].cleavage + "\n" + "Density:                " + dataCubicTwo[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "7.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasalSeven.size){
                    result1.append(dataBasalSeven[i].name + "\n" + "Color:            " + dataBasalSeven[i].color + "\n" + "Streak:            " + dataBasalSeven[i].streak + "\n"
                            + "Luster:            " + dataBasalSeven[i].luster + "\n" + "Hardness:            " + dataBasalSeven[i].hardness + "\n" +
                            "Cleavage:        " + dataBasalSeven[i].cleavage + "\n" + "Density:                " + dataBasalSeven[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "6.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasalSix.size){
                    result1.append(dataBasalSix[i].name + "\n" + "Color:            " + dataBasalSix[i].color + "\n" + "Streak:            " + dataBasalSix[i].streak + "\n"
                            + "Luster:            " + dataBasalSix[i].luster + "\n" + "Hardness:            " + dataBasalSix[i].hardness + "\n" +
                            "Cleavage:        " + dataBasalSix[i].cleavage + "\n" + "Density:                " + dataBasalSix[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "5.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasalFive.size){
                    result1.append(dataBasalFive[i].name + "\n" + "Color:            " + dataBasalFive[i].color + "\n" + "Streak:            " + dataBasalFive[i].streak + "\n"
                            + "Luster:            " + dataBasalFive[i].luster + "\n" + "Hardness:            " + dataBasalFive[i].hardness + "\n" +
                            "Cleavage:        " + dataBasalFive[i].cleavage + "\n" + "Density:                " + dataBasalFive[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "3.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasalThree.size){
                    result1.append(dataBasalThree[i].name + "\n" + "Color:            " + dataBasalThree[i].color + "\n" + "Streak:            " + dataBasalThree[i].streak + "\n"
                            + "Luster:            " + dataBasalThree[i].luster + "\n" + "Hardness:            " + dataBasalThree[i].hardness + "\n" +
                            "Cleavage:        " + dataBasalThree[i].cleavage + "\n" + "Density:                " + dataBasalThree[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "2.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasalTwo.size){
                    result1.append(dataBasalTwo[i].name + "\n" + "Color:            " + dataBasalTwo[i].color + "\n" + "Streak:            " + dataBasalTwo[i].streak + "\n"
                            + "Luster:            " + dataBasalTwo[i].luster + "\n" + "Hardness:            " + dataBasalTwo[i].hardness + "\n" +
                            "Cleavage:        " + dataBasalTwo[i].cleavage + "\n" + "Density:                " + dataBasalTwo[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "1.0" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBasalOne.size){
                    result1.append(dataBasalOne[i].name + "\n" + "Color:            " + dataBasalOne[i].color + "\n" + "Streak:            " + dataBasalOne[i].streak + "\n"
                            + "Luster:            " + dataBasalOne[i].luster + "\n" + "Hardness:            " + dataBasalOne[i].hardness + "\n" +
                            "Cleavage:        " + dataBasalOne[i].cleavage + "\n" + "Density:                " + dataBasalOne[i].density + "\n" + "\n")
                }
            }
            //color and Streak
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Gray") {
                for (i in 0 until dataSilverGray.size){
                    result1.append(dataSilverGray[i].name + "\n" + "Color:            " + dataSilverGray[i].color + "\n" + "Streak:            " + dataSilverGray[i].streak + "\n"
                            + "Luster:            " + dataSilverGray[i].luster + "\n" + "Hardness:            " + dataSilverGray[i].hardness + "\n" +
                            "Cleavage:        " + dataSilverGray[i].cleavage + "\n" + "Density:                " + dataSilverGray[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataSilverWhite.size){
                    result1.append(dataSilverWhite[i].name + "\n" + "Color:            " + dataSilverWhite[i].color + "\n" + "Streak:            " + dataSilverWhite[i].streak + "\n"
                            + "Luster:            " + dataSilverWhite[i].luster + "\n" + "Hardness:            " + dataSilverWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataSilverWhite[i].cleavage + "\n" + "Density:                " + dataSilverWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Colorless") {
                for (i in 0 until dataGrayColorless.size){
                    result1.append(dataGrayColorless[i].name + "\n" + "Color:            " + dataGrayColorless[i].color + "\n" + "Streak:            " + dataGrayColorless[i].streak + "\n"
                            + "Luster:            " + dataGrayColorless[i].luster + "\n" + "Hardness:            " + dataGrayColorless[i].hardness + "\n" +
                            "Cleavage:        " + dataGrayColorless[i].cleavage + "\n" + "Density:                " + dataGrayColorless[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataGrayWhite.size){
                    result1.append(dataGrayWhite[i].name + "\n" + "Color:            " + dataGrayWhite[i].color + "\n" + "Streak:            " + dataGrayWhite[i].streak + "\n"
                            + "Luster:            " + dataGrayWhite[i].luster + "\n" + "Hardness:            " + dataGrayWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataGrayWhite[i].cleavage + "\n" + "Density:                " + dataGrayWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataGrayBlack.size){
                    result1.append(dataGrayBlack[i].name + "\n" + "Color:            " + dataGrayBlack[i].color + "\n" + "Streak:            " + dataGrayBlack[i].streak + "\n"
                            + "Luster:            " + dataGrayBlack[i].luster + "\n" + "Hardness:            " + dataGrayBlack[i].hardness + "\n" +
                            "Cleavage:        " + dataGrayBlack[i].cleavage + "\n" + "Density:                " + dataGrayBlack[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataGreenWhite.size){
                    result1.append(dataGreenWhite[i].name + "\n" + "Color:            " + dataGreenWhite[i].color + "\n" + "Streak:            " + dataGreenWhite[i].streak + "\n"
                            + "Luster:            " + dataGreenWhite[i].luster + "\n" + "Hardness:            " + dataGreenWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataGreenWhite[i].cleavage + "\n" + "Density:                " + dataGreenWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Green") {
                for (i in 0 until dataGreenGreen.size){
                    result1.append(dataGreenGreen[i].name + "\n" + "Color:            " + dataGreenGreen[i].color + "\n" + "Streak:            " + dataGreenGreen[i].streak + "\n"
                            + "Luster:            " + dataGreenGreen[i].luster + "\n" + "Hardness:            " + dataGreenGreen[i].hardness + "\n" +
                            "Cleavage:        " + dataGreenGreen[i].cleavage + "\n" + "Density:                " + dataGreenGreen[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataYellowWhite.size){
                    result1.append(dataYellowWhite[i].name + "\n" + "Color:            " + dataYellowWhite[i].color + "\n" + "Streak:            " + dataYellowWhite[i].streak + "\n"
                            + "Luster:            " + dataYellowWhite[i].luster + "\n" + "Hardness:            " + dataYellowWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataYellowWhite[i].cleavage + "\n" + "Density:                " + dataGreenGreen[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataYellowBlack.size){
                    result1.append(dataYellowBlack[i].name + "\n" + "Color:            " + dataYellowBlack[i].color + "\n" + "Streak:            " + dataYellowBlack[i].streak + "\n"
                            + "Luster:            " + dataYellowBlack[i].luster + "\n" + "Hardness:            " + dataYellowBlack[i].hardness + "\n" +
                            "Cleavage:        " + dataYellowBlack[i].cleavage + "\n" + "Density:                " + dataYellowBlack[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Yellow") {
                for (i in 0 until dataYellowYellow.size){
                    result1.append(dataYellowYellow[i].name + "\n" + "Color:            " + dataYellowYellow[i].color + "\n" + "Streak:            " + dataYellowYellow[i].streak + "\n"
                            + "Luster:            " + dataYellowYellow[i].luster + "\n" + "Hardness:            " + dataYellowYellow[i].hardness + "\n" +
                            "Cleavage:        " + dataYellowYellow[i].cleavage + "\n" + "Density:                " + dataYellowYellow[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Purple" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataPurpleWhite.size){
                    result1.append(dataPurpleWhite[i].name + "\n" + "Color:            " + dataPurpleWhite[i].color + "\n" + "Streak:            " + dataPurpleWhite[i].streak + "\n"
                            + "Luster:            " + dataPurpleWhite[i].luster + "\n" + "Hardness:            " + dataPurpleWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataPurpleWhite[i].cleavage + "\n" + "Density:                " + dataPurpleWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataColorlessWhite.size){
                    result1.append(dataColorlessWhite[i].name + "\n" + "Color:            " + dataColorlessWhite[i].color + "\n" + "Streak:            " + dataColorlessWhite[i].streak + "\n"
                            + "Luster:            " + dataColorlessWhite[i].luster + "\n" + "Hardness:            " + dataColorlessWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataColorlessWhite[i].cleavage + "\n" + "Density:                " + dataColorlessWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Colorless") {
                for (i in 0 until dataWhiteColorless.size){
                    result1.append(dataWhiteColorless[i].name + "\n" + "Color:            " + dataWhiteColorless[i].color + "\n" + "Streak:            " + dataWhiteColorless[i].streak + "\n"
                            + "Luster:            " + dataWhiteColorless[i].luster + "\n" + "Hardness:            " + dataWhiteColorless[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteColorless[i].cleavage + "\n" + "Density:                " + dataWhiteColorless[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteWhite.size){
                    result1.append(dataWhiteWhite[i].name + "\n" + "Color:            " + dataWhiteWhite[i].color + "\n" + "Streak:            " + dataWhiteWhite[i].streak + "\n"
                            + "Luster:            " + dataWhiteWhite[i].luster + "\n" + "Hardness:            " + dataWhiteWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteWhite[i].cleavage + "\n" + "Density:                " + dataWhiteWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBlackWhite.size){
                    result1.append(dataBlackWhite[i].name + "\n" + "Color:            " + dataBlackWhite[i].color + "\n" + "Streak:            " + dataBlackWhite[i].streak + "\n"
                            + "Luster:            " + dataBlackWhite[i].luster + "\n" + "Hardness:            " + dataBlackWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataBlackWhite[i].cleavage + "\n" + "Density:                " + dataBlackWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataBlackBlack.size){
                    result1.append(dataBlackBlack[i].name + "\n" + "Color:            " + dataBlackBlack[i].color + "\n" + "Streak:            " + dataBlackBlack[i].streak + "\n"
                            + "Luster:            " + dataBlackBlack[i].luster + "\n" + "Hardness:            " + dataBlackBlack[i].hardness + "\n" +
                            "Cleavage:        " + dataBlackBlack[i].cleavage + "\n" + "Density:                " + dataBlackBlack[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Red") {
                for (i in 0 until dataBlackRed.size){
                    result1.append(dataBlackRed[i].name + "\n" + "Color:            " + dataBlackRed[i].color + "\n" + "Streak:            " + dataBlackRed[i].streak + "\n"
                            + "Luster:            " + dataBlackRed[i].luster + "\n" + "Hardness:            " + dataBlackRed[i].hardness + "\n" +
                            "Cleavage:        " + dataBlackRed[i].cleavage + "\n" + "Density:                " + dataBlackRed[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBrownWhite.size){
                    result1.append(dataBrownWhite[i].name + "\n" + "Color:            " + dataBrownWhite[i].color + "\n" + "Streak:            " + dataBrownWhite[i].streak + "\n"
                            + "Luster:            " + dataBrownWhite[i].luster + "\n" + "Hardness:            " + dataBrownWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataBrownWhite[i].cleavage + "\n" + "Density:                " + dataBrownWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Blue" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataBlueWhite.size){
                    result1.append(dataBlueWhite[i].name + "\n" + "Color:            " + dataBlueWhite[i].color + "\n" + "Streak:            " + dataBlueWhite[i].streak + "\n"
                            + "Luster:            " + dataBlueWhite[i].luster + "\n" + "Hardness:            " + dataBlueWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataBlueWhite[i].cleavage + "\n" + "Density:                " + dataBlueWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Red" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataRedWhite.size){
                    result1.append(dataRedWhite[i].name + "\n" + "Color:            " + dataRedWhite[i].color + "\n" + "Streak:            " + dataRedWhite[i].streak + "\n"
                            + "Luster:            " + dataRedWhite[i].luster + "\n" + "Hardness:            " + dataRedWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataRedWhite[i].cleavage + "\n" + "Density:                " + dataRedWhite[i].density + "\n" + "\n")
                }
            }

            //streak and cleavage
            if (msg1 == "" && msg2 == "Uneven" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteUneven.size){
                    result1.append(dataWhiteUneven[i].name + "\n" + "Color:            " + dataWhiteUneven[i].color + "\n" + "Streak:            " + dataWhiteUneven[i].streak + "\n"
                            + "Luster:            " + dataWhiteUneven[i].luster + "\n" + "Hardness:            " + dataWhiteUneven[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteUneven[i].cleavage + "\n" + "Density:                " + dataWhiteUneven[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Gray") {
                for (i in 0 until dataGrayNone.size){
                    result1.append(dataGrayNone[i].name + "\n" + "Color:            " + dataGrayNone[i].color + "\n" + "Streak:            " + dataGrayNone[i].streak + "\n"
                            + "Luster:            " + dataGrayNone[i].luster + "\n" + "Hardness:            " + dataGrayNone[i].hardness + "\n" +
                            "Cleavage:        " + dataGrayNone[i].cleavage + "\n" + "Density:                " + dataGrayNone[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Red") {
                for (i in 0 until dataRedNone.size){
                    result1.append(dataRedNone[i].name + "\n" + "Color:            " + dataRedNone[i].color + "\n" + "Streak:            " + dataRedNone[i].streak + "\n"
                            + "Luster:            " + dataRedNone[i].luster + "\n" + "Hardness:            " + dataRedNone[i].hardness + "\n" +
                            "Cleavage:        " + dataRedNone[i].cleavage + "\n" + "Density:                " + dataRedNone[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Yellow") {
                for (i in 0 until dataYellowNone.size){
                    result1.append(dataYellowNone[i].name + "\n" + "Color:            " + dataYellowNone[i].color + "\n" + "Streak:            " + dataYellowNone[i].streak + "\n"
                            + "Luster:            " + dataYellowNone[i].luster + "\n" + "Hardness:            " + dataYellowNone[i].hardness + "\n" +
                            "Cleavage:        " + dataYellowNone[i].cleavage + "\n" + "Density:                " + dataYellowNone[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "None" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteNone.size){
                    result1.append(dataWhiteNone[i].name + "\n" + "Color:            " + dataWhiteNone[i].color + "\n" + "Streak:            " + dataWhiteNone[i].streak + "\n"
                            + "Luster:            " + dataWhiteNone[i].luster + "\n" + "Hardness:            " + dataWhiteNone[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteNone[i].cleavage + "\n" + "Density:                " + dataWhiteNone[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Rhombohedral" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Colorless") {
                for (i in 0 until dataColorlessRhombo.size){
                    result1.append(dataColorlessRhombo[i].name + "\n" + "Color:            " + dataColorlessRhombo[i].color + "\n" + "Streak:            " + dataColorlessRhombo[i].streak + "\n"
                            + "Luster:            " + dataColorlessRhombo[i].luster + "\n" + "Hardness:            " + dataColorlessRhombo[i].hardness + "\n" +
                            "Cleavage:        " + dataColorlessRhombo[i].cleavage + "\n" + "Density:                " + dataColorlessRhombo[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteBasal.size){
                    result1.append(dataWhiteBasal[i].name + "\n" + "Color:            " + dataWhiteBasal[i].color + "\n" + "Streak:            " + dataWhiteBasal[i].streak + "\n"
                            + "Luster:            " + dataWhiteBasal[i].luster + "\n" + "Hardness:            " + dataWhiteBasal[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteBasal[i].cleavage + "\n" + "Density:                " + dataWhiteBasal[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Cubic" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteCubic.size){
                    result1.append(dataWhiteCubic[i].name + "\n" + "Color:            " + dataWhiteCubic[i].color + "\n" + "Streak:            " + dataWhiteCubic[i].streak + "\n"
                            + "Luster:            " + dataWhiteCubic[i].luster + "\n" + "Hardness:            " + dataWhiteCubic[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteCubic[i].cleavage + "\n" + "Density:                " + dataWhiteCubic[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Octahedral" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteOcta.size){
                    result1.append(dataWhiteOcta[i].name + "\n" + "Color:            " + dataWhiteOcta[i].color + "\n" + "Streak:            " + dataWhiteOcta[i].streak + "\n"
                            + "Luster:            " + dataWhiteOcta[i].luster + "\n" + "Hardness:            " + dataWhiteOcta[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteOcta[i].cleavage + "\n" + "Density:                " + dataWhiteOcta[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Rhombohedral" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteRhombo.size){
                    result1.append(dataWhiteRhombo[i].name + "\n" + "Color:            " + dataWhiteRhombo[i].color + "\n" + "Streak:            " + dataWhiteRhombo[i].streak + "\n"
                            + "Luster:            " + dataWhiteRhombo[i].luster + "\n" + "Hardness:            " + dataWhiteRhombo[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteRhombo[i].cleavage + "\n" + "Density:                " + dataWhiteRhombo[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteIndistinct.size){
                    result1.append(dataWhiteIndistinct[i].name + "\n" + "Color:            " + dataWhiteIndistinct[i].color + "\n" + "Streak:            " + dataWhiteIndistinct[i].streak + "\n"
                            + "Luster:            " + dataWhiteIndistinct[i].luster + "\n" + "Hardness:            " + dataWhiteIndistinct[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteIndistinct[i].cleavage + "\n" + "Density:                " + dataWhiteIndistinct[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Distinct" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "White") {
                for (i in 0 until dataWhiteDistinct.size){
                    result1.append(dataWhiteDistinct[i].name + "\n" + "Color:            " + dataWhiteDistinct[i].color + "\n" + "Streak:            " + dataWhiteDistinct[i].streak + "\n"
                            + "Luster:            " + dataWhiteDistinct[i].luster + "\n" + "Hardness:            " + dataWhiteDistinct[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteDistinct[i].cleavage + "\n" + "Density:                " + dataWhiteDistinct[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Green") {
                for (i in 0 until dataGreenBasal.size){
                    result1.append(dataGreenBasal[i].name + "\n" + "Color:            " + dataGreenBasal[i].color + "\n" + "Streak:            " + dataGreenBasal[i].streak + "\n"
                            + "Luster:            " + dataGreenBasal[i].luster + "\n" + "Hardness:            " + dataGreenBasal[i].hardness + "\n" +
                            "Cleavage:        " + dataGreenBasal[i].cleavage + "\n" + "Density:                " + dataGreenBasal[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataBlackBasal.size){
                    result1.append(dataBlackBasal[i].name + "\n" + "Color:            " + dataBlackBasal[i].color + "\n" + "Streak:            " + dataBlackBasal[i].streak + "\n"
                            + "Luster:            " + dataBlackBasal[i].luster + "\n" + "Hardness:            " + dataBlackBasal[i].hardness + "\n" +
                            "Cleavage:        " + dataBlackBasal[i].cleavage + "\n" + "Density:                " + dataBlackBasal[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Black") {
                for (i in 0 until dataBlackIndistinct.size){
                    result1.append(dataBlackIndistinct[i].name + "\n" + "Color:            " + dataBlackIndistinct[i].color + "\n" + "Streak:            " + dataBlackIndistinct[i].streak + "\n"
                            + "Luster:            " + dataBlackIndistinct[i].luster + "\n" + "Hardness:            " + dataBlackIndistinct[i].hardness + "\n" +
                            "Cleavage:        " + dataBlackIndistinct[i].cleavage + "\n" + "Density:                " + dataBlackIndistinct[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Basal" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Red") {
                for (i in 0 until dataRedBasal.size){
                    result1.append(dataRedBasal[i].name + "\n" + "Color:            " + dataRedBasal[i].color + "\n" + "Streak:            " + dataRedBasal[i].streak + "\n"
                            + "Luster:            " + dataRedBasal[i].luster + "\n" + "Hardness:            " + dataRedBasal[i].hardness + "\n" +
                            "Cleavage:        " + dataRedBasal[i].cleavage + "\n" + "Density:                " + dataRedBasal[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "" && msg2 == "Indistinct" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "Red") {
                for (i in 0 until dataRedIndistinct.size){
                    result1.append(dataRedIndistinct[i].name + "\n" + "Color:            " + dataRedIndistinct[i].color + "\n" + "Streak:            " + dataRedIndistinct[i].streak + "\n"
                            + "Luster:            " + dataRedIndistinct[i].luster + "\n" + "Hardness:            " + dataRedIndistinct[i].hardness + "\n" +
                            "Cleavage:        " + dataRedIndistinct[i].cleavage + "\n" + "Density:                " + dataRedIndistinct[i].density + "\n" + "\n")
                }
            }

            //color statements
            if (msg1 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until data2.size){
                    result1.append(data2[i].name + "\n" + "Color:            " + data2[i].color + "\n" + "Streak:            " + data2[i].streak + "\n"
                            + "Luster:            " + data2[i].luster + "\n" + "Hardness:            " + data2[i].hardness + "\n" +
                            "Cleavage:        " + data2[i].cleavage + "\n" + "Density:                " + data2[i].density + "\n" + "\n")
                    fun textSpan() {
                        val spannableString = SpannableString(result1.toString())
                        val fcolor = ForegroundColorSpan(Color.GRAY)
                    }
                }

            }
            if (msg1 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
            == "" && msg7 == "") {
                for (i in 0 until dataBlack.size){
                    result1.append(dataBlack[i].name + "\n" + "Color:            " + dataBlack[i].color + "\n" + "Streak:            " + dataBlack[i].streak + "\n"
                            + "Luster:            " + dataBlack[i].luster + "\n" + "Hardness:            " + dataBlack[i].hardness + "\n" +
                            "Cleavage:        " + dataBlack[i].cleavage + "\n" + "Density:                " + dataBlack[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Blue" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBlue.size){
                    result1.append(dataBlue[i].name + "\n" + "Color:            " + dataBlue[i].color + "\n" + "Streak:            " + dataBlue[i].streak + "\n"
                            + "Luster:            " + dataBlue[i].luster + "\n" + "Hardness:            " + dataBlue[i].hardness + "\n" +
                            "Cleavage:        " + dataBlue[i].cleavage + "\n" + "Density:                " + dataBlue[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataWhite.size){
                    result1.append(dataWhite[i].name + "\n" + "Color:            " + dataWhite[i].color + "\n" + "Streak:            " + dataWhite[i].streak + "\n"
                            + "Luster:            " + dataWhite[i].luster + "\n" + "Hardness:            " + dataWhite[i].hardness + "\n" +
                            "Cleavage:        " + dataWhite[i].cleavage + "\n" + "Density:                " + dataWhite[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Red" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataRed.size){
                    result1.append(dataRed[i].name + "\n" + "Color:            " + dataRed[i].color + "\n" + "Streak:            " + dataRed[i].streak + "\n"
                            + "Luster:            " + dataRed[i].luster + "\n" + "Hardness:            " + dataRed[i].hardness + "\n" +
                            "Cleavage:        " + dataRed[i].cleavage + "\n" + "Density:                " + dataRed[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataBrown.size){
                    result1.append(dataBrown[i].name + "\n" + "Color:            " + dataBrown[i].color + "\n" + "Streak:            " + dataBrown[i].streak + "\n"
                            + "Luster:            " + dataBrown[i].luster + "\n" + "Hardness:            " + dataBrown[i].hardness + "\n" +
                            "Cleavage:        " + dataBrown[i].cleavage + "\n" + "Density:                " + dataBrown[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Pink" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataPink.size){
                    result1.append(dataPink[i].name + "\n" + "Color:            " + dataPink[i].color + "\n" + "Streak:            " + dataPink[i].streak + "\n"
                            + "Luster:            " + dataPink[i].luster + "\n" + "Hardness:            " + dataPink[i].hardness + "\n" +
                            "Cleavage:        " + dataPink[i].cleavage + "\n" + "Density:                " + dataPink[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gold" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataGold.size){
                    result1.append(dataGold[i].name + "\n" + "Color:            " + dataGold[i].color + "\n" + "Streak:            " + dataGold[i].streak + "\n"
                            + "Luster:            " + dataGold[i].luster + "\n" + "Hardness:            " + dataGold[i].hardness + "\n" +
                            "Cleavage:        " + dataGold[i].cleavage + "\n" + "Density:                " + dataGold[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Violet" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataViolet.size){
                    result1.append(dataViolet[i].name + "\n" + "Color:            " + dataViolet[i].color + "\n" + "Streak:            " + dataViolet[i].streak + "\n"
                            + "Luster:            " + dataViolet[i].luster + "\n" + "Hardness:            " + dataViolet[i].hardness + "\n" +
                            "Cleavage:        " + dataViolet[i].cleavage + "\n" + "Density:                " + dataViolet[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataGreen.size){
                    result1.append(dataGreen[i].name + "\n" + "Color:            " + dataGreen[i].color + "\n" + "Streak:            " + dataGreen[i].streak + "\n"
                            + "Luster:            " + dataGreen[i].luster + "\n" + "Hardness:            " + dataGreen[i].hardness + "\n" +
                            "Cleavage:        " + dataGreen[i].cleavage + "\n" + "Density:                " + dataGreen[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Purple" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataPurple.size){
                    result1.append(dataPurple[i].name + "\n" + "Color:            " + dataPurple[i].color + "\n" + "Streak:            " + dataPurple[i].streak + "\n"
                            + "Luster:            " + dataPurple[i].luster + "\n" + "Hardness:            " + dataPurple[i].hardness + "\n" +
                            "Cleavage:        " + dataPurple[i].cleavage + "\n" + "Density:                " + dataPurple[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Orange" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataOrange.size){
                    result1.append(dataOrange[i].name + "\n" + "Color:            " + dataOrange[i].color + "\n" + "Streak:            " + dataOrange[i].streak + "\n"
                            + "Luster:            " + dataOrange[i].luster + "\n" + "Hardness:            " + dataOrange[i].hardness + "\n" +
                            "Cleavage:        " + dataOrange[i].cleavage + "\n" + "Density:                " + dataOrange[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataColorless.size){
                    result1.append(dataColorless[i].name + "\n" + "Color:            " + dataColorless[i].color + "\n" + "Streak:            " + dataColorless[i].streak + "\n"
                            + "Luster:            " + dataColorless[i].luster + "\n" + "Hardness:            " + dataColorless[i].hardness + "\n" +
                            "Cleavage:        " + dataColorless[i].cleavage + "\n" + "Density:                " + dataColorless[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataGray.size){
                    result1.append(dataGray[i].name + "\n" + "Color:            " + dataGray[i].color + "\n" + "Streak:            " + dataGray[i].streak + "\n"
                            + "Luster:            " + dataGray[i].luster + "\n" + "Hardness:            " + dataGray[i].hardness + "\n" +
                            "Cleavage:        " + dataGray[i].cleavage + "\n" + "Density:                " + dataGray[i].density + "\n" + "\n")
                }
            }
            if (msg1 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg7 == "") {
                for (i in 0 until dataSilver.size){
                    result1.append(dataSilver[i].name + "\n" + "Color:            " + dataSilver[i].color + "\n" + "Streak:            " + dataSilver[i].streak + "\n"
                            + "Luster:            " + dataSilver[i].luster + "\n" + "Hardness:            " + dataSilver[i].hardness + "\n" +
                            "Cleavage:        " + dataSilver[i].cleavage + "\n" + "Density:                " + dataSilver[i].density + "\n" + "\n")
                }
            }
            //streak statements
            if (msg7 == "White" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataWhiteStreak.size){
                    result1.append(dataWhiteStreak[i].name + "\n" + "Color:            " + dataWhiteStreak[i].color + "\n" + "Streak:            " + dataWhiteStreak[i].streak + "\n"
                            + "Luster:            " + dataWhiteStreak[i].luster + "\n" + "Hardness:            " + dataWhiteStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataWhiteStreak[i].cleavage + "\n" + "Density:                " + dataWhiteStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Green" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataGreenStreak.size){
                    result1.append(dataGreenStreak[i].name + "\n" + "Color:            " + dataGreenStreak[i].color + "\n" + "Streak:            " + dataGreenStreak[i].streak + "\n"
                            + "Luster:            " + dataGreenStreak[i].luster + "\n" + "Hardness:            " + dataGreenStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataGreenStreak[i].cleavage + "\n" + "Density:                " + dataGreenStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Black" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataBlackStreak.size){
                    result1.append(dataBlackStreak[i].name + "\n" + "Color:            " + dataBlackStreak[i].color + "\n" + "Streak:            " + dataBlackStreak[i].streak + "\n"
                            + "Luster:            " + dataBlackStreak[i].luster + "\n" + "Hardness:            " + dataBlackStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataBlackStreak[i].cleavage + "\n" + "Density:                " + dataBlackStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Gold" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataGoldStreak.size){
                    result1.append(dataGoldStreak[i].name + "\n" + "Color:            " + dataGoldStreak[i].color + "\n" + "Streak:            " + dataGoldStreak[i].streak + "\n"
                            + "Luster:            " + dataGoldStreak[i].luster + "\n" + "Hardness:            " + dataGoldStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataGoldStreak[i].cleavage + "\n" + "Density:                " + dataGoldStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Brown" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataBrownStreak.size){
                    result1.append(dataBrownStreak[i].name + "\n" + "Color:            " + dataBrownStreak[i].color + "\n" + "Streak:            " + dataBrownStreak[i].streak + "\n"
                            + "Luster:            " + dataBrownStreak[i].luster + "\n" + "Hardness:            " + dataBrownStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataBrownStreak[i].cleavage + "\n" + "Density:                " + dataBrownStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Red" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataRedStreak.size){
                    result1.append(dataRedStreak[i].name + "\n" + "Color:            " + dataRedStreak[i].color + "\n" + "Streak:            " + dataRedStreak[i].streak + "\n"
                            + "Luster:            " + dataRedStreak[i].luster + "\n" + "Hardness:            " + dataRedStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataRedStreak[i].cleavage + "\n" + "Density:                " + dataRedStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Shiny" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataShinyStreak.size){
                    result1.append(dataShinyStreak[i].name + "\n" + "Color:            " + dataShinyStreak[i].color + "\n" + "Streak:            " + dataShinyStreak[i].streak + "\n"
                            + "Luster:            " + dataShinyStreak[i].luster + "\n" + "Hardness:            " + dataShinyStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataShinyStreak[i].cleavage + "\n" + "Density:                " + dataShinyStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Gray" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataGrayStreak.size){
                    result1.append(dataGrayStreak[i].name + "\n" + "Color:            " + dataGrayStreak[i].color + "\n" + "Streak:            " + dataGrayStreak[i].streak + "\n"
                            + "Luster:            " + dataGrayStreak[i].luster + "\n" + "Hardness:            " + dataGrayStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataGrayStreak[i].cleavage + "\n" + "Density:                " + dataGrayStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Silver" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataSilverStreak.size){
                    result1.append(dataSilverStreak[i].name + "\n" + "Color:            " + dataSilverStreak[i].color + "\n" + "Streak:            " + dataSilverStreak[i].streak + "\n"
                            + "Luster:            " + dataSilverStreak[i].luster + "\n" + "Hardness:            " + dataSilverStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataSilverStreak[i].cleavage + "\n" + "Density:                " + dataSilverStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Colorless" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataColorlessStreak.size){
                    result1.append(dataColorlessStreak[i].name + "\n" + "Color:            " + dataColorlessStreak[i].color + "\n" + "Streak:            " + dataColorlessStreak[i].streak + "\n"
                            + "Luster:            " + dataColorlessStreak[i].luster + "\n" + "Hardness:            " + dataColorlessStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataColorlessStreak[i].cleavage + "\n" + "Density:                " + dataColorlessStreak[i].density + "\n" + "\n")
                }
            }
            if (msg7 == "Yellow" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg6
                == "" && msg1 == "") {
                for (i in 0 until dataYellowStreak.size){
                    result1.append(dataYellowStreak[i].name + "\n" + "Color:            " + dataYellowStreak[i].color + "\n" + "Streak:            " + dataYellowStreak[i].streak + "\n"
                            + "Luster:            " + dataYellowStreak[i].luster + "\n" + "Hardness:            " + dataYellowStreak[i].hardness + "\n" +
                            "Cleavage:        " + dataYellowStreak[i].cleavage + "\n" + "Density:                " + dataYellowStreak[i].density + "\n" + "\n")
                }
            }

            //luster statements
            if (msg6 == "Metallic" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataMetallic.size){
                    result1.append(dataMetallic[i].name + "\n" + "Color:            " + dataMetallic[i].color + "\n" + "Streak:            " + dataMetallic[i].streak + "\n"
                            + "Luster:            " + dataMetallic[i].luster + "\n" + "Hardness:            " + dataMetallic[i].hardness + "\n" +
                            "Cleavage:        " + dataMetallic[i].cleavage + "\n" + "Density:                " + dataMetallic[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Non-Metallic" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataNonmetallic.size){
                    result1.append(dataNonmetallic[i].name + "\n" + "Color:            " + dataNonmetallic[i].color + "\n" + "Streak:            " + dataNonmetallic[i].streak + "\n"
                            + "Luster:            " + dataNonmetallic[i].luster + "\n" + "Hardness:            " + dataNonmetallic[i].hardness + "\n" +
                            "Cleavage:        " + dataNonmetallic[i].cleavage + "\n" + "Density:                " + dataNonmetallic[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Resinous" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataResinous.size){
                    result1.append(dataResinous[i].name + "\n" + "Color:            " + dataResinous[i].color + "\n" + "Streak:            " + dataResinous[i].streak + "\n"
                            + "Luster:            " + dataResinous[i].luster + "\n" + "Hardness:            " + dataResinous[i].hardness + "\n" +
                            "Cleavage:        " + dataResinous[i].cleavage + "\n" + "Density:                " + dataResinous[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Earthy" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataEarthy.size){
                    result1.append(dataEarthy[i].name + "\n" + "Color:            " + dataEarthy[i].color + "\n" + "Streak:            " + dataEarthy[i].streak + "\n"
                            + "Luster:            " + dataEarthy[i].luster + "\n" + "Hardness:            " + dataEarthy[i].hardness + "\n" +
                            "Cleavage:        " + dataEarthy[i].cleavage + "\n" + "Density:                " + dataEarthy[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Silky" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataSilky.size){
                    result1.append(dataSilky[i].name + "\n" + "Color:            " + dataSilky[i].color + "\n" + "Streak:            " + dataSilky[i].streak + "\n"
                            + "Luster:            " + dataSilky[i].luster + "\n" + "Hardness:            " + dataSilky[i].hardness + "\n" +
                            "Cleavage:        " + dataSilky[i].cleavage + "\n" + "Density:                " + dataSilky[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Glassy" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataGlassy.size){
                    result1.append(dataGlassy[i].name + "\n" + "Color:            " + dataGlassy[i].color + "\n" + "Streak:            " + dataGlassy[i].streak + "\n"
                            + "Luster:            " + dataGlassy[i].luster + "\n" + "Hardness:            " + dataGlassy[i].hardness + "\n" +
                            "Cleavage:        " + dataGlassy[i].cleavage + "\n" + "Density:                " + dataGlassy[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Pearly" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataPearly.size){
                    result1.append(dataPearly[i].name + "\n" + "Color:            " + dataPearly[i].color + "\n" + "Streak:            " + dataPearly[i].streak + "\n"
                            + "Luster:            " + dataPearly[i].luster + "\n" + "Hardness:            " + dataPearly[i].hardness + "\n" +
                            "Cleavage:        " + dataPearly[i].cleavage + "\n" + "Density:                " + dataPearly[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Waxy" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataWaxy.size){
                    result1.append(dataWaxy[i].name + "\n" + "Color:            " + dataWaxy[i].color + "\n" + "Streak:            " + dataWaxy[i].streak + "\n"
                            + "Luster:            " + dataWaxy[i].luster + "\n" + "Hardness:            " + dataWaxy[i].hardness + "\n" +
                            "Cleavage:        " + dataWaxy[i].cleavage + "\n" + "Density:                " + dataWaxy[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Adamantine" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataAdamantine.size){
                    result1.append(dataAdamantine[i].name + "\n" + "Color:            " + dataAdamantine[i].color + "\n" + "Streak:            " + dataAdamantine[i].streak + "\n"
                            + "Luster:            " + dataAdamantine[i].luster + "\n" + "Hardness:            " + dataAdamantine[i].hardness + "\n" +
                            "Cleavage:        " + dataAdamantine[i].cleavage + "\n" + "Density:                " + dataAdamantine[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Sub-metallic" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataSubmetallic.size){
                    result1.append(dataSubmetallic[i].name + "\n" + "Color:            " + dataSubmetallic[i].color + "\n" + "Streak:            " + dataSubmetallic[i].streak + "\n"
                            + "Luster:            " + dataSubmetallic[i].luster + "\n" + "Hardness:            " + dataSubmetallic[i].hardness + "\n" +
                            "Cleavage:        " + dataSubmetallic[i].cleavage + "\n" + "Density:                " + dataSubmetallic[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Dull" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataDull.size){
                    result1.append(dataDull[i].name + "\n" + "Color:            " + dataDull[i].color + "\n" + "Streak:            " + dataDull[i].streak + "\n"
                            + "Luster:            " + dataDull[i].luster + "\n" + "Hardness:            " + dataDull[i].hardness + "\n" +
                            "Cleavage:        " + dataDull[i].cleavage + "\n" + "Density:                " + dataDull[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Vitreous" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataVitreous.size){
                    result1.append(dataVitreous[i].name + "\n" + "Color:            " + dataVitreous[i].color + "\n" + "Streak:            " + dataVitreous[i].streak + "\n"
                            + "Luster:            " + dataVitreous[i].luster + "\n" + "Hardness:            " + dataVitreous[i].hardness + "\n" +
                            "Cleavage:        " + dataVitreous[i].cleavage + "\n" + "Density:                " + dataVitreous[i].density + "\n" + "\n")
                }
            }
            if (msg6 == "Greasy" && msg2 == "" && msg3 == "" && msg4 == "" && msg5 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataGreasy.size){
                    result1.append(dataGreasy[i].name + "\n" + "Color:            " + dataGreasy[i].color + "\n" + "Streak:            " + dataGreasy[i].streak + "\n"
                            + "Luster:            " + dataGreasy[i].luster + "\n" + "Hardness:            " + dataGreasy[i].hardness + "\n" +
                            "Cleavage:        " + dataGreasy[i].cleavage + "\n" + "Density:                " + dataGreasy[i].density + "\n" + "\n")
                }
            }
            //hardness statements
            if (msg5 == "1.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataOne.size){
                    result1.append(dataOne[i].name + "\n" + "Color:            " + dataOne[i].color + "\n" + "Streak:            " + dataOne[i].streak + "\n"
                            + "Luster:            " + dataOne[i].luster + "\n" + "Hardness:            " + dataOne[i].hardness + "\n" +
                            "Cleavage:        " + dataOne[i].cleavage + "\n" + "Density:                " + dataOne[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "2.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo.size){
                    result1.append(dataTwo[i].name + "\n" + "Color:            " + dataTwo[i].color + "\n" + "Streak:            " + dataTwo[i].streak + "\n"
                            + "Luster:            " + dataTwo[i].luster + "\n" + "Hardness:            " + dataTwo[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo[i].cleavage + "\n" + "Density:                " + dataTwo[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "3.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree.size){
                    result1.append(dataThree[i].name + "\n" + "Color:            " + dataThree[i].color + "\n" + "Streak:            " + dataThree[i].streak + "\n"
                            + "Luster:            " + dataThree[i].luster + "\n" + "Hardness:            " + dataThree[i].hardness + "\n" +
                            "Cleavage:        " + dataThree[i].cleavage + "\n" + "Density:                " + dataThree[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "4.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFour.size){
                    result1.append(dataFour[i].name + "\n" + "Color:            " + dataFour[i].color + "\n" + "Streak:            " + dataFour[i].streak + "\n"
                            + "Luster:            " + dataFour[i].luster + "\n" + "Hardness:            " + dataFour[i].hardness + "\n" +
                            "Cleavage:        " + dataFour[i].cleavage + "\n" + "Density:                " + dataFour[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "5.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFive.size){
                    result1.append(dataFive[i].name + "\n" + "Color:            " + dataFive[i].color + "\n" + "Streak:            " + dataFive[i].streak + "\n"
                            + "Luster:            " + dataFive[i].luster + "\n" + "Hardness:            " + dataFive[i].hardness + "\n" +
                            "Cleavage:        " + dataFive[i].cleavage + "\n" + "Density:                " + dataFive[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "6.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataSix.size){
                    result1.append(dataSix[i].name + "\n" + "Color:            " + dataSix[i].color + "\n" + "Streak:            " + dataSix[i].streak + "\n"
                            + "Luster:            " + dataSix[i].luster + "\n" + "Hardness:            " + dataSix[i].hardness + "\n" +
                            "Cleavage:        " + dataSix[i].cleavage + "\n" + "Density:                " + dataSix[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "7.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataSeven.size){
                    result1.append(dataSeven[i].name + "\n" + "Color:            " + dataSeven[i].color + "\n" + "Streak:            " + dataSeven[i].streak + "\n"
                            + "Luster:            " + dataSeven[i].luster + "\n" + "Hardness:            " + dataSeven[i].hardness + "\n" +
                            "Cleavage:        " + dataSeven[i].cleavage + "\n" + "Density:                " + dataSeven[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "8.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataEight.size){
                    result1.append(dataEight[i].name + "\n" + "Color:            " + dataEight[i].color + "\n" + "Streak:            " + dataEight[i].streak + "\n"
                            + "Luster:            " + dataEight[i].luster + "\n" + "Hardness:            " + dataEight[i].hardness + "\n" +
                            "Cleavage:        " + dataEight[i].cleavage + "\n" + "Density:                " + dataEight[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "9.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataNine.size){
                    result1.append(dataNine[i].name + "\n" + "Color:            " + dataNine[i].color + "\n" + "Streak:            " + dataNine[i].streak + "\n"
                            + "Luster:            " + dataNine[i].luster + "\n" + "Hardness:            " + dataNine[i].hardness + "\n" +
                            "Cleavage:        " + dataNine[i].cleavage + "\n" + "Density:                " + dataNine[i].density + "\n" + "\n")
                }
            }
            if (msg5 == "10.0" && msg2 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTen.size){
                    result1.append(dataTen[i].name + "\n" + "Color:            " + dataTen[i].color + "\n" + "Streak:            " + dataTen[i].streak + "\n"
                            + "Luster:            " + dataTen[i].luster + "\n" + "Hardness:            " + dataTen[i].hardness + "\n" +
                            "Cleavage:        " + dataTen[i].cleavage + "\n" + "Density:                " + dataTen[i].density + "\n" + "\n")
                }
            }

            //cleavage statements
            if (msg2 == "Indistinct" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataIndistinct.size){
                    result1.append(dataIndistinct[i].name + "\n" + "Color:            " + dataIndistinct[i].color + "\n" + "Streak:            " + dataIndistinct[i].streak + "\n"
                            + "Luster:            " + dataIndistinct[i].luster + "\n" + "Hardness:            " + dataIndistinct[i].hardness + "\n" +
                            "Cleavage:        " + dataIndistinct[i].cleavage + "\n" + "Density:                " + dataIndistinct[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Distinct" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataDistinct.size){
                    result1.append(dataDistinct[i].name + "\n" + "Color:            " + dataDistinct[i].color + "\n" + "Streak:            " + dataDistinct[i].streak + "\n"
                            + "Luster:            " + dataDistinct[i].luster + "\n" + "Hardness:            " + dataDistinct[i].hardness + "\n" +
                            "Cleavage:        " + dataDistinct[i].cleavage + "\n" + "Density:                " + dataDistinct[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Uneven" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataUneven.size){
                    result1.append(dataUneven[i].name + "\n" + "Color:            " + dataUneven[i].color + "\n" + "Streak:            " + dataUneven[i].streak + "\n"
                            + "Luster:            " + dataUneven[i].luster + "\n" + "Hardness:            " + dataUneven[i].hardness + "\n" +
                            "Cleavage:        " + dataUneven[i].cleavage + "\n" + "Density:                " + dataUneven[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Basal" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataBasal.size){
                    result1.append(dataBasal[i].name + "\n" + "Color:            " + dataBasal[i].color + "\n" + "Streak:            " + dataBasal[i].streak + "\n"
                            + "Luster:            " + dataBasal[i].luster + "\n" + "Hardness:            " + dataBasal[i].hardness + "\n" +
                            "Cleavage:        " + dataBasal[i].cleavage + "\n" + "Density:                " + dataBasal[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Cubic" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataCubic.size){
                    result1.append(dataCubic[i].name + "\n" + "Color:            " + dataCubic[i].color + "\n" + "Streak:            " + dataCubic[i].streak + "\n"
                            + "Luster:            " + dataCubic[i].luster + "\n" + "Hardness:            " + dataCubic[i].hardness + "\n" +
                            "Cleavage:        " + dataCubic[i].cleavage + "\n" + "Density:                " + dataCubic[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Octahedral" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataOctahedral.size){
                    result1.append(dataOctahedral[i].name + "\n" + "Color:            " + dataOctahedral[i].color + "\n" + "Streak:            " + dataOctahedral[i].streak + "\n"
                            + "Luster:            " + dataOctahedral[i].luster + "\n" + "Hardness:            " + dataOctahedral[i].hardness + "\n" +
                            "Cleavage:        " + dataOctahedral[i].cleavage + "\n" + "Density:                " + dataOctahedral[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Prismatic" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataPrismatic.size){
                    result1.append(dataPrismatic[i].name + "\n" + "Color:            " + dataPrismatic[i].color + "\n" + "Streak:            " + dataPrismatic[i].streak + "\n"
                            + "Luster:            " + dataPrismatic[i].luster + "\n" + "Hardness:            " + dataPrismatic[i].hardness + "\n" +
                            "Cleavage:        " + dataPrismatic[i].cleavage + "\n" + "Density:                " + dataPrismatic[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Pinicoidal" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataPinicoidal.size){
                    result1.append(dataPinicoidal[i].name + "\n" + "Color:            " + dataPinicoidal[i].color + "\n" + "Streak:            " + dataPinicoidal[i].streak + "\n"
                            + "Luster:            " + dataPinicoidal[i].luster + "\n" + "Hardness:            " + dataPinicoidal[i].hardness + "\n" +
                            "Cleavage:        " + dataPinicoidal[i].cleavage + "\n" + "Density:                " + dataPinicoidal[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "Rhombohedral" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataRhombohedral.size){
                    result1.append(dataRhombohedral[i].name + "\n" + "Color:            " + dataRhombohedral[i].color + "\n" + "Streak:            " + dataRhombohedral[i].streak + "\n"
                            + "Luster:            " + dataRhombohedral[i].luster + "\n" + "Hardness:            " + dataRhombohedral[i].hardness + "\n" +
                            "Cleavage:        " + dataRhombohedral[i].cleavage + "\n" + "Density:                " + dataRhombohedral[i].density + "\n" + "\n")
                }
            }
            if (msg2 == "None" && msg5 == "" && msg3 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataNone.size){
                    result1.append(dataNone[i].name + "\n" + "Color:            " + dataNone[i].color + "\n" + "Streak:            " + dataNone[i].streak + "\n"
                            + "Luster:            " + dataNone[i].luster + "\n" + "Hardness:            " + dataNone[i].hardness + "\n" +
                            "Cleavage:        " + dataNone[i].cleavage + "\n" + "Density:                " + dataNone[i].density + "\n" + "\n")
                }
            }
            //density statements
            if (msg3 == "0.9" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until datazero9.size){
                    result1.append(datazero9[i].name + "\n" + "Color:            " + datazero9[i].color + "\n" + "Streak:            " + datazero9[i].streak + "\n"
                            + "Luster:            " + datazero9[i].luster + "\n" + "Hardness:            " + datazero9[i].hardness + "\n" +
                            "Cleavage:        " + datazero9[i].cleavage + "\n" + "Density:                " + datazero9[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.6" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo6.size){
                    result1.append(dataTwo6[i].name + "\n" + "Color:            " + dataTwo6[i].color + "\n" + "Streak:            " + dataTwo6[i].streak + "\n"
                            + "Luster:            " + dataTwo6[i].luster + "\n" + "Hardness:            " + dataTwo6[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo6[i].cleavage + "\n" + "Density:                " + dataTwo6[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.7" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo7.size){
                    result1.append(dataTwo7[i].name + "\n" + "Color:            " + dataTwo7[i].color + "\n" + "Streak:            " + dataTwo7[i].streak + "\n"
                            + "Luster:            " + dataTwo7[i].luster + "\n" + "Hardness:            " + dataTwo7[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo7[i].cleavage + "\n" + "Density:                " + dataTwo7[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "5.2" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFive2.size){
                    result1.append(dataFive2[i].name + "\n" + "Color:            " + dataFive2[i].color + "\n" + "Streak:            " + dataFive2[i].streak + "\n"
                            + "Luster:            " + dataFive2[i].luster + "\n" + "Hardness:            " + dataFive2[i].hardness + "\n" +
                            "Cleavage:        " + dataFive2[i].cleavage + "\n" + "Density:                " + dataFive2[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "5.0" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFive5.size){
                    result1.append(dataFive5[i].name + "\n" + "Color:            " + dataFive5[i].color + "\n" + "Streak:            " + dataFive5[i].streak + "\n"
                            + "Luster:            " + dataFive5[i].luster + "\n" + "Hardness:            " + dataFive5[i].hardness + "\n" +
                            "Cleavage:        " + dataFive5[i].cleavage + "\n" + "Density:                " + dataFive5[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "19.0" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataNineteen.size){
                    result1.append(dataNineteen[i].name + "\n" + "Color:            " + dataNineteen[i].color + "\n" + "Streak:            " + dataNineteen[i].streak + "\n"
                            + "Luster:            " + dataNineteen[i].luster + "\n" + "Hardness:            " + dataNineteen[i].hardness + "\n" +
                            "Cleavage:        " + dataNineteen[i].cleavage + "\n" + "Density:                " + dataNineteen[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "5.7" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFive7.size){
                    result1.append(dataFive7[i].name + "\n" + "Color:            " + dataFive7[i].color + "\n" + "Streak:            " + dataFive7[i].streak + "\n"
                            + "Luster:            " + dataFive7[i].luster + "\n" + "Hardness:            " + dataFive7[i].hardness + "\n" +
                            "Cleavage:        " + dataFive7[i].cleavage + "\n" + "Density:                " + dataFive7[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.3" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo3.size){
                    result1.append(dataTwo3[i].name + "\n" + "Color:            " + dataTwo3[i].color + "\n" + "Streak:            " + dataTwo3[i].streak + "\n"
                            + "Luster:            " + dataTwo3[i].luster + "\n" + "Hardness:            " + dataTwo3[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo3[i].cleavage + "\n" + "Density:                " + dataTwo3[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.9" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo9.size){
                    result1.append(dataTwo9[i].name + "\n" + "Color:            " + dataTwo9[i].color + "\n" + "Streak:            " + dataTwo9[i].streak + "\n"
                            + "Luster:            " + dataTwo9[i].luster + "\n" + "Hardness:            " + dataTwo9[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo9[i].cleavage + "\n" + "Density:                " + dataTwo9[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.8" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo8.size){
                    result1.append(dataTwo8[i].name + "\n" + "Color:            " + dataTwo8[i].color + "\n" + "Streak:            " + dataTwo8[i].streak + "\n"
                            + "Luster:            " + dataTwo8[i].luster + "\n" + "Hardness:            " + dataTwo8[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo8[i].cleavage + "\n" + "Density:                " + dataTwo8[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "19.3" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataNineteen3.size){
                    result1.append(dataNineteen3[i].name + "\n" + "Color:            " + dataNineteen3[i].color + "\n" + "Streak:            " + dataNineteen3[i].streak + "\n"
                            + "Luster:            " + dataNineteen3[i].luster + "\n" + "Hardness:            " + dataNineteen3[i].hardness + "\n" +
                            "Cleavage:        " + dataNineteen3[i].cleavage + "\n" + "Density:                " + dataNineteen3[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.2" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo2.size){
                    result1.append(dataTwo2[i].name + "\n" + "Color:            " + dataTwo2[i].color + "\n" + "Streak:            " + dataTwo2[i].streak + "\n"
                            + "Luster:            " + dataTwo2[i].luster + "\n" + "Hardness:            " + dataTwo2[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo2[i].cleavage + "\n" + "Density:                " + dataTwo2[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.1" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo1.size){
                    result1.append(dataTwo1[i].name + "\n" + "Color:            " + dataTwo1[i].color + "\n" + "Streak:            " + dataTwo1[i].streak + "\n"
                            + "Luster:            " + dataTwo1[i].luster + "\n" + "Hardness:            " + dataTwo1[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo1[i].cleavage + "\n" + "Density:                " + dataTwo1[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "3.5" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree5.size){
                    result1.append(dataThree5[i].name + "\n" + "Color:            " + dataThree5[i].color + "\n" + "Streak:            " + dataThree5[i].streak + "\n"
                            + "Luster:            " + dataThree5[i].luster + "\n" + "Hardness:            " + dataThree5[i].hardness + "\n" +
                            "Cleavage:        " + dataThree5[i].cleavage + "\n" + "Density:                " + dataThree5[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "5.3" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFive3.size){
                    result1.append(dataFive3[i].name + "\n" + "Color:            " + dataFive3[i].color + "\n" + "Streak:            " + dataFive3[i].streak + "\n"
                            + "Luster:            " + dataFive3[i].luster + "\n" + "Hardness:            " + dataFive3[i].hardness + "\n" +
                            "Cleavage:        " + dataFive3[i].cleavage + "\n" + "Density:                " + dataFive3[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "8.9" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataEight9.size){
                    result1.append(dataEight9[i].name + "\n" + "Color:            " + dataEight9[i].color + "\n" + "Streak:            " + dataEight9[i].streak + "\n"
                            + "Luster:            " + dataEight9[i].luster + "\n" + "Hardness:            " + dataEight9[i].hardness + "\n" +
                            "Cleavage:        " + dataEight9[i].cleavage + "\n" + "Density:                " + dataEight9[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "3.6" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree6.size){
                    result1.append(dataThree6[i].name + "\n" + "Color:            " + dataThree6[i].color + "\n" + "Streak:            " + dataThree6[i].streak + "\n"
                            + "Luster:            " + dataThree6[i].luster + "\n" + "Hardness:            " + dataThree6[i].hardness + "\n" +
                            "Cleavage:        " + dataThree6[i].cleavage + "\n" + "Density:                " + dataThree6[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "3.9" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree9.size){
                    result1.append(dataThree9[i].name + "\n" + "Color:            " + dataThree9[i].color + "\n" + "Streak:            " + dataThree9[i].streak + "\n"
                            + "Luster:            " + dataThree9[i].luster + "\n" + "Hardness:            " + dataThree9[i].hardness + "\n" +
                            "Cleavage:        " + dataThree9[i].cleavage + "\n" + "Density:                " + dataThree9[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "3.2" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree2.size){
                    result1.append(dataThree2[i].name + "\n" + "Color:            " + dataThree2[i].color + "\n" + "Streak:            " + dataThree2[i].streak + "\n"
                            + "Luster:            " + dataThree2[i].luster + "\n" + "Hardness:            " + dataThree2[i].hardness + "\n" +
                            "Cleavage:        " + dataThree2[i].cleavage + "\n" + "Density:                " + dataThree2[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "3.3" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree3.size){
                    result1.append(dataThree3[i].name + "\n" + "Color:            " + dataThree3[i].color + "\n" + "Streak:            " + dataThree3[i].streak + "\n"
                            + "Luster:            " + dataThree3[i].luster + "\n" + "Hardness:            " + dataThree3[i].hardness + "\n" +
                            "Cleavage:        " + dataThree3[i].cleavage + "\n" + "Density:                " + dataThree3[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "4.2" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFour2.size){
                    result1.append(dataFour2[i].name + "\n" + "Color:            " + dataFour2[i].color + "\n" + "Streak:            " + dataFour2[i].streak + "\n"
                            + "Luster:            " + dataFour2[i].luster + "\n" + "Hardness:            " + dataFour2[i].hardness + "\n" +
                            "Cleavage:        " + dataFour2[i].cleavage + "\n" + "Density:                " + dataFour2[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "4.7" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFour7.size){
                    result1.append(dataFour7[i].name + "\n" + "Color:            " + dataFour7[i].color + "\n" + "Streak:            " + dataFour7[i].streak + "\n"
                            + "Luster:            " + dataFour7[i].luster + "\n" + "Hardness:            " + dataFour7[i].hardness + "\n" +
                            "Cleavage:        " + dataFour7[i].cleavage + "\n" + "Density:                " + dataFour7[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "2.5" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataTwo5.size){
                    result1.append(dataTwo5[i].name + "\n" + "Color:            " + dataTwo5[i].color + "\n" + "Streak:            " + dataTwo5[i].streak + "\n"
                            + "Luster:            " + dataTwo5[i].luster + "\n" + "Hardness:            " + dataTwo5[i].hardness + "\n" +
                            "Cleavage:        " + dataTwo5[i].cleavage + "\n" + "Density:                " + dataTwo5[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "3.0" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataThree33.size){
                    result1.append(dataThree33[i].name + "\n" + "Color:            " + dataThree33[i].color + "\n" + "Streak:            " + dataThree33[i].streak + "\n"
                            + "Luster:            " + dataThree33[i].luster + "\n" + "Hardness:            " + dataThree33[i].hardness + "\n" +
                            "Cleavage:        " + dataThree33[i].cleavage + "\n" + "Density:                " + dataThree33[i].density + "\n" + "\n")
                }
            }
            if (msg3 == "4.5" && msg5 == "" && msg2 == "" && msg4 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFour5.size){
                    result1.append(dataFour5[i].name + "\n" + "Color:            " + dataFour5[i].color + "\n" + "Streak:            " + dataFour5[i].streak + "\n"
                            + "Luster:            " + dataFour5[i].luster + "\n" + "Hardness:            " + dataFour5[i].hardness + "\n" +
                            "Cleavage:        " + dataFour5[i].cleavage + "\n" + "Density:                " + dataFour5[i].density + "\n" + "\n")
                }
            }
            //fracture statements
            if (msg4 == "Uneven" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataUnevenFracture.size){
                    result1.append(dataUnevenFracture[i].name + "\n" + "Color:            " + dataUnevenFracture[i].color + "\n" + "Streak:            " + dataUnevenFracture[i].streak + "\n"
                            + "Luster:            " + dataUnevenFracture[i].luster + "\n" + "Hardness:            " + dataUnevenFracture[i].hardness + "\n" +
                            "Cleavage:        " + dataUnevenFracture[i].cleavage + "\n" + "Density:                " + dataUnevenFracture[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "None" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataNoneFracture.size){
                    result1.append(dataNoneFracture[i].name + "\n" + "Color:            " + dataNoneFracture[i].color + "\n" + "Streak:            " + dataNoneFracture[i].streak + "\n"
                            + "Luster:            " + dataNoneFracture[i].luster + "\n" + "Hardness:            " + dataNoneFracture[i].hardness + "\n" +
                            "Cleavage:        " + dataNoneFracture[i].cleavage + "\n" + "Density:                " + dataNoneFracture[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "Conchoidal" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataConchoidal.size){
                    result1.append(dataConchoidal[i].name + "\n" + "Color:            " + dataConchoidal[i].color + "\n" + "Streak:            " + dataConchoidal[i].streak + "\n"
                            + "Luster:            " + dataConchoidal[i].luster + "\n" + "Hardness:            " + dataConchoidal[i].hardness + "\n" +
                            "Cleavage:        " + dataConchoidal[i].cleavage + "\n" + "Density:                " + dataConchoidal[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "Fibrous" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataFibrous.size){
                    result1.append(dataFibrous[i].name + "\n" + "Color:            " + dataFibrous[i].color + "\n" + "Streak:            " + dataFibrous[i].streak + "\n"
                            + "Luster:            " + dataFibrous[i].luster + "\n" + "Hardness:            " + dataFibrous[i].hardness + "\n" +
                            "Cleavage:        " + dataFibrous[i].cleavage + "\n" + "Density:                " + dataFibrous[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "Hackly" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataHackly.size){
                    result1.append(dataHackly[i].name + "\n" + "Color:            " + dataHackly[i].color + "\n" + "Streak:            " + dataHackly[i].streak + "\n"
                            + "Luster:            " + dataHackly[i].luster + "\n" + "Hardness:            " + dataHackly[i].hardness + "\n" +
                            "Cleavage:        " + dataHackly[i].cleavage + "\n" + "Density:                " + dataHackly[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "Splintery" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataSplintery.size){
                    result1.append(dataSplintery[i].name + "\n" + "Color:            " + dataSplintery[i].color + "\n" + "Streak:            " + dataSplintery[i].streak + "\n"
                            + "Luster:            " + dataSplintery[i].luster + "\n" + "Hardness:            " + dataSplintery[i].hardness + "\n" +
                            "Cleavage:        " + dataSplintery[i].cleavage + "\n" + "Density:                " + dataSplintery[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "Irregular" && msg5 == "" && msg2 == "" && msg3 == "" && msg6 == "" && msg7
                == "" && msg1 == "") {
                for (i in 0 until dataIrregular.size){
                    result1.append(dataIrregular[i].name + "\n" + "Color:            " + dataIrregular[i].color + "\n" + "Streak:            " + dataIrregular[i].streak + "\n"
                            + "Luster:            " + dataIrregular[i].luster + "\n" + "Hardness:            " + dataIrregular[i].hardness + "\n" +
                            "Cleavage:        " + dataIrregular[i].cleavage + "\n" + "Density:                " + dataIrregular[i].density + "\n" + "\n")
                }
            }
            //six properties
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Indistinct" && msg3 == "2.3" && msg6 == "Glassy" && msg7
                == "White" && msg1 == "Colorless") {
                for (i in 0 until dataQuartz.size){
                    result1.append(dataQuartz[i].name + "\n" + "Color:            " + dataQuartz[i].color + "\n" + "Streak:            " + dataQuartz[i].streak + "\n"
                            + "Luster:            " + dataQuartz[i].luster + "\n" + "Hardness:            " + dataQuartz[i].hardness + "\n" +
                            "Cleavage:        " + dataQuartz[i].cleavage + "\n" + "Density:                " + dataQuartz[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "3.0" && msg2 == "Rhombohedral" && msg3 == "2.7" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Brown") {
                for (i in 0 until dataCalcite.size){
                    result1.append(dataCalcite[i].name + "\n" + "Color:            " + dataCalcite[i].color + "\n" + "Streak:            " + dataCalcite[i].streak + "\n"
                            + "Luster:            " + dataCalcite[i].luster + "\n" + "Hardness:            " + dataCalcite[i].hardness + "\n" +
                            "Cleavage:        " + dataCalcite[i].cleavage + "\n" + "Density:                " + dataCalcite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.0" && msg2 == "None" && msg3 == "2.6" && msg6 == "Earthy" && msg7
                == "White" && msg1 == "Brown") {
                for (i in 0 until dataBauxite.size){
                    result1.append(dataBauxite[i].name + "\n" + "Color:            " + dataBauxite[i].color + "\n" + "Streak:            " + dataBauxite[i].streak + "\n"
                            + "Luster:            " + dataBauxite[i].luster + "\n" + "Hardness:            " + dataBauxite[i].hardness + "\n" +
                            "Cleavage:        " + dataBauxite[i].cleavage + "\n" + "Density:                " + dataBauxite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Indistinct" && msg3 == "5.0" && msg6 == "Metallic" && msg7
                == "Black" && msg1 == "Yellow") {
                for (i in 0 until dataPyrite.size){
                    result1.append(dataPyrite[i].name + "\n" + "Color:            " + dataPyrite[i].color + "\n" + "Streak:            " + dataPyrite[i].streak + "\n"
                            + "Luster:            " + dataPyrite[i].luster + "\n" + "Hardness:            " + dataPyrite[i].hardness + "\n" +
                            "Cleavage:        " + dataPyrite[i].cleavage + "\n" + "Density:                " + dataPyrite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Indistinct" && msg3 == "19.0" && msg6 == "Sub-Metallic" && msg7
                == "Black" && msg1 == "Gray") {
                for (i in 0 until dataUranium.size){
                    result1.append(dataUranium[i].name + "\n" + "Color:            " + dataUranium[i].color + "\n" + "Streak:            " + dataUranium[i].streak + "\n"
                            + "Luster:            " + dataUranium[i].luster + "\n" + "Hardness:            " + dataUranium[i].hardness + "\n" +
                            "Cleavage:        " + dataUranium[i].cleavage + "\n" + "Density:                " + dataUranium[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "5.0" && msg2 == "Distinct" && msg3 == "5.7" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Brown") {
                for (i in 0 until dataMonazite.size){
                    result1.append(dataMonazite[i].name + "\n" + "Color:            " + dataMonazite[i].color + "\n" + "Streak:            " + dataMonazite[i].streak + "\n"
                            + "Luster:            " + dataMonazite[i].luster + "\n" + "Hardness:            " + dataMonazite[i].hardness + "\n" +
                            "Cleavage:        " + dataMonazite[i].cleavage + "\n" + "Density:                " + dataMonazite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "5.0" && msg2 == "Indistinct" && msg3 == "3.2" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Blue") {
                for (i in 0 until dataApatite.size){
                    result1.append(dataApatite[i].name + "\n" + "Color:            " + dataApatite[i].color + "\n" + "Streak:            " + dataApatite[i].streak + "\n"
                            + "Luster:            " + dataApatite[i].luster + "\n" + "Hardness:            " + dataApatite[i].hardness + "\n" +
                            "Cleavage:        " + dataApatite[i].cleavage + "\n" + "Density:                " + dataApatite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.5" && msg2 == "Indistinct" && msg3 == "4.7" && msg6 == "Adamantine" && msg7
                == "White" && msg1 == "Brown") {
                for (i in 0 until dataZircon.size){
                    result1.append(dataZircon[i].name + "\n" + "Color:            " + dataZircon[i].color + "\n" + "Streak:            " + dataZircon[i].streak + "\n"
                            + "Luster:            " + dataZircon[i].luster + "\n" + "Hardness:            " + dataZircon[i].hardness + "\n" +
                            "Cleavage:        " + dataZircon[i].cleavage + "\n" + "Density:                " + dataZircon[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "1.5" && msg2 == "Basal" && msg3 == "0.9" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Silver") {
                for (i in 0 until dataVermiculite.size){
                    result1.append(dataVermiculite[i].name + "\n" + "Color:            " + dataVermiculite[i].color + "\n" + "Streak:            " + dataVermiculite[i].streak + "\n"
                            + "Luster:            " + dataVermiculite[i].luster + "\n" + "Hardness:            " + dataVermiculite[i].hardness + "\n" +
                            "Cleavage:        " + dataVermiculite[i].cleavage + "\n" + "Density:                " + dataVermiculite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "5.0" && msg2 == "Distinct" && msg3 == "3.0" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "White") {
                for (i in 0 until dataTremolite.size){
                    result1.append(dataTremolite[i].name + "\n" + "Color:            " + dataTremolite[i].color + "\n" + "Streak:            " + dataTremolite[i].streak + "\n"
                            + "Luster:            " + dataTremolite[i].luster + "\n" + "Hardness:            " + dataTremolite[i].hardness + "\n" +
                            "Cleavage:        " + dataTremolite[i].cleavage + "\n" + "Density:                " + dataTremolite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Basal" && msg3 == "4.2" && msg6 == "Adamantine" && msg7
                == "Red" && msg1 == "Black") {
                for (i in 0 until dataRutile.size){
                    result1.append(dataRutile[i].name + "\n" + "Color:            " + dataRutile[i].color + "\n" + "Streak:            " + dataRutile[i].streak + "\n"
                            + "Luster:            " + dataRutile[i].luster + "\n" + "Hardness:            " + dataRutile[i].hardness + "\n" +
                            "Cleavage:        " + dataRutile[i].cleavage + "\n" + "Density:                " + dataRutile[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Distinct" && msg3 == "3.2" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Brown") {
                for (i in 0 until dataSillimanite.size){
                    result1.append(dataSillimanite[i].name + "\n" + "Color:            " + dataSillimanite[i].color + "\n" + "Streak:            " + dataSillimanite[i].streak + "\n"
                            + "Luster:            " + dataSillimanite[i].luster + "\n" + "Hardness:            " + dataSillimanite[i].hardness + "\n" +
                            "Cleavage:        " + dataSillimanite[i].cleavage + "\n" + "Density:                " + dataSillimanite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.0" && msg2 == "None" && msg3 == "2.1" && msg6 == "Resinous" && msg7
                == "Yellow" && msg1 == "Yellow") {
                for (i in 0 until dataSulfur.size){
                    result1.append(dataSulfur[i].name + "\n" + "Color:            " + dataSulfur[i].color + "\n" + "Streak:            " + dataSulfur[i].streak + "\n"
                            + "Luster:            " + dataSulfur[i].luster + "\n" + "Hardness:            " + dataSulfur[i].hardness + "\n" +
                            "Cleavage:        " + dataSulfur[i].cleavage + "\n" + "Density:                " + dataSulfur[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "1.0" && msg2 == "Basal" && msg3 == "2.8" && msg6 == "Pearly" && msg7
                == "White" && msg1 == "White") {
                for (i in 0 until dataTalc.size){
                    result1.append(dataTalc[i].name + "\n" + "Color:            " + dataTalc[i].color + "\n" + "Streak:            " + dataTalc[i].streak + "\n"
                            + "Luster:            " + dataTalc[i].luster + "\n" + "Hardness:            " + dataTalc[i].hardness + "\n" +
                            "Cleavage:        " + dataTalc[i].cleavage + "\n" + "Density:                " + dataTalc[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "5.0" && msg2 == "Distinct" && msg3 == "4.5" && msg6 == "Adamantine" && msg7
                == "White" && msg1 == "Green") {
                for (i in 0 until dataTitanite.size){
                    result1.append(dataTitanite[i].name + "\n" + "Color:            " + dataTitanite[i].color + "\n" + "Streak:            " + dataTitanite[i].streak + "\n"
                            + "Luster:            " + dataTitanite[i].luster + "\n" + "Hardness:            " + dataTitanite[i].hardness + "\n" +
                            "Cleavage:        " + dataTitanite[i].cleavage + "\n" + "Density:                " + dataTitanite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Indistinct" && msg3 == "3.2" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Black") {
                for (i in 0 until dataTourmaline.size){
                    result1.append(dataTourmaline[i].name + "\n" + "Color:            " + dataTourmaline[i].color + "\n" + "Streak:            " + dataTourmaline[i].streak + "\n"
                            + "Luster:            " + dataTourmaline[i].luster + "\n" + "Hardness:            " + dataTourmaline[i].hardness + "\n" +
                            "Cleavage:        " + dataTourmaline[i].cleavage + "\n" + "Density:                " + dataTourmaline[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Distinct" && msg3 == "2.7" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Gray") {
                for (i in 0 until dataPegmatite.size){
                    result1.append(dataPegmatite[i].name + "\n" + "Color:            " + dataPegmatite[i].color + "\n" + "Streak:            " + dataPegmatite[i].streak + "\n"
                            + "Luster:            " + dataPegmatite[i].luster + "\n" + "Hardness:            " + dataPegmatite[i].hardness + "\n" +
                            "Cleavage:        " + dataPegmatite[i].cleavage + "\n" + "Density:                " + dataPegmatite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "5.0" && msg2 == "Basal" && msg3 == "2.3" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Gray") {
                for (i in 0 until dataOrthopyroxene.size){
                    result1.append(dataOrthopyroxene[i].name + "\n" + "Color:            " + dataOrthopyroxene[i].color + "\n" + "Streak:            " + dataOrthopyroxene[i].streak + "\n"
                            + "Luster:            " + dataOrthopyroxene[i].luster + "\n" + "Hardness:            " + dataOrthopyroxene[i].hardness + "\n" +
                            "Cleavage:        " + dataOrthopyroxene[i].cleavage + "\n" + "Density:                " + dataOrthopyroxene[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Distinct" && msg3 == "3.3" && msg6 == "Glassy" && msg7
                == "White" && msg1 == "Green") {
                for (i in 0 until dataOlivine.size){
                    result1.append(dataOlivine[i].name + "\n" + "Color:            " + dataOlivine[i].color + "\n" + "Streak:            " + dataOlivine[i].streak + "\n"
                            + "Luster:            " + dataOlivine[i].luster + "\n" + "Hardness:            " + dataOlivine[i].hardness + "\n" +
                            "Cleavage:        " + dataOlivine[i].cleavage + "\n" + "Density:                " + dataOlivine[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "4.0" && msg2 == "None" && msg3 == "8.9" && msg6 == "Metallic" && msg7
                == "Gray" && msg1 == "Silver") {
                for (i in 0 until dataNickel.size){
                    result1.append(dataNickel[i].name + "\n" + "Color:            " + dataNickel[i].color + "\n" + "Streak:            " + dataNickel[i].streak + "\n"
                            + "Luster:            " + dataNickel[i].luster + "\n" + "Hardness:            " + dataNickel[i].hardness + "\n" +
                            "Cleavage:        " + dataNickel[i].cleavage + "\n" + "Density:                " + dataNickel[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Indistinct" && msg3 == "2.5" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Gray") {
                for (i in 0 until dataNepheline.size){
                    result1.append(dataNepheline[i].name + "\n" + "Color:            " + dataNepheline[i].color + "\n" + "Streak:            " + dataNepheline[i].streak + "\n"
                            + "Luster:            " + dataNepheline[i].luster + "\n" + "Hardness:            " + dataNepheline[i].hardness + "\n" +
                            "Cleavage:        " + dataNepheline[i].cleavage + "\n" + "Density:                " + dataNepheline[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.0" && msg2 == "Basal" && msg3 == "2.8" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Silver") {
                for (i in 0 until dataMuscovite.size){
                    result1.append(dataMuscovite[i].name + "\n" + "Color:            " + dataMuscovite[i].color + "\n" + "Streak:            " + dataMuscovite[i].streak + "\n"
                            + "Luster:            " + dataMuscovite[i].luster + "\n" + "Hardness:            " + dataMuscovite[i].hardness + "\n" +
                            "Cleavage:        " + dataMuscovite[i].cleavage + "\n" + "Density:                " + dataMuscovite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Indistinct" && msg3 == "2.6" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Green") {
                for (i in 0 until dataMicrocline.size){
                    result1.append(dataMicrocline[i].name + "\n" + "Color:            " + dataMicrocline[i].color + "\n" + "Streak:            " + dataMicrocline[i].streak + "\n"
                            + "Luster:            " + dataMicrocline[i].luster + "\n" + "Hardness:            " + dataMicrocline[i].hardness + "\n" +
                            "Cleavage:        " + dataMicrocline[i].cleavage + "\n" + "Density:                " + dataMicrocline[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Indistinct" && msg3 == "5.2" && msg6 == "Metallic" && msg7
                == "Black" && msg1 == "Black") {
                for (i in 0 until dataMagnetite.size){
                    result1.append(dataMagnetite[i].name + "\n" + "Color:            " + dataMagnetite[i].color + "\n" + "Streak:            " + dataMagnetite[i].streak + "\n"
                            + "Luster:            " + dataMagnetite[i].luster + "\n" + "Hardness:            " + dataMagnetite[i].hardness + "\n" +
                            "Cleavage:        " + dataMagnetite[i].cleavage + "\n" + "Density:                " + dataMagnetite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Uneven" && msg3 == "3.6" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Blue") {
                for (i in 0 until dataKyanite.size){
                    result1.append(dataKyanite[i].name + "\n" + "Color:            " + dataKyanite[i].color + "\n" + "Streak:            " + dataKyanite[i].streak + "\n"
                            + "Luster:            " + dataKyanite[i].luster + "\n" + "Hardness:            " + dataKyanite[i].hardness + "\n" +
                            "Cleavage:        " + dataKyanite[i].cleavage + "\n" + "Density:                " + dataKyanite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "5.0" && msg2 == "None" && msg3 == "5.3" && msg6 == "Metallic" && msg7
                == "Red" && msg1 == "Black") {
                for (i in 0 until dataHematite.size){
                    result1.append(dataHematite[i].name + "\n" + "Color:            " + dataHematite[i].color + "\n" + "Streak:            " + dataHematite[i].streak + "\n"
                            + "Luster:            " + dataHematite[i].luster + "\n" + "Hardness:            " + dataHematite[i].hardness + "\n" +
                            "Cleavage:        " + dataHematite[i].cleavage + "\n" + "Density:                " + dataHematite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.0" && msg2 == "Cubic" && msg3 == "2.2" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Colorless") {
                for (i in 0 until dataHalite.size){
                    result1.append(dataHalite[i].name + "\n" + "Color:            " + dataHalite[i].color + "\n" + "Streak:            " + dataHalite[i].streak + "\n"
                            + "Luster:            " + dataHalite[i].luster + "\n" + "Hardness:            " + dataHalite[i].hardness + "\n" +
                            "Cleavage:        " + dataHalite[i].cleavage + "\n" + "Density:                " + dataHalite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.0" && msg2 == "Distinct" && msg3 == "2.3" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "White") {
                for (i in 0 until dataGypsum.size){
                    result1.append(dataGypsum[i].name + "\n" + "Color:            " + dataGypsum[i].color + "\n" + "Streak:            " + dataGypsum[i].streak + "\n"
                            + "Luster:            " + dataGypsum[i].luster + "\n" + "Hardness:            " + dataGypsum[i].hardness + "\n" +
                            "Cleavage:        " + dataGypsum[i].cleavage + "\n" + "Density:                " + dataGypsum[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "3.0" && msg2 == "Basal" && msg3 == "2.2" && msg6 == "Metallic" && msg7
                == "Black" && msg1 == "Black") {
                for (i in 0 until dataGraphite.size){
                    result1.append(dataGraphite[i].name + "\n" + "Color:            " + dataGraphite[i].color + "\n" + "Streak:            " + dataGraphite[i].streak + "\n"
                            + "Luster:            " + dataGraphite[i].luster + "\n" + "Hardness:            " + dataGraphite[i].hardness + "\n" +
                            "Cleavage:        " + dataGraphite[i].cleavage + "\n" + "Density:                " + dataGraphite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.5" && msg2 == "None" && msg3 == "19.3" && msg6 == "Metallic" && msg7
                == "Yellow" && msg1 == "Yellow") {
                for (i in 0 until dataGold.size){
                    result1.append(dataGold[i].name + "\n" + "Color:            " + dataGold[i].color + "\n" + "Streak:            " + dataGold[i].streak + "\n"
                            + "Luster:            " + dataGold[i].luster + "\n" + "Hardness:            " + dataGold[i].hardness + "\n" +
                            "Cleavage:        " + dataGold[i].cleavage + "\n" + "Density:                " + dataGold[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "None" && msg3 == "3.5" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Red") {
                for (i in 0 until dataGarnet.size){
                    result1.append(dataGarnet[i].name + "\n" + "Color:            " + dataGarnet[i].color + "\n" + "Streak:            " + dataGarnet[i].streak + "\n"
                            + "Luster:            " + dataGarnet[i].luster + "\n" + "Hardness:            " + dataGarnet[i].hardness + "\n" +
                            "Cleavage:        " + dataGarnet[i].cleavage + "\n" + "Density:                " + dataGarnet[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "4.0" && msg2 == "Octahedral" && msg3 == "3.2" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Purple") {
                for (i in 0 until dataFluorite.size){
                    result1.append(dataFluorite[i].name + "\n" + "Color:            " + dataFluorite[i].color + "\n" + "Streak:            " + dataFluorite[i].streak + "\n"
                            + "Luster:            " + dataFluorite[i].luster + "\n" + "Hardness:            " + dataFluorite[i].hardness + "\n" +
                            "Cleavage:        " + dataFluorite[i].cleavage + "\n" + "Density:                " + dataFluorite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Basal" && msg3 == "3.2" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Green") {
                for (i in 0 until dataEpidote.size){
                    result1.append(dataEpidote[i].name + "\n" + "Color:            " + dataEpidote[i].color + "\n" + "Streak:            " + dataEpidote[i].streak + "\n"
                            + "Luster:            " + dataEpidote[i].luster + "\n" + "Hardness:            " + dataEpidote[i].hardness + "\n" +
                            "Cleavage:        " + dataEpidote[i].cleavage + "\n" + "Density:                " + dataEpidote[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "4.0" && msg2 == "Rhombohedral" && msg3 == "2.9" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "White") {
                for (i in 0 until dataDolomite.size){
                    result1.append(dataDolomite[i].name + "\n" + "Color:            " + dataDolomite[i].color + "\n" + "Streak:            " + dataDolomite[i].streak + "\n"
                            + "Luster:            " + dataDolomite[i].luster + "\n" + "Hardness:            " + dataDolomite[i].hardness + "\n" +
                            "Cleavage:        " + dataDolomite[i].cleavage + "\n" + "Density:                " + dataDolomite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "10.0" && msg2 == "Rhombohedral" && msg3 == "3.5" && msg6 == "Adamantine" && msg7
                == "Colorless" && msg1 == "White") {
                for (i in 0 until dataDiamond.size){
                    result1.append(dataDiamond[i].name + "\n" + "Color:            " + dataDiamond[i].color + "\n" + "Streak:            " + dataDiamond[i].streak + "\n"
                            + "Luster:            " + dataDiamond[i].luster + "\n" + "Hardness:            " + dataDiamond[i].hardness + "\n" +
                            "Cleavage:        " + dataDiamond[i].cleavage + "\n" + "Density:                " + dataDiamond[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "9.0" && msg2 == "None" && msg3 == "3.9" && msg6 == "Adamantine" && msg7
                == "White" && msg1 == "Colorless") {
                for (i in 0 until dataCorundum.size){
                    result1.append(dataCorundum[i].name + "\n" + "Color:            " + dataCorundum[i].color + "\n" + "Streak:            " + dataCorundum[i].streak + "\n"
                            + "Luster:            " + dataCorundum[i].luster + "\n" + "Hardness:            " + dataCorundum[i].hardness + "\n" +
                            "Cleavage:        " + dataCorundum[i].cleavage + "\n" + "Density:                " + dataCorundum[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "7.0" && msg2 == "Indistinct" && msg3 == "2.5" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Brown") {
                for (i in 0 until dataCordierite.size){
                    result1.append(dataCordierite[i].name + "\n" + "Color:            " + dataCordierite[i].color + "\n" + "Streak:            " + dataCordierite[i].streak + "\n"
                            + "Luster:            " + dataCordierite[i].luster + "\n" + "Hardness:            " + dataCordierite[i].hardness + "\n" +
                            "Cleavage:        " + dataCordierite[i].cleavage + "\n" + "Density:                " + dataCordierite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "2.0" && msg2 == "Basal" && msg3 == "2.7" && msg6 == "Vitreous" && msg7
                == "Green" && msg1 == "Green") {
                for (i in 0 until dataChlorite.size){
                    result1.append(dataChlorite[i].name + "\n" + "Color:            " + dataChlorite[i].color + "\n" + "Streak:            " + dataChlorite[i].streak + "\n"
                            + "Luster:            " + dataChlorite[i].luster + "\n" + "Hardness:            " + dataChlorite[i].hardness + "\n" +
                            "Cleavage:        " + dataChlorite[i].cleavage + "\n" + "Density:                " + dataChlorite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "3.0" && msg2 == "Basal" && msg3 == "2.8" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Black") {
                for (i in 0 until dataBiotite.size){
                    result1.append(dataBiotite[i].name + "\n" + "Color:            " + dataBiotite[i].color + "\n" + "Streak:            " + dataBiotite[i].streak + "\n"
                            + "Luster:            " + dataBiotite[i].luster + "\n" + "Hardness:            " + dataBiotite[i].hardness + "\n" +
                            "Cleavage:        " + dataBiotite[i].cleavage + "\n" + "Density:                " + dataBiotite[i].density + "\n" + "\n")
                }
            }
            if (msg4 == "" && msg5 == "6.0" && msg2 == "Basal" && msg3 == "2.6" && msg6 == "Vitreous" && msg7
                == "White" && msg1 == "Green") {
                for (i in 0 until dataAndesine.size){
                    result1.append(dataAndesine[i].name + "\n" + "Color:            " + dataAndesine[i].color + "\n" + "Streak:            " + dataAndesine[i].streak + "\n"
                            + "Luster:            " + dataAndesine[i].luster + "\n" + "Hardness:            " + dataAndesine[i].hardness + "\n" +
                            "Cleavage:        " + dataAndesine[i].cleavage + "\n" + "Density:                " + dataAndesine[i].density + "\n" + "\n")
                }
            }


        }

        onClick()
    }
   /* class ResultAdapter(items : List<String>, ctx : Context) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
        var list = items
        var context = ctx
        class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            val name = v.result_name
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.result_child, parent, false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder?.name?.text = list[position]
        }
    }*/
}
