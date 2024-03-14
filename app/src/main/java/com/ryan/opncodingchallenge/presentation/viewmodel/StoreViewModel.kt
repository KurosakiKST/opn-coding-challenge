package com.ryan.opncodingchallenge.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryan.opncodingchallenge.domain.model.ProductDomainModel
import com.ryan.opncodingchallenge.domain.usecase.StoreUseCase
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.SelectedProduct
import com.ryan.opncodingchallenge.presentation.model.StoreUIModel
import com.ryan.opncodingchallenge.presentation.view.uiMapper.ProductUIMapper
import com.ryan.opncodingchallenge.presentation.view.uiMapper.StoreUIMapper
import com.ryan.opncodingchallenge.util.AppResult
import com.ryan.opncodingchallenge.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    private val _productState =
        MutableStateFlow<ViewState<List<ProductUIModel>>>(ViewState.NoData)
    val productState: StateFlow<ViewState<List<ProductUIModel>>> = _productState

    private val _selectedProducts = mutableStateOf<List<SelectedProduct>>(emptyList())
    val selectedProducts: State<List<SelectedProduct>> = _selectedProducts

    private val _totalAmount = mutableStateOf(0)
    val totalAmount: State<Int> = _totalAmount

    fun calculateTotalAmount(products: List<SelectedProduct>): Int {
        return products.sumBy { it.product.price!!.toInt() * it.quantity }
    }

    fun updateTotalAmount(products: List<SelectedProduct>) {
        _totalAmount.value = calculateTotalAmount(products)
    }

    fun setSelectedProducts(products: List<SelectedProduct>) {
        _selectedProducts.value = products
        Log.i("basket", "ViewModel : $_selectedProducts")
    }

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
