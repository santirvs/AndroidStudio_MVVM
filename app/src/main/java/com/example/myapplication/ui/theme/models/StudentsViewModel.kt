package com.example.myapplication.ui.theme.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class StudentsViewModel(): ViewModel() {
    private var students: MutableList<Student> = StudentsProvider().getStudents()
    private var studentIndex = -1


    constructor(course:String) : this() {
        students = students.filter { it -> it.course == course }.toMutableList()
    }

    private val _showForm = MutableLiveData<Boolean>(false)
    val showForm = _showForm
    private val _actualStudent = MutableLiveData<Student>()
    val actualStudent = _actualStudent

    fun getStudent() {
        studentIndex = (studentIndex + 1) % students.size
        _actualStudent.value = students[studentIndex]
        _showForm.value = true
    }

    fun editStudentName(newName: String) {
        _actualStudent.value = _actualStudent.value?.copy(name = newName)
    }

    fun editStudentCourse(newCourse: String) {
        _actualStudent.value = _actualStudent.value?.copy(course = newCourse)
    }

    fun editStudentGrade(newGrade: String) {
        _actualStudent.value = _actualStudent.value?.copy(grade = newGrade)
    }

    fun updateStudent(name: String, course: String, grade: String) {
        students[studentIndex] = Student(name, course, grade)
    }
}

