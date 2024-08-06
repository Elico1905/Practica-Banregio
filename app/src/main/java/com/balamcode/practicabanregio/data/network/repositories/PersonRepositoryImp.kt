package com.balamcode.practicabanregio.data.network.repositories

import android.util.Log
import com.balamcode.practicabanregio.data.network.api.RetrofitClient.apiService
import com.balamcode.practicabanregio.domain.models.PersonModel
import com.balamcode.practicabanregio.domain.models.ResultRepository
import com.balamcode.practicabanregio.domain.repositories.PersonRepository

object PersonRepositoryImp : PersonRepository {

    override suspend fun getPersonList(): ResultRepository<List<PersonModel>> {
        try {
            apiService.getPersonalListV2(0)
        }catch (e:Exception){
            Log.d("Documento",e.message.toString())//esto es un commit
        }

        val list = listOf(
            PersonModel(
                id = 0,
                firstName = "ARTURO",
                secondName = "ARTURO",
                paternalSurname = "MARTINEZ",
                maternalSurname = "GONZALEZ",
                birthdate = "2024-06-20T00:00:00.000",
                email = "CORREO@MAIL.COM",
                curp = "PIHO900116HASRYL05",
                rfc = "PIHO900116I13",
                numberPhone = "5YYYYY",
                isActive = true
            )
        )
        return ResultRepository.Success(list)
    }
}