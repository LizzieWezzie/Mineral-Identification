package com.example.mineralidentification.ui.mineral_rock_list

import ResultRocks.*
import ResultRocks.DolomiteResult
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mineralidentification.R
import com.example.mineralidentification.objectClasses.Adapter
import com.example.mineralidentification.objectClasses.Model
import kotlin.collections.ArrayList

class RocksListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.rock_list, container, false)

        val myListView = root.findViewById<ListView>(R.id.listView2)


        val items = ArrayList<Model>()
        items.add(Model("Amphibolite", R.drawable.amphibolite))
        items.add(Model("Andesite", R.drawable.andesite1))
        items.add(Model("Anorthosite", R.drawable.anorthosite))
        items.add(Model("Arkose", R.drawable.arkose))
        items.add(Model("Basalt", R.drawable.basalt1))
        items.add(Model("Breccia", R.drawable.breccia))
        items.add(Model("Carbonatite", R.drawable.carbonatite))
        items.add(Model("Chert", R.drawable.chert))
        items.add(Model("Coal", R.drawable.coal))
        items.add(Model("Conglomerate", R.drawable.conglomerate5))

        items.add(Model("Coquina", R.drawable.coquina))
        items.add(Model("Dacite", R.drawable.dacite))
        items.add(Model("Diatomite", R.drawable.diatomite))
        items.add(Model("Diorite", R.drawable.diorite))
        items.add(Model("Dolomite", R.drawable.dolomite1))
        items.add(Model("Eclogite", R.drawable.eclogite))
        items.add(Model("Epidorite", R.drawable.epidorite))
        items.add(Model("Flint", R.drawable.flint))
        items.add(Model("Gabbro", R.drawable.gabbro2))
        items.add(Model("Geode", R.drawable.geode))


        items.add(Model("Gneiss", R.drawable.gneiss2))
        items.add(Model("Granite", R.drawable.granite1))
        items.add(Model("Granodiorite", R.drawable.granodiolite))
        items.add(Model("Limestone", R.drawable.limestone1))
        items.add(Model("Marble", R.drawable.marble2))
        items.add(Model("Migmatite", R.drawable.migmatite))
        items.add(Model("Monzonite", R.drawable.monzonite))
        items.add(Model("Mudstone", R.drawable.mudstone))
        items.add(Model("Obsidian", R.drawable.obsidian))
        items.add(Model("Peridotite", R.drawable.peridotite))


        items.add(Model("Phyllite", R.drawable.phyllite))
        items.add(Model("Pumice", R.drawable.pumice))
        items.add(Model("Quartzite", R.drawable.quartzite))
        items.add(Model("Rhyolite", R.drawable.rhyolite1))
        items.add(Model("Sandstone", R.drawable.sandstone1))
        items.add(Model("Schist", R.drawable.schist))
        items.add(Model("Scoria", R.drawable.scoria))
        items.add(Model("Shale", R.drawable.shale))
        items.add(Model("Slate", R.drawable.slate1))
        items.add(Model("Syenite", R.drawable.syenite))


        val adapter = activity?.let {Adapter(it, R.layout.activity_searchable, items) }
        myListView.adapter = adapter

        myListView.setOnItemClickListener { adapter, view, i, id ->
            if (i == 0) {
                val intent = Intent(context, AmphiboleResult::class.java)
                startActivity(intent)
            }
            if (i == 1) {
                val intent = Intent(context, AndesiteResult::class.java)
                startActivity(intent)
            }
            if (i == 2) {
                val intent = Intent(context, AnorthResult::class.java)
                startActivity(intent)
            }
            if (i == 3) {
                val intent = Intent(context, ArkoseResult::class.java)
                startActivity(intent)
            }
            if (i == 4) {
                val intent = Intent(context, BasaltResult::class.java)
                startActivity(intent)
            }
            if (i == 5) {
                val intent = Intent(context, BrecciaResult::class.java)
                startActivity(intent)
            }
            if (i == 6) {
                val intent = Intent(context, CarbonResult::class.java)
                startActivity(intent)
            }
            if (i == 7) {
                val intent = Intent(context, ChertResult::class.java)
                startActivity(intent)
            }
            if (i == 8) {
                val intent = Intent(context, CoalResult::class.java)
                startActivity(intent)
            }
            if (i == 9) {
                val intent = Intent(context, CongloResult::class.java)
                startActivity(intent)
            }
            if (i == 10) {
                val intent = Intent(context, CoquinaResult::class.java)
                startActivity(intent)
            }
            if (i == 11) {
                val intent = Intent(context, DaciteResult::class.java)
                startActivity(intent)
            }
            if (i == 12) {
                val intent = Intent(context, DiatoResult::class.java)
                startActivity(intent)
            }
            if (i == 13) {
                val intent = Intent(context, DioriteResult::class.java)
                startActivity(intent)
            }
            if (i == 14) {
                val intent = Intent(context, DolomiteResult::class.java)
                startActivity(intent)
            }
            if (i == 15) {
                val intent = Intent(context, EclogiteResult::class.java)
                startActivity(intent)
            }
            if (i == 16) {
                val intent = Intent(context, EpidoriteResult::class.java)
                startActivity(intent)
            }
            if (i == 17) {
                val intent = Intent(context, FlintResult::class.java)
                startActivity(intent)
            }
            if (i == 18) {
                val intent = Intent(context, GabbroResult::class.java)
                startActivity(intent)
            }
            if (i == 19) {
                val intent = Intent(context, GeodeResult::class.java)
                startActivity(intent)
            }
            if (i == 20) {
                val intent = Intent(context, GneissResult::class.java)
                startActivity(intent)
            }
            if (i == 21) {
                val intent = Intent(context, GraniteResult::class.java)
                startActivity(intent)
            }
            if (i == 22) {
                val intent = Intent(context, GranodResult::class.java)
                startActivity(intent)
            }
            if (i == 23) {
                val intent = Intent(context, LimestoneResult::class.java)
                startActivity(intent)
            }
            if (i == 24) {
                val intent = Intent(context, MarbleResult::class.java)
                startActivity(intent)
            }
            if (i == 25) {
                val intent = Intent(context, MigmaResult::class.java)
                startActivity(intent)
            }
            if (i == 26) {
                val intent = Intent(context, MonzoniteResult::class.java)
                startActivity(intent)
            }
            if (i == 27) {
                val intent = Intent(context, MudstoneResult::class.java)
                startActivity(intent)
            }
            if (i == 28) {
                val intent = Intent(context, ObsidianResult::class.java)
                startActivity(intent)
            }
            if (i == 29) {
                val intent = Intent(context, PeridoResult::class.java)
                startActivity(intent)
            }
            if (i == 30) {
                val intent = Intent(context, PhylliteResult::class.java)
                startActivity(intent)
            }
            if (i == 31) {
                val intent = Intent(context, PumiceResult::class.java)
                startActivity(intent)
            }
            if (i == 32) {
                val intent = Intent(context, QuartziteResult::class.java)
                startActivity(intent)
            }
            if (i == 33) {
                val intent = Intent(context, RhyoliteResult::class.java)
                startActivity(intent)
            }
            if (i == 34) {
                val intent = Intent(context, SandstoneResult::class.java)
                startActivity(intent)
            }
            if (i == 35) {
                val intent = Intent(context, SchistResult::class.java)
                startActivity(intent)
            }
            if (i == 36) {
                val intent = Intent(context, ScoriaResult::class.java)
                startActivity(intent)
            }
            if (i == 37) {
                val intent = Intent(context, ShaleResult::class.java)
                startActivity(intent)
            }
            if (i == 38) {
                val intent = Intent(context, SlateResult::class.java)
                startActivity(intent)
            }
            if (i == 39) {
                val intent = Intent(context, SyeniteResult::class.java)
                startActivity(intent)
            }
        }

        val search = root.findViewById<SearchView>(R.id.searchView2)
        search.queryHint = "Search a Rock"
        search.isSubmitButtonEnabled = true
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                /*search.clearFocus()
                if (items.contains(query)) {
                    adapter?.filter?.filter(query)
                }
                else
                    Toast.makeText(activity, "Item not found", Toast.LENGTH_SHORT).show()*/
                //adapter?.filter?.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //!!.toLowerCase(Locale.getDefault())
                //adapter?.filter?.filter(searchTexts)
                if (TextUtils.isEmpty(newText)) {
                    adapter?.filter?.filter("")
                    myListView.clearTextFilter()
                }
                else
                    adapter?.filter?.filter(newText)



                return true
            }

        })
        return root

    }
}