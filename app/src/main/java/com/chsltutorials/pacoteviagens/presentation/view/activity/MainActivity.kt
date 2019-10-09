package com.chsltutorials.pacoteviagens.presentation.view.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chsltutorials.pacoteviagens.R
import com.chsltutorials.pacoteviagens.base.BaseActivity
import com.chsltutorials.pacoteviagens.model.entity.TripItem
import com.chsltutorials.pacoteviagens.model.entity.TripPackage
import com.chsltutorials.pacoteviagens.presentation.ITravelContract
import com.chsltutorials.pacoteviagens.presentation.presenter.TravelPackagePresenter
import com.chsltutorials.pacoteviagens.presentation.view.adapter.TravelPackageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.screen_error.*


class MainActivity : BaseActivity<ITravelContract.Presenter>(), ITravelContract.View{

    lateinit var destination: List<TripItem>

    override fun populate(trips: TripPackage) : List<TripItem>  {
        destination = trips.destination
        return destination
    }

    override fun createPresenter() = TravelPackagePresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageRefresh.setOnClickListener { presenter?.fetchPackageList()}
    }


    override fun onResume() {
        super.onResume()
        rootLayout.setOnRefreshListener{
            presenter?.fetchPackageList()
            rootLayout.isRefreshing = false
        }
    }


    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if(isConnected){
            presenter?.fetchPackageList()
        }else {
            showError()
        }
    }

    override fun showSuccess() {
        rvPackagesList.visibility = View.VISIBLE
        includeToolbarTravelPackage.visibility = View.VISIBLE
        includeScreenError.visibility = View.GONE
        includeScreenLoading.visibility = View.GONE

        applicationContext?.let {
            rvPackagesList.layoutManager = LinearLayoutManager(it)
            rvPackagesList.adapter = TravelPackageAdapter(it,destination)
        }
    }

    override fun showError() {
        rvPackagesList.visibility = View.GONE
        includeToolbarTravelPackage.visibility = View.GONE
        includeScreenError.visibility = View.VISIBLE
        includeScreenLoading.visibility = View.GONE
    }

    override fun showLoading() {
        rvPackagesList.visibility = View.GONE
        includeToolbarTravelPackage.visibility = View.GONE
        includeScreenError.visibility = View.GONE
        includeScreenLoading.visibility = View.VISIBLE
    }



}
