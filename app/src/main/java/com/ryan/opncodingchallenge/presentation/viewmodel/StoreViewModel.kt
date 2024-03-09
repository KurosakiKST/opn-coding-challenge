package com.ryan.opncodingchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryan.opncodingchallenge.domain.usecase.StoreUseCase
import com.ryan.opncodingchallenge.presentation.model.StoreUIModel
import com.ryan.opncodingchallenge.presentation.view.uiMapper.StoreUIMapper
import com.ryan.opncodingchallenge.util.AppResult
import com.ryan.opncodingchallenge.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val storeUseCase: StoreUseCase
) : ViewModel() {
    private val _storeState = MutableStateFlow<ViewState<StoreUIModel>>(ViewState.NoData)
    val storeState: StateFlow<ViewState<StoreUIModel>> = _storeState

    fun getStoreData() {
        _storeState.value = ViewState.Loading
        viewModelScope.launch {
            when (val result = storeUseCase.getStoreData()) {
                is AppResult.Failure -> {
                    _storeState.value = ViewState.Error(result.error.message.orEmpty())
                }

                is AppResult.Success -> {
                    _storeState.value = ViewState.Success(StoreUIMapper.mapToUiModel(result.data))
                }
            }
        }
    }
}