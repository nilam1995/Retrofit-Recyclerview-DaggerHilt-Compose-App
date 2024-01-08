package com.example.recyclerviewcomposeapp.model

data class NewsDetailResponse(
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)
