package com.chsltutorials.pacoteviagens.presentation.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.chsltutorials.pacoteviagens.R
import kotlinx.android.synthetic.main.activity_travel_package.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_package)


        val desciption = intent.getStringExtra("description")
        tvDescription.text = desciption

        val value  = intent.getStringExtra("price")
        tvValue.text = value

        val name = intent.getStringExtra("name")
        tvLocal.text = name

        val image = intent.getStringExtra("image")
        Glide.with(applicationContext)
            .load(image)
            .into(ivLocal)



    }


}


