package com.example.helloworld.data

import javax.inject.Inject

class PersonDbRepository @Inject constructor(
    private val personDao: PersonDao
) {
    val readAll = personDao.readAll()
}