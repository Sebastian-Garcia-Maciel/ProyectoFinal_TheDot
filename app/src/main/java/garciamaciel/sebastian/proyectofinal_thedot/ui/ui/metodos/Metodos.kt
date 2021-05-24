package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento.ActivityEstiramiento
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.Tecnicas
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.respiracion.Respiracion
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios.ActivityRecordatorios

class Metodos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodos)
        supportActionBar?.hide()
        val buttonRegresar: ImageButton = findViewById(R.id.btnRegresarMet) as ImageButton
        val btnRespiracion: LinearLayout = findViewById(R.id.btnRespiracion) as LinearLayout
        val btnEstiramiento: LinearLayout = findViewById(R.id.btnEstiramiento) as LinearLayout
        val btnTecnicas: LinearLayout = findViewById(R.id.btnTecnicas) as LinearLayout
        val btnMeditacion: LinearLayout = findViewById(R.id.btnMeditacion) as LinearLayout
        val btnRecordatorios: LinearLayout = findViewById(R.id.btnFavoritos) as LinearLayout


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
            var intent: Intent = Intent(this, ActivityRecordatorios::class.java)
            startActivity(intent)
        }
    }
}