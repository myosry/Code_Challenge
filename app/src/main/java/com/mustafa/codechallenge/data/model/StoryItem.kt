package com.mustafa.codechallenge.data.model

import com.google.gson.annotations.SerializedName

data class StoryItem(
    @SerializedName("_embedded")
    val embedded: Embedded,
    @SerializedName("_links")
    val links: Links,
    val page: Page
) {
    data class Embedded(
        @SerializedName("contents")
        val contents: List<StoryContent>?
    )
}