package com.example.myapplication.ui.theme.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudentsViewModel_ParamFactory(private val course: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentsViewModel_Param::class.java)) {
            return StudentsViewModel_Param(course) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
