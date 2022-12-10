package com.mustafa.codechallenge.data.repository

import com.mustafa.codechallenge.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getBrochures() = apiHelper.getBrochures()

}