package com.balamcode.practicabanregio.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://balamcode.com/Banregio/"
    private const val BASE_URL_BAN = "https://kr-herramienta-evaluaciones-negtal.apps.bro2docp4.banregio.com/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    /**
     * naegacion al detalle
     * ver los atributos
     * agregar los string,tamaños y referencias
     */
}