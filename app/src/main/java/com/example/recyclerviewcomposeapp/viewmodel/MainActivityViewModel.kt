package com.example.recyclerviewcomposeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewcomposeapp.model.NewsDetailResponse
import com.example.recyclerviewcomposeapp.repository.RemoteDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val remoteDataRepository: RemoteDataRepository):ViewModel() {
    val newsData: MutableStateFlow<NewsDetailResponse?>
        get() = remoteDataRepository.newsData

    init {
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            remoteDataRepository.getNewsArticles()
        }
    }
}