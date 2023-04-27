package com.example.roomtest

import com.example.roomtest.entidades.Estudiante

interface AdaptadorListener {
    fun onEditItemClick(estudiante: Estudiante)
    fun onDeleteItemClick(estudiante: Estudiante)
}