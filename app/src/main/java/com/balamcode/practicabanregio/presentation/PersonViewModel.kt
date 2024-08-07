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

    private var pageNumber: Int = 0
    private var isLastPage: Boolean = false

    fun getPersonList() {
        if (!isLastPage) {
            mutableUiState.postValue(PersonUIState.Loading)
            viewModelScope.launch {
                when (val result = providesGetPersonList.execute(pageNumber)) {
                    is GetPersonPersonListResult.Success -> {
                        pageNumber = result.information.pageable.pageNumber + 1
                        isLastPage = result.information.last
                        mutableUiState.postValue(PersonUIState.ShowPersonList(result.information.content))
                    }

                    is GetPersonPersonListResult.Fail -> {
                        mutableUiState.postValue(PersonUIState.Fail(result.message))
                    }
                }
            }
        }
    }
}