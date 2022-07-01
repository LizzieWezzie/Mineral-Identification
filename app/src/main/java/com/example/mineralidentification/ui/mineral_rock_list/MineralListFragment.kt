package com.example.mineralidentification.ui.mineral_rock_list

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.mineralidentification.R
import com.example.mineralidentification.Results.*
import com.example.mineralidentification.objectClasses.Adapter
import com.example.mineralidentification.objectClasses.Model
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MineralListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.mineral_list, container, false)

        val myListView = root.findViewById<ListView>(R.id.listView)

        val items = ArrayList<Model>()
        items.add(Model("Andesine", R.drawable.andesine))
        items.add(Model("Apatite", R.drawable.apatite))
        items.add(Model("Bauxite", R.drawable.bauxite2))
        items.add(Model("Biotite", R.drawable.biotite))
        items.add(Model("Calcite", R.drawable.calcite1))
        items.add(Model("Chlorite", R.drawable.chlori))
        items.add(Model("Cordierite", R.drawable.cordierite))
        items.add(Model("Corundum", R.drawable.corundum))
        items.add(Model("Diamond", R.drawable.diamond5))
        items.add(Model("Dolomite", R.drawable.dolomite1))


        items.add(Model("Epidote", R.drawable.epidote))
        items.add(Model("Fluorite", R.drawable.fluorite))
        items.add(Model("Garnet", R.drawable.garnet))
        items.add(Model("Gold", R.drawable.gold5))
        items.add(Model("Graphite", R.drawable.graphite2))
        items.add(Model("Gypsum", R.drawable.gypsum))
        items.add(Model("Halite", R.drawable.halite5))
        items.add(Model("Hematite", R.drawable.hematite2))
        items.add(Model("Kyanite", R.drawable.kyanite))
        items.add(Model("Magnetite", R.drawable.magnetite1))


        items.add(Model("Microcline", R.drawable.microcline))
        items.add(Model("Monazite", R.drawable.monazite))
        items.add(Model("Muscovite", R.drawable.muscovite))
        items.add(Model("Nepheline", R.drawable.nepheline))
        items.add(Model("Nickel", R.drawable.nickel2))
        items.add(Model("Olivine", R.drawable.olivine))
        items.add(Model("Orthopyroxene", R.drawable.orthopyroxene))
        items.add(Model("Pegmatite", R.drawable.pegmatite))
        items.add(Model("Pyrite", R.drawable.pyrite2))
        items.add(Model("Quartz", R.drawable.quartz))
        items.add(Model("Rutile", R.drawable.rutile))


        items.add(Model("Sillimanite", R.drawable.silimanite))
        items.add(Model("Sulfur", R.drawable.sulfur5))
        items.add(Model("Talc", R.drawable.talc2))
        items.add(Model("Titanite", R.drawable.titanite))
        items.add(Model("Tourmaline", R.drawable.tourmaline))
        items.add(Model("Tremolite", R.drawable.tremolite))
        items.add(Model("Uranium", R.drawable.urani))
        items.add(Model("Vermiculite", R.drawable.vermiculite))
        items.add(Model("Zircon", R.drawable.zircon))

        /*val image = ArrayList<Int>()
        image.add(R.drawable.andesine)
        image.add(R.drawable.apatite)
        image.add(R.drawable.bauxite2)
        image.add(R.drawable.biotite)
        image.add(R.drawable.calcite1)
        image.add(R.drawable.chlori)
        image.add(R.drawable.cordierite)
        image.add(R.drawable.corundum)
        image.add(R.drawable.diamond5)

        val name = ArrayList<String>()
        name.add("Andesine")
        name.add("Apatite")
        name.add("Bauxite")
        name.add("Biotite")
        name.add("Calcite")
        name.add("Chlorite")
        name.add("Cordierite")
        name.add("Corundum")
        name.add("Diamond")*/

        val info = ArrayList<HashMap<String, String>>()
        /*var hashmap: HashMap<String, String> = HashMap<String, String>()
        for (element in name) {
            hashmap = HashMap<String, String>()
            hashmap["name"] = element

            info.add(hashmap)
        }*/

        val adapter = activity?.let { Adapter(it, R.layout.activity_searchable, items) }
        myListView.adapter = adapter

        myListView.setOnItemClickListener { adapter, view, i, id ->
            if (i == 0) {
                val intent = Intent(context, AndesineResult::class.java)
                startActivity(intent)
            }
            if (i == 1) {
                val intent = Intent(context, ApatiteResult::class.java)
                startActivity(intent)
            }
            if (i == 2) {
                val intent = Intent(context, BauxiteResult::class.java)
                startActivity(intent)
            }
            if (i == 3) {
                val intent = Intent(context, BiotiteResult::class.java)
                startActivity(intent)
            }
            if (i == 4) {
                val intent = Intent(context, CalciteResult::class.java)
                startActivity(intent)
            }
            if (i == 5) {
                val intent = Intent(context, ChloriteResult::class.java)
                startActivity(intent)
            }
            if (i == 6) {
                val intent = Intent(context, CordierResult::class.java)
                startActivity(intent)
            }
            if (i == 7) {
                val intent = Intent(context, CorundumResult::class.java)
                startActivity(intent)
            }
            if (i == 8) {
                val intent = Intent(context, DiamndResult::class.java)
                startActivity(intent)
            }
            if (i == 9) {
                val intent = Intent(context, DolomiteResult::class.java)
                startActivity(intent)
            }
            if (i == 10) {
                val intent = Intent(context, EpidoteResult::class.java)
                startActivity(intent)
            }
            if (i == 11) {
                val intent = Intent(context, FluoriteResult::class.java)
                startActivity(intent)
            }
            if (i == 12) {
                val intent = Intent(context, GarnetResult::class.java)
                startActivity(intent)
            }
            if (i == 13) {
                val intent = Intent(context, GoldResult::class.java)
                startActivity(intent)
            }
            if (i == 14) {
                val intent = Intent(context, GraphiteResult::class.java)
                startActivity(intent)
            }
            if (i == 15) {
                val intent = Intent(context, GypsumResult::class.java)
                startActivity(intent)
            }
            if (i == 16) {
                val intent = Intent(context, HaliteResult::class.java)
                startActivity(intent)
            }
            if (i == 17) {
                val intent = Intent(context, HematiteResult::class.java)
                startActivity(intent)
            }
            if (i == 18) {
                val intent = Intent(context, KyaniteResult::class.java)
                startActivity(intent)
            }
            if (i == 19) {
                val intent = Intent(context, MagnetiteResult::class.java)
                startActivity(intent)
            }
            if (i == 20) {
                val intent = Intent(context, MicroclineResult::class.java)
                startActivity(intent)
            }
            if (i == 21) {
                val intent = Intent(context, MonaziteResult::class.java)
                startActivity(intent)
            }
            if (i == 22) {
                val intent = Intent(context, MuscoviteResult::class.java)
                startActivity(intent)
            }
            if (i == 23) {
                val intent = Intent(context, NephelineResult::class.java)
                startActivity(intent)
            }
            if (i == 24) {
                val intent = Intent(context, NickelResult::class.java)
                startActivity(intent)
            }
            if (i == 25) {
                val intent = Intent(context, OlivineResult::class.java)
                startActivity(intent)
            }
            if (i == 26) {
                val intent = Intent(context, OrthoResult::class.java)
                startActivity(intent)
            }
            if (i == 27) {
                val intent = Intent(context, PegmatiteResult::class.java)
                startActivity(intent)
            }
            if (i == 28) {
                val intent = Intent(context, PyriteResult::class.java)
                startActivity(intent)
            }
            if (i == 29) {
                val intent = Intent(context, Results::class.java)
                startActivity(intent)
            }
            if (i == 30) {
                val intent = Intent(context, RutileResult::class.java)
                startActivity(intent)
            }
            if (i == 31) {
                val intent = Intent(context, SillimaResult::class.java)
                startActivity(intent)
            }
            if (i == 32) {
                val intent = Intent(context, SulfurResult::class.java)
                startActivity(intent)
            }
            if (i == 33) {
                val intent = Intent(context, TalcResult::class.java)
                startActivity(intent)
            }
            if (i == 34) {
                val intent = Intent(context, TitaniteResult::class.java)
                startActivity(intent)
            }
            if (i == 35) {
                val intent = Intent(context, TourmaResult::class.java)
                startActivity(intent)
            }
            if (i == 36) {
                val intent = Intent(context, TremoResult::class.java)
                startActivity(intent)
            }
            if (i == 37) {
                val intent = Intent(context, UraniumResult::class.java)
                startActivity(intent)
            }
            if (i == 38) {
                val intent = Intent(context, VermiResult::class.java)
                startActivity(intent)
            }
            if (i == 39) {
                val intent = Intent(context, ZirconResult::class.java)
                startActivity(intent)
            }

        }

        val mineralNames = arrayOf("Andesine", "Apatite", "Bauxite", "Biotite", "Calcite", "Chlorite", "Cordierite", "Corundum", "Diamond")
        val search = root.findViewById<SearchView>(R.id.searchView)
        search.queryHint = "Search a Mineral"
        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchTexts = newText!!.toLowerCase(Locale.getDefault())
               adapter?.filter?.filter(searchTexts)

                return false
            }

        })
        //adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.minerals)) }!!
        //listView.adapter = adapter
        //listView.emptyView = emptyTextView

        return root
    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val search : MenuItem? = menu.findItem(R.id.menu_search)
        val searchView : SearchView = search?.actionView as SearchView
        searchView.queryHint = "Search a Mineral"
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateOptionsMenu(inflater: MenuInflater, menu: Menu?): Boolean {
        inflater.inflate(R.menu.nav_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        if (menu != null) {
            (menu.findItem(R.id.menu_search).actionView as SearchView) .apply {
                setSearchableInfo(searchManager.getSearchableInfo(componentName))
                isIconified = false
            }
        }
        return super.onCreateOptionsMenu(menu)
    }*/
}
