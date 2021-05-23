package garciamaciel.sebastian.proyectofinal_thedot.ui.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import kotlinx.android.synthetic.main.activity_journal.*

class Journal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)
        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.boton_regresar_de_journal)
        val botonIntencionesDia = findViewById<Button>(R.id.btnIntencionesDia)
        val botonIntencionesSemana = findViewById<Button>(R.id.btnIntencionesSemana)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityInicio::class.java)
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
        btnMisDias.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityDias::class.java)
            startActivity(intent)
        }
    }
}