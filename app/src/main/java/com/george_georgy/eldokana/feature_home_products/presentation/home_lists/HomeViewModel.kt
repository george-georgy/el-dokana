package com.george_georgy.eldokana.feature_home_products.presentation.home_lists

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetCategoriesUseCase
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetProductsUseCase

import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductsUseCase: GetProductsUseCase,


    ) : ViewModel() {


    private var _categoriesState = mutableStateOf(emptyList<String>())
    val categoriesState: State<List<String>> = _categoriesState

    private var _selectedCategory = mutableStateOf("All")
    val selectedCategory: State<String> = _selectedCategory

    private var _productState = mutableStateOf(ProductListState())
    val productState: State<ProductListState> = _productState

    init {
        getCategories()
        getProducts(_selectedCategory.value)

    }

    private fun getCategories() {
        viewModelScope.launch {
            _categoriesState.value = getCategoriesUseCase()
        }
    }


    fun onHomeEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.CategoryChanged -> {
                _selectedCategory.value = event.category
                getProducts(_selectedCategory.value)

            }
        }
    }



    private fun getProducts(category : String) {
        viewModelScope.launch {
            getProductsUseCase().collect{ result ->
                when (result) {
                    is Resource.Success -> {

                        if (category != "All") {
                            _productState.value = _productState.value.copy(
                                products = result.data?.filter { it.category == category }
                                    ?: emptyList(),
                                isLoading = false

                            )
                        } else {
                            _productState.value = _productState.value.copy(
                                products = result.data ?: emptyList(),
                                isLoading = false


                            )
                       }
                    }

                    is Resource.Error -> {
                        _productState.value = _productState.value.copy(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _productState.value = _productState.value.copy(
                            products = emptyList(),
                            isLoading = true
                        )
                    }

                }
            }
        }
    }
}

