package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R

class ActivityMuevete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muevete)
        /*Oculta la action bar*/
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.boton_regresar_muevete) as ImageButton

        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }
    }
}