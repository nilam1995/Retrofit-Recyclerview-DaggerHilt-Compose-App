package com.example.recyclerviewcomposeapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recyclerviewcomposeapp.db.daos.AppDao
import com.example.recyclerviewcomposeapp.model.EmployDetails

@Database(entities = arrayOf(EmployDetails::class), version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun appDao():AppDao
}