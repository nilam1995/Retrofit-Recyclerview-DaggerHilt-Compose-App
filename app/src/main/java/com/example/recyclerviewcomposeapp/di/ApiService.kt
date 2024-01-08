package com.example.recyclerviewcomposeapp.di

import com.example.recyclerviewcomposeapp.di.utils.Constants
import com.example.recyclerviewcomposeapp.model.NewsDetailResponse
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.NEWS_ENDPOINT)
    suspend fun getNewsArticles():NewsDetailResponse
}