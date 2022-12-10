package com.mustafa.codechallenge.data.model

data class StoryContent(
    val adFormat: String,
    var content: Any,
    val contentFormatSource: String,
    val contentType: String,
    val externalTracking: ExternalTracking,
    val placement: String
)