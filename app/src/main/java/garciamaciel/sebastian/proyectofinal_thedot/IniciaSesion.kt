package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IniciaSesion : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicia_sesion)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar = findViewById<Button>(R.id.boton_regresar_inicia_sesion)
        val botonIniciarSesion = findViewById<Button>(R.id.boton_inicia_sesion)

        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        botonIniciarSesion.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }
    }
}