package com.example.latihanui

import android.view.LayoutInflater
import android.view.ViewGroup
import  androidx.recyclerview.widget.RecyclerView;

class adapter (private val data: ArrayList<item>): RecyclerView.Adapter<viewholder>(){
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val inflater = LayoutInflater.from(parent.context)
        return viewholder(inflater, parent)
    }
}