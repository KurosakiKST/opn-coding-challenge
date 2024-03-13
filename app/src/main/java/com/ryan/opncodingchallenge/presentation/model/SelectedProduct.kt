package com.ryan.opncodingchallenge.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectedProduct(
    val product: ProductUIModel,
    var quantity: Int
) : Parcelable