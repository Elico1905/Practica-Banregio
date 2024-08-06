package com.balamcode.practicabanregio.domain.models

data class PersonModel(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val paternalSurname: String,
    val maternalSurname: String,
    val birthdate: String,
    val email: String,
    val curp: String,
    val rfc: String,
    val numberPhone: String,
    val isActive: Boolean
)
