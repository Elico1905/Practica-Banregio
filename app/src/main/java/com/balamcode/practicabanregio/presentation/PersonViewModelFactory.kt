package com.balamcode.practicabanregio.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.balamcode.practicabanregio.domain.useCase.GetPersonPersonListUseCase

@Suppress("UNCHECKED_CAST")
class PersonViewModelFactory(
    private val getPersonList: GetPersonPersonListUseCase,
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            return PersonViewModel(
                getPersonList
            ) as T
        }
        throw IllegalArgumentException("Error")
    }

}