package com.george_georgy.eldokana.feature_wishlist.presentaion

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.eldokana.core.utils.UiEvent
import com.george_georgy.eldokana.feature_wishlist.data.local.entity.WishlistEntity
import com.george_georgy.eldokana.feature_wishlist.domain.model.Wish
import com.george_georgy.eldokana.feature_wishlist.domain.repository.WishlistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

class WishlistViewModel(
    private val repository: WishlistRepository
) : ViewModel() {

    private val _wishlistEventResult = MutableSharedFlow<UiEvent>()
    val wishlistEventResult = _wishlistEventResult.asSharedFlow()

    private val _wishItemState = mutableStateOf(emptyList<WishlistEntity>())
    val wishItemState = _wishItemState


    init {
        getWishlistItems()
    }

    fun isInWishlist(id: Int): LiveData<Boolean> {
        return repository.isInWishlist(id)
    }


    private fun getWishlistItems() {
        repository.getWishlist().onEach {
            _wishItemState.value = it
        }.launchIn(viewModelScope)
    }


    fun insertFavorite(wish: Wish) {
        viewModelScope.launch {
            repository.insertWishItem(wish)
        }
    }


    fun deleteFromWishlist(wish: Wish) {
        viewModelScope.launch {
            repository.deleteWishItem(wish)
            _wishlistEventResult.emit(
                UiEvent.SnackbarEvent(result = "Item removed from wishlist")
            )
        }
    }

    fun deleteAllWishlist() {
        viewModelScope.launch {
            repository.getWishlist().collect { items ->
                if (items.isEmpty()) {
                    _wishlistEventResult.emit(
                        UiEvent.SnackbarEvent(result = "No items currently in your Wishlist")
                    )
                } else {
                    repository.deleteWishlist()
                    _wishlistEventResult.emit(
                        UiEvent.SnackbarEvent(result = "Your wishlist has been cleared of all items.")
                    )
                }
            }
        }

    }
}