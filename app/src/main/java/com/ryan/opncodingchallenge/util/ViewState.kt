package com.ryan.opncodingchallenge.util

sealed class ViewState<out T> {

    data object Loading : ViewState<Nothing>()

    data class Success<T>(val data: T) : ViewState<T>()

    data class Error(val error: String) : ViewState<Nothing>()

    data object NoData : ViewState<Nothing>()
}