package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

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
    }
}