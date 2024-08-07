package com.balamcode.practicabanregio.domain.models

data class InformationModel(
    val content: List<ClientInformationModel>,
    val pageable: PageableModel,
    val last: Boolean,
    val totalElements: Int,
    val totalPages: Int,
    val number: Int,
    val sort: SortModel,
    val size: Int,
    val numberOfElements: Int,
    val first: Boolean,
    val empty: Boolean
)

data class ClientInformationModel(
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

data class PageableModel(
    val sort: SortModel,
    val offset: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
)

data class SortModel(
    val sorted: Boolean,
    val unsorted: Boolean,
    val empty: Boolean
)
