package com.mustafa.codechallenge.data.api

import com.mustafa.codechallenge.data.model.StoryItem
import retrofit2.Response


interface ApiHelper {

    suspend fun getBrochures(): Response<StoryItem>
}