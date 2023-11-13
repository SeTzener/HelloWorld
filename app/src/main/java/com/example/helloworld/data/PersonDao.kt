package com.example.helloworld.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
        @Query("SELECT * FROM person")
    fun readAll(): Flow<List<PersonEntity>>
}