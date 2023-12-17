package com.example.helloworld

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.data.PersonDatabase
import com.example.helloworld.data.PersonDbRepository
import com.example.helloworld.data.PersonEntity
import com.example.helloworld.di.DatabaseModule
import dagger.Component
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

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