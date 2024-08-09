package com.balamcode.practicabanregio.data.network.api

import com.balamcode.practicabanregio.data.network.models.InformationNetwork
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{page}/CustomAPI.json")
    suspend fun getInformation(@Path("page") page: Int): InformationNetwork
}