package com.example.myapplication.ui.theme.models

class StudentsProvider {
    private val students: MutableList<Student> = mutableListOf<Student>(
        Student("John Doe", "DAM2", "9"), Student("Darth Vader", "DAM1", "6"),
        Student("Frodo Bolsón", "DAM1", "4"), Student("Hermione Granger", "DAM2", "10"),
        Student("Diana Prince", "DAM1", "5"), Student("Mickey Mouse", "DAM2", "7"))

    fun getStudents(): MutableList<Student>{
        return students
    }
}
