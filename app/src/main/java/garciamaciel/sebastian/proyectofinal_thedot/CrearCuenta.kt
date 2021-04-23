package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CrearCuenta : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonRegresar = findViewById<Button>(R.id.boton_regresar_crear_cuenta)
        val botonCrearCuenta = findViewById<Button>(R.id.boton_crea_cuenta)



        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        botonCrearCuenta.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }
    }
}