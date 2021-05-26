package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.respiracion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.ActivityMeditacion

class RespiracionProfunda : AppCompatActivity() {
    companion object {
        var like: Boolean = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracion_profunda)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarResP) as ImageButton


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }
    }
}