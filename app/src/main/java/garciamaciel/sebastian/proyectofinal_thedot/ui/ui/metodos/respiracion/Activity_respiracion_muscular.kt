package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.respiracion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.ActivityMeditacion
import kotlinx.android.synthetic.main.activity_respiracion_muscular.*

class activity_respiracion_muscular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracion_muscular)
        supportActionBar?.hide()

        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMetodosRespiracion::class.java)
            startActivity(intent)
        }
    }
}