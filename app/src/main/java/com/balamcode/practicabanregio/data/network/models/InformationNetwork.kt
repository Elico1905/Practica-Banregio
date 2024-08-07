package com.balamcode.practicabanregio.data.network.models

import com.google.gson.annotations.SerializedName

data class InformationNetwork(
    val content: List<ClientInformationNetwork>? = null,
    val pageable: PageableNetwork? = null,
    val last: Boolean? = null,
    val totalElements: Int? = null,
    val totalPages: Int? = null,
    val number: Int? = null,
    val sort: SortNetwork? = null,
    val size: Int? = null,
    val numberOfElements: Int? = null,
    val first: Boolean? = null,
    val empty: Boolean? = null
)

data class ClientInformationNetwork(
    val id: Int? = null,
    @SerializedName("primerNombre") val firstName: String? = null,
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

data class PageableNetwork(
    val sort: SortNetwork? = null,
    val offset: Int? = null,
    val pageNumber: Int? = null,
    val pageSize: Int? = null,
    val paged: Boolean? = null,
)

data class SortNetwork(
    val sorted: Boolean? = null,
    val unsorted: Boolean? = null,
    val empty: Boolean? = null
)