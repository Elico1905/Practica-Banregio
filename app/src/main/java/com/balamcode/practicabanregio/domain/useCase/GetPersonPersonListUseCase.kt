package com.balamcode.practicabanregio.domain.useCase

import com.balamcode.practicabanregio.domain.models.InformationModel
import com.balamcode.practicabanregio.domain.models.ResultRepository
import com.balamcode.practicabanregio.domain.repositories.PersonRepository

class GetPersonPersonListUseCase(private val repository: PersonRepository) {

    suspend fun execute(page: Int): GetPersonPersonListResult {
        return when (val result = repository.getInformation(page)) {
            is ResultRepository.Success -> {
                GetPersonPersonListResult.Success(result.content)
            }

            is ResultRepository.Fail -> {
                GetPersonPersonListResult.Fail(result.message)
            }
        }
    }
}

sealed class GetPersonPersonListResult {
    data class Success(val information: InformationModel) : GetPersonPersonListResult()
    data class Fail(val message: String?) : GetPersonPersonListResult()
}