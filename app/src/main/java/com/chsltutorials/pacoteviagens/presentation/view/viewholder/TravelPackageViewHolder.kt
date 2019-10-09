package com.chsltutorials.pacoteviagens.presentation.view.viewholder

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.chsltutorials.pacoteviagens.model.entity.TripItem
import com.chsltutorials.pacoteviagens.presentation.view.activity.DetailActivity
import kotlinx.android.synthetic.main.adapter_package_travel.view.*

class TravelPackageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var context : Context? = null

    init {
        context = itemView.context
    }

    fun bind(type : TripItem){
        itemView.tvPackageName.text = type.name

        Glide.with(context!!)
            .load(type.cover!!)
            .into(itemView.ivPackage)

        itemView.tvPrice.text = type.price

        itemView.clPackage.setOnClickListener {
            val intent = Intent(context, DetailActivity()::class.java)
            intent.putExtra("description",type.description)
            intent.putExtra("name",type.name)
            intent.putExtra("price",type.price)
            intent.putExtra("image",type.cover)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
    }


}

