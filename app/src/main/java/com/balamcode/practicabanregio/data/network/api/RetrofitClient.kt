package com.balamcode.practicabanregio.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://kr-herramienta-evaluaciones-negtal.apps.bro2docp4.banregio.com/"
    private const val BASE_URL_DUMMY = "https://balamcode.com/Banregio/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_DUMMY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}