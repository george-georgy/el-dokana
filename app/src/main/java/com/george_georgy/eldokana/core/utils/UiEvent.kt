package com.george_georgy.eldokana.core.utils

sealed class UiEvent {
    data class SnackbarEvent(val result: String) : UiEvent()
}