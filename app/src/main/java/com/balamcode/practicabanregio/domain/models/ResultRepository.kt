package com.balamcode.practicabanregio.domain.models

sealed class ResultRepository<T> {

    data class Success<T>(
        val content: T,
        val code: Int? = null,
        val message: String? = null
    ) : ResultRepository<T>()

    data class Fail<T>(
        val message: String? = null,
        val code: Int? = null,
        val solution: String? = null,
        val content: T? = null,
    ) : ResultRepository<T>()

}