package com.chsltutorials.pacoteviagens.presentation

import com.chsltutorials.pacoteviagens.base.IBaseContract
import com.chsltutorials.pacoteviagens.model.entity.TripItem
import com.chsltutorials.pacoteviagens.model.entity.TripPackage

interface ITravelContract {

    interface View : IBaseContract.View<ITravelContract.Presenter>{
        fun populate(trips: TripPackage) : List<TripItem>
        fun showSuccess()
        fun showError()
        fun showLoading()
    }

    interface Presenter : IBaseContract.Presenter{
        fun fetchPackageList()
    }
}
