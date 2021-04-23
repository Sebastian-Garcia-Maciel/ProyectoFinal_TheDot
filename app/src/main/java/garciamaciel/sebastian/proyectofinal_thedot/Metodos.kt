package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Metodos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodos)
        supportActionBar?.hide()
        val buttonRegresar: ImageButton = findViewById(R.id.btnRegresarMet) as ImageButton
        val btnRespiracion: Button = findViewById(R.id.btnRespiracion) as Button
        val btnEstiramiento: Button = findViewById(R.id.btnEstiramiento) as Button
        val btnTecnicas: Button = findViewById(R.id.btnTecnicas) as Button
        val btnMeditacion: Button = findViewById(R.id.btnMeditacion) as Button
        val btnRecordatorios: Button = findViewById(R.id.btnFavoritos) as Button


        buttonRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }
        btnRespiracion.setOnClickListener {
            var intent: Intent = Intent(this, Respiracion::class.java)
            startActivity(intent)
        }
        btnEstiramiento.setOnClickListener {
            var intent: Intent = Intent(this, ActivityEstiramiento::class.java)
            startActivity(intent)
        }
        btnTecnicas.setOnClickListener {
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }
        btnMeditacion.setOnClickListener {
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }
        btnRecordatorios.setOnClickListener {
            var intent: Intent = Intent(this, Recordatorios::class.java)
            startActivity(intent)
        }
    }
}