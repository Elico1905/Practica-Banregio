package com.balamcode.practicabanregio.domain.useCase

import com.balamcode.practicabanregio.domain.models.PersonModel
import com.balamcode.practicabanregio.domain.models.ResultRepository
import com.balamcode.practicabanregio.domain.repositories.PersonRepository

class GetPersonPersonListUseCase(private val repository: PersonRepository) {

    suspend fun execute(): GetPersonPersonListResult {
        return when (val result = repository.getPersonList()) {
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
    data class Success(val personList: List<PersonModel>) : GetPersonPersonListResult()
    data class Fail(val message: String?) : GetPersonPersonListResult()
}