package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ActivityMeditacionComienza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion_comienza)
        /* Ocultar action bar */
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarC) as ImageButton
        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }
    }
}