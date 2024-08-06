package com.balamcode.practicabanregio.data.network.api

import com.balamcode.practicabanregio.domain.models.PersonModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /*@GET("persona?page={page}")
    suspend fun getPersonalList(@Path("page") page: Int): PersonModel*/

    @GET("persona")
    suspend fun getPersonalListV2(@Query("page") page: Int): PersonModel
}