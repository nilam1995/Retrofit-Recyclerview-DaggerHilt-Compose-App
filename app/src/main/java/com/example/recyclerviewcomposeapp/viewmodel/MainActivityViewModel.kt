package com.example.recyclerviewcomposeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewcomposeapp.model.NewsDetailResponse
import com.example.recyclerviewcomposeapp.repository.RemoteDataRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor( private val remoteDataRepository: RemoteDataRepository):ViewModel() {

    val newsData = MutableLiveData<NewsDetailResponse>()

    fun getNewsData(data:NewsDetailResponse) = viewModelScope.launch {
        remoteDataRepository.getNewsArticles()
    }
}