package com.mustafa.codechallenge.data.api

import com.mustafa.codechallenge.data.model.StoryItem
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getBrochures(): Response<StoryItem> = apiService.getBrochures()

}