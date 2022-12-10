package com.mustafa.codechallenge.data.model

data class Content(
    val badges: List<Any>,
    val brochureImage: String?,
    val distance: Double,
    val hideValidityDate: Boolean,
    val id: Int,
    val isEcommerce: Boolean,
    val pageCount: Int,
    val publishedFrom: String,
    val publishedUntil: String,
    val publisher: Publisher,
    val retailer: Retailer?,
    val title: String,
    val type: String,
    val validFrom: String,
    val validUntil: String
)