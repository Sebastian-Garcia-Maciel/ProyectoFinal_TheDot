package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

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
            var intent: Intent = Intent(this, Trazos::class.java)
            startActivity(intent)
        }
        btnTrazos.setOnClickListener{
            var intent: Intent = Intent(this, Trazos::class.java)
            startActivity(intent)
        }
        btnMuevete.setOnClickListener{
            var intent: Intent = Intent(this, ActivityEstiramientoActivo::class.java)
            startActivity(intent)
        }
    }
}