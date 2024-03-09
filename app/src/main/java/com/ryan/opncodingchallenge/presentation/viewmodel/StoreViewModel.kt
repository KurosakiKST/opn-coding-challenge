package com.ryan.opncodingchallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryan.opncodingchallenge.domain.usecase.StoreUseCase
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.StoreUIModel
import com.ryan.opncodingchallenge.presentation.view.uiMapper.ProductUIMapper
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

    private val _productState = MutableStateFlow<ViewState<List<ProductUIModel>>>(ViewState.NoData)
    val productState: StateFlow<ViewState<List<ProductUIModel>>> = _productState

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

    fun getProducts() {
        _productState.value = ViewState.Loading
        viewModelScope.launch {
            when (val result = storeUseCase.getProducts()) {
                is AppResult.Failure -> {
                    _productState.value = ViewState.Error(result.error.message.orEmpty())
                }

                is AppResult.Success -> {
                    result.data?.let {
                        val productUIModels =
                            it.map { product -> ProductUIMapper.mapToUiModel(product) }
                        _productState.value = ViewState.Success(productUIModels)
                    }
                }
            }
        }
    }
}