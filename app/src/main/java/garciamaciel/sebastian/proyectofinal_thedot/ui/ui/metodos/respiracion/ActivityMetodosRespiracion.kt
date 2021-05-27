package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.respiracion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos
import kotlinx.android.synthetic.main.activity_metodos_respiracion.*

class ActivityMetodosRespiracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodos_respiracion)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarMr) as ImageButton
        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Metodos::class.java)
            startActivity(intent)
        }
        etCompleta.setOnClickListener{
            var intent: Intent = Intent(this, activity_respiracion_completa::class.java)
            startActivity(intent)
        }
        etProfunda.setOnClickListener{
            var intent: Intent = Intent(this, RespiracionProfunda::class.java)
            startActivity(intent)
        }
        etMuscular.setOnClickListener{
            var intent: Intent = Intent(this, activity_respiracion_muscular::class.java)
            startActivity(intent)
        }
    }
}