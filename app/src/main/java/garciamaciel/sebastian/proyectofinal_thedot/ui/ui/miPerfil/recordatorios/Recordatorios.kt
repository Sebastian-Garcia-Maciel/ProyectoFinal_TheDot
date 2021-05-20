package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.MiPerfil

class Recordatorios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordatorios)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarMIR) as ImageButton


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, MiPerfil::class.java)
            startActivity(intent)
        }
    }
}