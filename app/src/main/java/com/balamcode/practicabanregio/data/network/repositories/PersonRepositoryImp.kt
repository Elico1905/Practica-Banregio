package com.balamcode.practicabanregio.data.network.repositories

import com.balamcode.practicabanregio.data.mappers.toDomain
import com.balamcode.practicabanregio.data.network.api.RetrofitClient.apiService
import com.balamcode.practicabanregio.domain.models.InformationModel
import com.balamcode.practicabanregio.domain.models.ResultRepository
import com.balamcode.practicabanregio.domain.repositories.PersonRepository

object PersonRepositoryImp : PersonRepository {

    override suspend fun getInformation(page: Int): ResultRepository<InformationModel> {
        return try {
            val service = apiService.getInformation(page)
            val result = service.toDomain()
            ResultRepository.Success(result)
        } catch (e: Exception) {
            ResultRepository.Fail(e.message.toString())
        }
    }
}