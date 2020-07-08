package com.ultrasoft.ghnewsapp.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getNews() = apiService.getNews()
}