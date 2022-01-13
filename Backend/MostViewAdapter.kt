package com.example.latihanui

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.latihanui.R.layout.*
import java.util.ArrayList

class MostViewAdapter(var mostViewDomains: ArrayList<MostViewedDomain>) :
    RecyclerView.Adapter<MostViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(recycler_views, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTxt.text = mostViewDomains[position].title.toString()
        holder.subTitleTxt.text = mostViewDomains[position].subtitle.toString()
        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            mostViewDomains[position].url, "drawable", holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.removeItem)
    }

    override fun getItemCount(): Int {
        return mostViewDomains.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTxt: TextView
        var subTitleTxt: TextView
        var removeItem: ImageView

        init {
            titleTxt = itemView.findViewById(R.id.titleTxt)
            subTitleTxt = itemView.findViewById(R.id.subTitleTxt)
            removeItem = itemView.findViewById(R.id.img_view)
        }
    }
}