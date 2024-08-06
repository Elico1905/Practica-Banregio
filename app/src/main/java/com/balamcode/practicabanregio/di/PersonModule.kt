package com.balamcode.practicabanregio.di

import com.balamcode.practicabanregio.data.network.repositories.PersonRepositoryImp
import com.balamcode.practicabanregio.domain.repositories.PersonRepository
import com.balamcode.practicabanregio.domain.useCase.GetPersonPersonListUseCase
import com.balamcode.practicabanregio.presentation.PersonViewModelFactory

object PersonModule {

    fun providesPersonViewModelFactory(): PersonViewModelFactory {
        return PersonViewModelFactory(
            providesGetPersonPersonListUseCase()
        )
    }

    private fun providesPersonRepository(): PersonRepository {
        return PersonRepositoryImp
    }

    private fun providesGetPersonPersonListUseCase(): GetPersonPersonListUseCase {
        return GetPersonPersonListUseCase(providesPersonRepository())
    }

}