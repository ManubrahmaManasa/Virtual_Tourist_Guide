package com.example.virtual_tourist_guide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.virtual_tourist_guide.R
import com.example.virtual_tourist_guide.dataclasses.MainMenu

class MainMenuAdapter(private var menuList:List<MainMenu>):
    RecyclerView.Adapter<MainMenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_window_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun filterList(filteredList: List<MainMenu>) {
        menuList = filteredList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val MainMenu = menuList[position]
        holder.text.text = MainMenu.text
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val text:TextView = view.findViewById(R.id.text)
    }

}