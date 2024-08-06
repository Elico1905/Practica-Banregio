package com.balamcode.practicabanregio.domain.repositories

import com.balamcode.practicabanregio.domain.models.PersonModel
import com.balamcode.practicabanregio.domain.models.ResultRepository

interface PersonRepository {
    suspend fun getPersonList(): ResultRepository<List<PersonModel>>
}