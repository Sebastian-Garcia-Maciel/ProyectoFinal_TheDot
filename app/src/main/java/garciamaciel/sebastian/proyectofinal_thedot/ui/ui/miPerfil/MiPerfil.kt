package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios.ActivityRecordatorios
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.Tecnicas
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.ActivityAfirmaciones

class MiPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarPerfil) as ImageButton
        val btnRecordatorios: LinearLayout = findViewById(R.id.btnRecordatorios) as LinearLayout
        val btnAfirmaciones: LinearLayout = findViewById(R.id.btnAfirmaciones) as LinearLayout
        val btnMetas: LinearLayout = findViewById(R.id.btnMetas) as LinearLayout
        val btnTecnicas: LinearLayout = findViewById(R.id.btnAgenda) as LinearLayout


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityInicio::class.java)
            startActivity(intent)
        }
        btnRecordatorios.setOnClickListener {
            var intent: Intent = Intent(this, ActivityRecordatorios::class.java)
            startActivity(intent)
        }
        btnAfirmaciones.setOnClickListener {
            var intent: Intent = Intent(this, ActivityAfirmaciones::class.java)
            startActivity(intent)
        }
        btnMetas.setOnClickListener {
            var intent: Intent = Intent(this, ActivityRecordatorios::class.java)
            startActivity(intent)
        }
        btnTecnicas.setOnClickListener {
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }
    }
}