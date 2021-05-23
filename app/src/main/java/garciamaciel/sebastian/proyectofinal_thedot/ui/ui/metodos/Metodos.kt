package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento.ActivityEstiramiento
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.Tecnicas
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.respiracion.Respiracion
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios.Recordatorios

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
            var intent: Intent = Intent(this, ActivityInicio::class.java)
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