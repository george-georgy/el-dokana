package com.george_georgy.eldokana.feature_home_products.presentation.home_lists

// event from ui to viemodel
sealed class HomeEvent {
    data class CategoryChanged(val category : String) : HomeEvent()
}