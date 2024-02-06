package com.example.recyclerviewcomposeapp.repository

import android.util.Log
import com.example.recyclerviewcomposeapp.di.ApiService
import com.example.recyclerviewcomposeapp.model.NewsDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataRepository @Inject constructor(private val apiService: ApiService) {
    private val _newsData = MutableStateFlow<NewsDetailResponse?>(null)
    val newsData: MutableStateFlow<NewsDetailResponse?>
        get() = _newsData
    suspend fun getNewsArticles(){
        val response = apiService.getNewsArticles()
        _newsData.emit(response)
    }
}