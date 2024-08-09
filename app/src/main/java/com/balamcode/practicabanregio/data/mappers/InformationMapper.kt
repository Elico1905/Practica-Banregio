package com.balamcode.practicabanregio.data.mappers

import com.balamcode.practicabanregio.data.network.models.ClientInformationNetwork
import com.balamcode.practicabanregio.data.network.models.InformationNetwork
import com.balamcode.practicabanregio.data.network.models.PageableNetwork
import com.balamcode.practicabanregio.data.network.models.SortNetwork
import com.balamcode.practicabanregio.domain.models.ClientInformationModel
import com.balamcode.practicabanregio.domain.models.InformationModel
import com.balamcode.practicabanregio.domain.models.PageableModel
import com.balamcode.practicabanregio.domain.models.SortModel

fun InformationNetwork.toDomain(): InformationModel {
    return InformationModel(
        content = this.content?.map { it.toDomain() } ?: emptyList(),
        pageable = this.pageable?.toDomain() ?: PageableModel(
            sort = SortModel(sorted = false, unsorted = false, empty = false),
            offset = 0,
            pageNumber = 0,
            pageSize = 0,
            paged = false
        ),
        last = this.last ?: false,
        totalElements = this.totalElements ?: 0,
        totalPages = this.totalPages ?: 0,
        number = this.number ?: 0,
        sort = this.sort?.toDomain() ?: SortModel(sorted = false, unsorted = false, empty = false),
        size = this.size ?: 0,
        numberOfElements = this.numberOfElements ?: 0,
        first = this.first ?: false,
        empty = this.empty ?: false
    )
}

fun ClientInformationNetwork.toDomain(): ClientInformationModel {
    return ClientInformationModel(
        id = this.id ?: 0,
        firstName = this.firstName ?: "",
        secondName = this.segundoNombre ?: "",
        paternalSurname = this.apellidoPaterno ?: "",
        maternalSurname = this.apellidoMaterno ?: "",
        birthdate = this.fechaNacimiento ?: "",
        email = this.correo ?: "",
        curp = this.curp ?: "",
        rfc = this.rfc ?: "",
        numberPhone = this.telefono ?: "",
        isActive = this.activo ?: false
    )
}

fun PageableNetwork.toDomain(): PageableModel {
    return PageableModel(
        sort = this.sort?.toDomain() ?: SortModel(sorted = false, unsorted = false, empty = false),
        offset = this.offset ?: 0,
        pageNumber = this.pageNumber ?: 0,
        pageSize = this.pageSize ?: 0,
        paged = this.paged ?: false
    )
}

fun SortNetwork.toDomain(): SortModel {
    return SortModel(
        sorted = this.sorted ?: false,
        unsorted = this.unsorted ?: false,
        empty = this.empty ?: false
    )
}