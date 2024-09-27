package com.example.virtual_tourist_guide

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.virtual_tourist_guide.adapter.MainMenuAdapter
import com.example.virtual_tourist_guide.databinding.ActivityMainBinding
import com.example.virtual_tourist_guide.dataclasses.MainMenu
import com.example.virtual_tourist_guide.viewmodels.SplashViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    val data = ArrayList<MainMenu>()
    var adapter:MainMenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filteration(newText?:"")
                return true
            }
        })


        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        data.add(MainMenu("Temples"))
        data.add(MainMenu("Restaurants"))
        data.add(MainMenu("Hotels"))
        data.add(MainMenu("Beaches"))
        data.add(MainMenu("Cafes"))
        data.add(MainMenu("Parks"))
        data.add(MainMenu("Resorts"))

        adapter = MainMenuAdapter(data)

        updateRecylerview(adapter!!)

    }

    private fun filteration(s: String) {
        val filter_menu = mutableListOf(MainMenu(s))
        for(singleMenu in data){
            if(singleMenu.text.lowercase().contains(s.lowercase())){
                filter_menu.add(singleMenu)
            }
        }
        adapter?.filterList(filter_menu)
    }

    private fun updateRecylerview(adapter:MainMenuAdapter) {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = adapter
    }
}