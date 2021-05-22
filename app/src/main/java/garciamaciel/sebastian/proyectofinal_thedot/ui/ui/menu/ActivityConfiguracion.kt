package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.MainActivity

class ActivityConfiguracion : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        supportActionBar?.hide()

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.boton_regresar_de_configuracion)
        val botonCerrarSesion = findViewById<Button>(R.id.boton_cerrar_sesion)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityInicio::class.java)
            startActivity(intent)
        }

        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}