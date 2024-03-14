package com.ryan.opncodingchallenge

import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.domain.usecase.StoreUseCase
import com.ryan.opncodingchallenge.presentation.model.ProductUIModel
import com.ryan.opncodingchallenge.presentation.model.SelectedProduct
import com.ryan.opncodingchallenge.presentation.view.uiMapper.StoreUIMapper
import com.ryan.opncodingchallenge.presentation.viewmodel.StoreViewModel
import com.ryan.opncodingchallenge.util.AppResult
import com.ryan.opncodingchallenge.util.ViewState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class StoreViewModelTest {

    @Mock
    lateinit var storeUseCase: StoreUseCase

    private lateinit var viewModel: StoreViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = StoreViewModel(storeUseCase)
    }

    @Test
    fun `test calculateTotalAmount`() {
        val selectedProducts = listOf(
            SelectedProduct(ProductUIModel("Product A", 10, "url"), 2),
            SelectedProduct(ProductUIModel("Product B", 20, "url"), 3)
        )
        val expectedTotalAmount = 10 * 2 + 20 * 3
        val actualTotalAmount = viewModel.calculateTotalAmount(selectedProducts)
        assertEquals(expectedTotalAmount, actualTotalAmount)
    }

    @Test
    fun `test updateTotalAmount`() {
        val selectedProducts = listOf(
            SelectedProduct(ProductUIModel("Product A", 10, "url"), 2),
            SelectedProduct(ProductUIModel("Product B", 20, "url"), 3)
        )
        val expectedTotalAmount = 10 * 2 + 20 * 3
        viewModel.updateTotalAmount(selectedProducts)
        assertEquals(expectedTotalAmount, viewModel.totalAmount.value)
    }

    @Test
    fun `test getStoreData`() = runBlocking {
        val storeDomainModel = StoreDomainModel(
            storeName = "Mock Store",
            rating = 4.5,
            openingTime = "3AM",
            closingTime = "4PM"
        )
        `when`(storeUseCase.getStoreData()).thenReturn(AppResult.Success(storeDomainModel))

        viewModel.getStoreData()

        assertEquals(
            ViewState.Success(StoreUIMapper.mapToUiModel(storeDomainModel)),
            viewModel.storeState.value
        )
    }
}
