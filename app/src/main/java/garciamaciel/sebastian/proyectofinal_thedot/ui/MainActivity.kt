package garciamaciel.sebastian.proyectofinal_thedot.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.inicioSesion.CrearCuenta
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.inicioSesion.IniciaSesion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* Ocultar action bar */
        supportActionBar?.hide()


        val botonIniciaSesion = findViewById<Button>(R.id.boton_inicia_sesion)
        val botonCrearCuenta = findViewById<Button>(R.id.boton_crea_cuenta)


        botonIniciaSesion.setOnClickListener() {
            var intent: Intent = Intent(this, IniciaSesion::class.java)
            startActivity(intent)
        }
        botonCrearCuenta.setOnClickListener() {
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }
    }
}