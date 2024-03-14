package com.ryan.opncodingchallenge.presentation.view.uiMapper

import com.ryan.opncodingchallenge.domain.model.StoreDomainModel
import com.ryan.opncodingchallenge.presentation.model.StoreUIModel
import java.text.SimpleDateFormat
import java.util.TimeZone

object StoreUIMapper {

    fun mapToUiModel(domainModel: StoreDomainModel?): StoreUIModel {
        return StoreUIModel(
            storeName = domainModel?.storeName ?: "Unavailable",
            rating = domainModel?.rating ?: 0.0,
            openingTime = convertTime(domainModel?.openingTime),
            closingTime = convertTime(domainModel?.closingTime),
        )
    }

    private fun convertTime(timeString: String?): String {
        val inputFormat = SimpleDateFormat("HH:mm:ss.SSS'Z'")
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = inputFormat.parse(timeString!!)

        val outputFormat = SimpleDateFormat("hh:mm a")
        return outputFormat.format(date)
    }

}