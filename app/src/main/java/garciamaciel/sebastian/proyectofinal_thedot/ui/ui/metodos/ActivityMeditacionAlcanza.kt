package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R

class ActivityMeditacionAlcanza : AppCompatActivity() {
    companion object {
        var like: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion_alcanza)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarMA) as ImageButton


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }
    }
}