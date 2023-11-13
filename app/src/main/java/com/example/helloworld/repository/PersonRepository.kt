package com.example.helloworld.repository

import com.example.helloworld.model.Person

class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "John",
                lastName = "Doe",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Tano",
                lastName = "Zito",
                age = 35
            ),
            Person(
                id = 2,
                firstName = "Iliana",
                lastName = "Ssupida",
                age = 28
            ),
            Person(
                id = 3,
                firstName = "Jennifer",
                lastName = "Miller",
                age = 25
            ),
            Person(
                id = 4,
                firstName = "Daniel",
                lastName = "Tailor",
                age = 22
            ),
            Person(
                id = 5,
                firstName = "Charles",
                lastName = "Wilson",
                age = 27
            ),
            Person(
                id = 6,
                firstName = "Sarah",
                lastName = "Lopez",
                age = 23
            ),
            Person(
                id = 7,
                firstName = "James",
                lastName = "Johnson",
                age = 21
            ),
            Person(
                id = 8,
                firstName = "Lawrence",
                lastName = "D'Arabia",
                age = 41
            ),
            Person(
                id = 9,
                firstName = "Brad",
                lastName = "Pitt",
                age = 45
            ),
        )
    }
}