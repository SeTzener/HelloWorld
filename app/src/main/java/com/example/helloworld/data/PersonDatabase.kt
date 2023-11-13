package com.example.helloworld.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1, exportSchema = true)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}