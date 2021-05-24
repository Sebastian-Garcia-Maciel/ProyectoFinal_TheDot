package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos

class ActivityEstiramiento : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estiramiento)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.btnRegresarEstiramiento)
        val botonEstiramientoPasivo:android.widget.Button = findViewById<android.widget.Button>(R.id.boton_estiramiento_pasivo)
        val botonEstiramientoActivo:android.widget.Button = findViewById<android.widget.Button>(R.id.boton_estiramiento_activo)
        val botonEstiramientoEstatico:android.widget.Button = findViewById<android.widget.Button>(R.id.boton_estiramiento_estatico)

        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Metodos::class.java)
            startActivity(intent)
        }

        botonEstiramientoPasivo.setOnClickListener() {
            var intent: Intent = Intent(this,  EstiramientoPasivo::class.java)
            startActivity(intent)
        }
        botonEstiramientoActivo.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityEstiramientoActivo::class.java)
            startActivity(intent)
        }

        botonEstiramientoEstatico.setOnClickListener() {
            var intent: Intent = Intent(this, ActivyEstiramientoEstatico::class.java)
            startActivity(intent)
        }
    }
}