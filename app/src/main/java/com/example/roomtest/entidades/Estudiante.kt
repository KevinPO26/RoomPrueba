package com.example.roomtest.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiante")
data class Estudiante(
    @ColumnInfo(name = "nombre") var nombre: String,
    @ColumnInfo(name = "apellidos") var apellidos: String,
    @ColumnInfo(name = "carrera") var carrera: String,
    @ColumnInfo(name = "correo") var correo: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int= 0

)