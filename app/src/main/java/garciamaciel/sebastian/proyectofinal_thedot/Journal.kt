package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Journal : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)
        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar = findViewById<Button>(R.id.boton_regresar_de_journal)
        val botonComoestasHoy = findViewById<Button>(R.id.btnComoEstas)
        val botonIntencionesDia = findViewById<Button>(R.id.btnIntencionesDia)
        val botonIntencionesSemana = findViewById<Button>(R.id.btnIntencionesSemana)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }

        botonComoestasHoy.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityComoEstas::class.java)
            startActivity(intent)
        }
        botonIntencionesDia.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityIntencionesSemana::class.java)
            startActivity(intent)
        }
    }
}