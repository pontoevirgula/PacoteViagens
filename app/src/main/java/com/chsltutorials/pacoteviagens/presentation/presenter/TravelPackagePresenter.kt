package com.chsltutorials.pacoteviagens.presentation.presenter

import android.util.Log
import com.chsltutorials.pacoteviagens.base.BasePresenter
import com.chsltutorials.pacoteviagens.model.api.PackagePromotionsApi
import com.chsltutorials.pacoteviagens.model.service.PromotionsService
import com.chsltutorials.pacoteviagens.presentation.ITravelContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TravelPackagePresenter(val view: ITravelContract.View) : BasePresenter(), ITravelContract.Presenter {

    override fun fetchPackageList() {
        val observable = PromotionsService.getRetrofit().create(PackagePromotionsApi::class.java).getPromotionsList()
        view.showLoading()
        val disposable = observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.destination.isNotEmpty()){
                    view.populate(it)
                    view.showSuccess()
                }else {
                    view.showError()
                }
            },
                {
                    view.showError()
                }
            )
        compositeDisposable?.add(disposable)

    }
}