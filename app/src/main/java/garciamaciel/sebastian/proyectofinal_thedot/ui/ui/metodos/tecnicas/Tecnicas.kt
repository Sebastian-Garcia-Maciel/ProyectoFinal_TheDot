package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.ActivityDedos
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos

class Tecnicas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tecnicas)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarTec) as ImageButton
        val btnDedos: Button = findViewById(R.id.btnDedos) as Button
        val btnTrazos: Button = findViewById(R.id.btnTrazos) as Button
        val btnMuevete: Button = findViewById(R.id.btnMuevete) as Button

        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Metodos::class.java)
            startActivity(intent)
        }
        btnDedos.setOnClickListener{
            var intent: Intent = Intent(this, ActivityDedos::class.java)
            startActivity(intent)
        }
        btnTrazos.setOnClickListener{
            var intent: Intent = Intent(this, Trazos::class.java)
            startActivity(intent)
        }
        btnMuevete.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMuevete::class.java)
            startActivity(intent)
        }
    }
}