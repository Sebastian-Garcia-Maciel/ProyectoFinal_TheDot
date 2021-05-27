package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.activity_calendario.*
import java.time.LocalDate
import java.util.*

class Calendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)





        calendarView.selectedDates



        // Asignar primer dia



        // Asignar dias resaltados





        btnRegresarAgenda.setOnClickListener{
            var intent: Intent = Intent(this, MiPerfil::class.java)
            startActivity(intent)
        }
    }



}