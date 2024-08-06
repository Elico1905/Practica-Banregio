package com.balamcode.practicabanregio.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.balamcode.practicabanregio.domain.useCase.GetPersonPersonListResult
import com.balamcode.practicabanregio.domain.useCase.GetPersonPersonListUseCase
import kotlinx.coroutines.launch

class PersonViewModel(
    private val providesGetPersonList: GetPersonPersonListUseCase,
) : ViewModel() {

    private val mutableUiState: MutableLiveData<PersonUIState> = MutableLiveData()
    val uiState: LiveData<PersonUIState>
        get() = mutableUiState


    fun getPersonList() {
        mutableUiState.postValue(PersonUIState.Loading)
        viewModelScope.launch {
            when (val result = providesGetPersonList.execute()) {
                is GetPersonPersonListResult.Success -> {
                    mutableUiState.postValue(PersonUIState.ShowPersonList(result.personList))
                }

                is GetPersonPersonListResult.Fail -> {
                    mutableUiState.postValue(PersonUIState.Loading)
                }
            }
        }
    }
}