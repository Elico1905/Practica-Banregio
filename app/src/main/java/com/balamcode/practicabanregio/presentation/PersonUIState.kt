package com.balamcode.practicabanregio.presentation

import com.balamcode.practicabanregio.domain.models.PersonModel

sealed class PersonUIState {
    object Loading : PersonUIState()
    data class Fail(val message: String?) : PersonUIState()
    data class ShowPersonList(val list: List<PersonModel>) : PersonUIState()
}