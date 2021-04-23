package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityComoEstas : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_como_estas)
        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar = findViewById<Button>(R.id.boton_regresar_como_estas)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }
    }
}