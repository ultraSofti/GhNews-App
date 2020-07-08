package com.ultrasoft.ghnewsapp.data.api

import com.ultrasoft.ghnewsapp.data.model.News
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    suspend fun getNews() : List<News>
}