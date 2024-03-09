package com.ryan.opncodingchallenge.util

sealed class AppResult<out T> {
    data class Success<T>(val data: T) : AppResult<T>()
    data class Failure(val error: Exception) : AppResult<Nothing>()
}