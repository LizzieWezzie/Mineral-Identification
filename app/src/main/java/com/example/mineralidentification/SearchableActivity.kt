package com.example.mineralidentification

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.mineral_list.*

class SearchableActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mineral_list)


    }
    

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        if (menu != null) {
            (menu.findItem(R.id.menu_search).actionView as SearchView) .apply {
                setSearchableInfo(searchManager.getSearchableInfo(componentName))
                isIconified = false
            }
        }
        return super.onCreateOptionsMenu(menu)
    }
    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        MenuItem menuItem = menu.findItem(R.id.search)
        SearchView searchView = menuIte
        return super.onCreateOptionsMenu(menu)
    }*/
}
