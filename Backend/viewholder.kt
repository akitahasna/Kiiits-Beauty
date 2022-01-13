package com.example.latihanui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class viewholder (inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_views, parent, false)){

    private var list: TextView? = null
    init {
        list=itemView.findViewById(R.id.list)
    }
    fun bind(data:item){
        list?.text=data.list
    }
}
