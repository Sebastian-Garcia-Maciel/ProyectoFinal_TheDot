package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityConfiguracion : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        supportActionBar?.hide()

        val botonRegresar = findViewById<Button>(R.id.boton_regresar_de_configuracion)
        val botonCerrarSesion = findViewById<Button>(R.id.boton_cerrar_sesion)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }

        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}