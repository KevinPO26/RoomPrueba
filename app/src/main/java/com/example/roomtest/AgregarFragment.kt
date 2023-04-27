package com.example.roomtest

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.roomtest.databinding.FragmentAgregarBinding
import com.example.roomtest.databinding.FragmentMostrarBinding
import com.example.roomtest.datos.DBPrueba
import com.example.roomtest.entidades.Estudiante
import kotlinx.coroutines.launch
import kotlin.time.toDuration


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var adatador: Adaptador
    private val mostrarFragment = MostrarFragment()
    private lateinit var fbinding: FragmentAgregarBinding
    lateinit var  estudiante: Estudiante
    lateinit var room: DBPrueba



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragment: MostrarFragment = MostrarFragment()
        room = Room.databaseBuilder(requireContext(), DBPrueba::class.java, "dbPruebas").build()
        fbinding = FragmentAgregarBinding.inflate(layoutInflater)
        fbinding.floatingActionButton.setOnClickListener {

            agregar()

        }
        fbinding.btnLimpiar.setOnClickListener {
            limpiarCampos()
        }
        return fbinding.root
    }

    fun agregar(){
        with(fbinding){
            if (etNombre.text.toString() == "" || etApellidos.text.toString() == "" || etCarrera.text.toString() == "" || etCorreo.text.toString() == ""){
                Toast.makeText(activity, "Todos los campos son requeridos", Toast.LENGTH_LONG).show()
            }else{

                estudiante = Estudiante(
                    etNombre.text.toString().trim(),
                    etApellidos.text.toString().trim(),
                    etCarrera.text.toString().trim(),
                    etCorreo.text.toString().trim()
                )

                agregarEstudiante(room ,estudiante)
                Toast.makeText(activity, "Estudiante Insertado correctamente", Toast.LENGTH_LONG).show()
                limpiarCampos()


            }

        }
    }

    private fun limpiarCampos() {
        with(fbinding){
            etNombre.setText("")
            etApellidos.setText("")
            etCarrera.setText("")
            etCorreo.setText("")
        }
    }

    fun agregarEstudiante(room: DBPrueba, estudiante: Estudiante) {
        lifecycleScope.launch {
            room.daoEstudiante().agregarUsuario(estudiante)
        }
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AgregarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AgregarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}