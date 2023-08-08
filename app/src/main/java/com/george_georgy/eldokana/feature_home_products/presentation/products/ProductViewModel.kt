package com.george_georgy.eldokana.feature_home_products.presentation.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetProductsUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductViewModel(
    private val getProductsUseCase: GetProductsUseCase,

    ) : ViewModel() {

    private val _productState = mutableStateOf(ProductListState())
    val productState: State<ProductListState> = _productState


    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _productState.value = ProductListState(
                        products = result.data ?: emptyList()
                    )

                }

                is Resource.Error -> {
                    _productState.value = ProductListState(
                        error = result.message ?: "An unexpected error occurred"
                    )

                }

                is Resource.Loading -> {
                    _productState.value = ProductListState(
                        isLoading = true
                    )

                }

            }
        }.launchIn(viewModelScope)
    }


}

