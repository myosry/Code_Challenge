package com.mustafa.codechallenge.data.model

data class Links(
    val self: Self
) {
    data class Self(
        val href: String
    )
}