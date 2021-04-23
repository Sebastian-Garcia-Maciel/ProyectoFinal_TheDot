package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Inicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio1)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnConfiguracion) as ImageButton


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityConfiguracion::class.java)
            startActivity(intent)
        }
    }
}