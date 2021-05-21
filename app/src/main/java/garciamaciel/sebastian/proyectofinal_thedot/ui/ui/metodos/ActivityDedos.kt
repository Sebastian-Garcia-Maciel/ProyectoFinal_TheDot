package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.Inicio1
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.Trazos
import kotlinx.android.synthetic.main.activity_dedos.*

class ActivityDedos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dedos)
        supportActionBar?.hide()

        btnRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Trazos::class.java)
            startActivity(intent)
        }
    }
}