package com.chsltutorials.pacoteviagens.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chsltutorials.pacoteviagens.R
import com.chsltutorials.pacoteviagens.model.entity.TripItem
import com.chsltutorials.pacoteviagens.presentation.view.viewholder.TravelPackageViewHolder


class TravelPackageAdapter(private var context: Context, val packageList: List<TripItem>)
                                : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val packages = packageList[position]
        (holder as TravelPackageViewHolder).bind(packages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TravelPackageViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_package_travel, parent,false))
    }

    override fun getItemCount() = packageList.size






}


