package com.example.helloworld

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.helloworld.data.PersonDbRepository
import com.example.helloworld.data.PersonEntity
import com.example.helloworld.di.DatabaseModule
import dagger.Component
import kotlinx.coroutines.flow.Flow

@Component
class MainViewModel(
    application: Application
): AndroidViewModel(application) {
    val readAllData: Flow<List<PersonEntity>>
    private val personRepository: PersonDbRepository

    init {
        val database = DatabaseModule.provideDatabase(application.baseContext)
        val dao = DatabaseModule.provideDao(database)
        personRepository = PersonDbRepository(dao)
        readAllData = personRepository.readAll

    }
}