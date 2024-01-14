package com.example.recyclerviewcomposeapp.repository

import com.example.recyclerviewcomposeapp.di.ApiService
import com.example.recyclerviewcomposeapp.model.NewsDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataRepository @Inject constructor(private val apiService: ApiService) {

    fun getNewsArticles(): Flow<NewsDetailResponse> = flow{
        val response = apiService.getNewsArticles()
        emit(response)
    }.flowOn(Dispatchers.IO)
}