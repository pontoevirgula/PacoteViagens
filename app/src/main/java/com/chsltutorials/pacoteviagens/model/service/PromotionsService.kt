package com.chsltutorials.pacoteviagens.model.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object PromotionsService{

    private var retrofit: Retrofit? = null
    private var URL_BASE = "https://private-d2e72-travelpackage1.apiary-mock.com/"

    fun getRetrofit() : Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build()
        }
        return retrofit!!
    }

}
