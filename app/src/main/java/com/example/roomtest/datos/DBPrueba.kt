package com.example.roomtest.datos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomtest.entidades.Estudiante

@Database(
    entities = [Estudiante::class],
    version = 1
)
abstract class DBPrueba: RoomDatabase() {
    abstract fun daoEstudiante(): DaoEstudiante
}