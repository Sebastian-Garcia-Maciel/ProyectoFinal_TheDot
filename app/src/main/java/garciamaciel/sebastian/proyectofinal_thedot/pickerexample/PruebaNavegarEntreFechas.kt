package garciamaciel.sebastian.proyectofinal_thedot.pickerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.activity_prueba_navegar_entre_fechas.*

class PruebaNavegarEntreFechas : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba_navegar_entre_fechas)

        etDate.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        etDate.setText("$day/$month/$year")
    }
}