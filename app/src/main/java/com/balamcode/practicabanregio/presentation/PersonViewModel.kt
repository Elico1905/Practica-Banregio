package com.balamcode.practicabanregio.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balamcode.practicabanregio.domain.models.ClientInformationModel
import com.balamcode.practicabanregio.domain.useCase.GetPersonPersonListResult
import com.balamcode.practicabanregio.domain.useCase.GetPersonPersonListUseCase
import kotlinx.coroutines.launch

class PersonViewModel(
    private val providesGetPersonList: GetPersonPersonListUseCase,
) : ViewModel() {

    private val mutableUiState: MutableLiveData<PersonUIState> = MutableLiveData()
    val uiState: LiveData<PersonUIState>
        get() = mutableUiState
    var client: ClientInformationModel? = null

    fun getPersonList(pageNumber: Int) {
        viewModelScope.launch {
            mutableUiState.postValue(PersonUIState.Loading)
            when (val result = providesGetPersonList.execute(pageNumber)) {
                is GetPersonPersonListResult.Success -> {
                    mutableUiState.postValue(
                        PersonUIState.ShowPersonList(result.information.content)
                    )
                }

                is GetPersonPersonListResult.Fail -> {
                    mutableUiState.postValue(PersonUIState.Fail(result.message))
                }
            }
        }
    }
}