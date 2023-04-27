package com.example.roomtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtest.entidades.Estudiante
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Adaptador (
    val listaEst: MutableList<Estudiante>,
    val listener: AdaptadorListener
): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.rcestudent, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estudiante = listaEst[position]

        holder.etNombre.text = estudiante.nombre
        holder.etApellido.text = estudiante.apellidos
        holder.etCarrera.text = estudiante.carrera
        holder.etCorreo.text = estudiante.correo

        holder.constrain.setOnClickListener {
            listener.onEditItemClick(estudiante)
        }

        holder.btnEliminar.setOnClickListener {
            listener.onDeleteItemClick(estudiante)
        }

    }

    override fun getItemCount(): Int {
        return listaEst.size
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        var etNombre = itemView.findViewById<TextView>(R.id.etNombre)
        var etApellido = itemView.findViewById<TextView>(R.id.etApellidos)
        var etCarrera = itemView.findViewById<TextView>(R.id.etCarrera)
        var etCorreo = itemView.findViewById<TextView>(R.id.etCorreo)
        var btnEliminar = itemView.findViewById<FloatingActionButton>(R.id.floatingActionButton3)
        var constrain = itemView.findViewById<ConstraintLayout>(R.id.ctRecycler)
    }



}