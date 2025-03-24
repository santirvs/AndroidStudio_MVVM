package com.example.myapplication.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.models.Student
import com.example.myapplication.ui.theme.models.StudentsViewModel
import com.example.myapplication.ui.theme.models.StudentsViewModel_ParamFactory
import com.example.myapplication.ui.theme.models.StudentsViewModel_Param

@Composable
fun Screen_Students_Param(course:String) {
    //val studentsViewModel = viewModel<StudentsViewModel>()
    val studentsViewModel: StudentsViewModel_Param = viewModel( factory = StudentsViewModel_ParamFactory(course))

    val showForm: Boolean by studentsViewModel.showForm.observeAsState(false)
    Column(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxSize().weight(40f), contentAlignment = Alignment.Center) {
            Button(onClick={studentsViewModel.getStudent()}){Text("Get next student data")}
        }
        if (showForm) {
            Box(Modifier.fillMaxSize().weight(60f)) {
                EditForm(studentsViewModel)
            }
        }
    }
}


@Composable
fun EditForm(studentsViewModel: StudentsViewModel_Param) {
    val actualStudent: Student? by studentsViewModel.actualStudent.observeAsState(null)
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = actualStudent!!.name, readOnly = true, enabled = false,
            onValueChange = { studentsViewModel.editStudentName(it) })
        TextField(
            value = actualStudent!!.course, label = { Text("Curs") },
            onValueChange = { studentsViewModel.editStudentCourse(it) })
        TextField(
            value = actualStudent!!.grade.toString(), label = { Text("Nota") },
            onValueChange = { studentsViewModel.editStudentGrade(it) })
        Button(onClick = {
            studentsViewModel.updateStudent(actualStudent!!.name, actualStudent!!.course, actualStudent!!.grade)
        }) { Text("Guardar canvis") }
    }
}

