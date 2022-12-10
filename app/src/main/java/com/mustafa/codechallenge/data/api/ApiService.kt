package com.mustafa.codechallenge.data.api

import com.mustafa.codechallenge.data.model.StoryItem
import retrofit2.Response
import retrofit2.http.GET

private const val STORIES = "stories-test/shelf.json"

interface ApiService {

    @GET(STORIES)
    suspend fun getBrochures(): Response<StoryItem>

}