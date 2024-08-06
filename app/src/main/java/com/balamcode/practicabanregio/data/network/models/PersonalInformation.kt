package com.balamcode.practicabanregio.data.network.models

data class PersonalInformation(
    val content: List<ContentInformation>? = null,
    val pageable: PageableInformation? = null,
    val last: Boolean? = null,
    val totalElements: Int? = null,
    val totalPages: Int? = null,
    val number: Int? = null,
    val sort: SortInformation? = null,
    val size: Int? = null,
    val numberOfElements: Int? = null,
    val first: Boolean? = null,
    val empty: Boolean? = null
)

data class ContentInformation(
    val id: Int? = null,
    val primerNombre: String? = null,
    val segundoNombre: String? = null,
    val apellidoPaterno: String? = null,
    val apellidoMaterno: String? = null,
    val fechaNacimiento: String? = null,
    val correo: String? = null,
    val curp: String? = null,
    val rfc: String? = null,
    val telefono: String? = null,
    val activo: Boolean? = null,
)

data class PageableInformation(
    val sort: SortInformation? = null,
    val offset: Int? = null,
    val pageNumber: Int? = null,
    val pageSize: Int? = null,
    val paged: Boolean? = null,
)

data class SortInformation(
    val sorted: Boolean? = null,
    val unsorted: Boolean? = null,
    val empty: Boolean? = null
)