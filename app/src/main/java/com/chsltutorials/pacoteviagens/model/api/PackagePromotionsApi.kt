package com.chsltutorials.pacoteviagens.model.api

import com.chsltutorials.pacoteviagens.model.entity.TripPackage
import io.reactivex.Observable
import retrofit2.http.GET

interface PackagePromotionsApi{


    @GET("promotions")
    fun getPromotionsList(): Observable<TripPackage>
}






