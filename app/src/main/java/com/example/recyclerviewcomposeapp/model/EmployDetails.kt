package com.example.recyclerviewcomposeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmployDetails(
    @PrimaryKey
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val ImageId: Int = 0)