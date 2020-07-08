package com.ultrasoft.ghnewsapp.repository

import com.ultrasoft.ghnewsapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getNews() = apiHelper.getNews()
}