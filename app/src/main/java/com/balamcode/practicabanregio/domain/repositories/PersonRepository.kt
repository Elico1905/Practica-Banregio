package com.balamcode.practicabanregio.domain.repositories

import com.balamcode.practicabanregio.domain.models.InformationModel
import com.balamcode.practicabanregio.domain.models.ResultRepository

interface PersonRepository {
    suspend fun getInformation(page: Int): ResultRepository<InformationModel>
}