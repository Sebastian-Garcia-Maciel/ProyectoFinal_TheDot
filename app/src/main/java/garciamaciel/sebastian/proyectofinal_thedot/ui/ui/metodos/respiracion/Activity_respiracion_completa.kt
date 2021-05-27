package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.respiracion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.activity_respiracion_completa.*
import kotlinx.android.synthetic.main.activity_respiracion_muscular.*
import kotlinx.android.synthetic.main.activity_respiracion_muscular.btnRegresar

class activity_respiracion_completa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracion_completa)
        supportActionBar?.hide()
        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMetodosRespiracion::class.java)
            startActivity(intent)
        }
    }
}