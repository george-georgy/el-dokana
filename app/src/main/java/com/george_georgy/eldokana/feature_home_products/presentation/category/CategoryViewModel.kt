package com.george_georgy.eldokana.feature_home_products.presentation.category

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.eldokana.feature_home_products.domain.use_case.GetCategoriesUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel (
    private val getCategoriesUseCase: GetCategoriesUseCase,

    ) : ViewModel() {


    private val _categoriesState = mutableStateOf(emptyList<String>())
    val categoriesState: State<List<String>> = _categoriesState

    private val _selectedCategory = mutableStateOf("All")
    val selectedCategory: State<String> = _selectedCategory

    init {
        getCategories()
    }


    private fun getCategories() {
        viewModelScope.launch {
            _categoriesState.value = getCategoriesUseCase()
        }
    }


}

