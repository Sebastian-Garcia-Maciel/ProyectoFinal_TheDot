package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R

class TheDot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_dot)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarTD) as ImageButton


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}