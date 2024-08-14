package com.balamcode.practicabanregio.data.network.api

import com.balamcode.practicabanregio.data.network.models.InformationNetwork
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("persona")
    suspend fun getInformation(@Query("page") page: Int): InformationNetwork

    @GET("{page}/CustomAPI.json")
    suspend fun getInformationV2(@Path("page") page: Int): InformationNetwork
}