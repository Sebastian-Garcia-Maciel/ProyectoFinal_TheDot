package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.journal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.pickerexample.DatePickerFragment
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import kotlinx.android.synthetic.main.activity_journal.*
import kotlinx.android.synthetic.main.activity_prueba_navegar_entre_fechas.*
import kotlinx.android.synthetic.main.activity_prueba_navegar_entre_fechas.etDate

class Journal : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)
        /*Oculta la action bar*/
        supportActionBar?.hide()
        usuario = FirebaseAuth.getInstance()
        storage = FirebaseFirestore.getInstance()

        etDate.setOnClickListener { showDatePickerDialog() }

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.boton_regresar_de_journal)
        val botonIntencionesDia = findViewById<Button>(R.id.btnIntencionesDia)
        val botonIntencionesSemana = findViewById<Button>(R.id.btnIntencionesSemana)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityInicio::class.java)
            startActivity(intent)
        }

        btnComoEstasHoy.setOnClickListener{
            var intent: Intent = Intent(this, ActivityComoEstas::class.java)
            startActivity(intent)
        }

        botonIntencionesDia.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityIntencionesDia::class.java)
            startActivity(intent)
        }
        botonIntencionesSemana.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityIntencionesSemana::class.java)
            startActivity(intent)
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        etDate.setText("$day/$month/$year")
    }
}