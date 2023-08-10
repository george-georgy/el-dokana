package com.george_georgy.eldokana.feature_home_products.presentation.category

// event from ui to viemodel
sealed class HomeEvent {
    data class CategoryChanged(val category : String) : HomeEvent()
}