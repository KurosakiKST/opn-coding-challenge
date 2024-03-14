package com.ryan.opncodingchallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductUIModel(
    val productName: String?,
    val price: Long?,
    val imageUrl: String?
) : Parcelable