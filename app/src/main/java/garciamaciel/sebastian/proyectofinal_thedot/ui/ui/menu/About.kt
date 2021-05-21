package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.Articulos
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.Estres
import kotlinx.android.synthetic.main.activity_about.*

class About : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.boton_regresar_about)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }

        etTheDot.setOnClickListener{
            var intent: Intent = Intent(this, TheDot::class.java)
            startActivity(intent)
        }
        etArticulos.setOnClickListener{
            var intent: Intent = Intent(this, Articulos::class.java)
            startActivity(intent)
        }
        etEstres.setOnClickListener{
            var intent: Intent = Intent(this, Estres::class.java)
            startActivity(intent)
        }
    }
}