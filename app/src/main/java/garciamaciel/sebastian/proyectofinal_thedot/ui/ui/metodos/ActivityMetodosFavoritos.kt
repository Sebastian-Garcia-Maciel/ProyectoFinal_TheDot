package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R

class ActivityMetodosFavoritos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodos_favoritos)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarF) as ImageButton
        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Metodos::class.java)
            startActivity(intent)
        }
    }
}