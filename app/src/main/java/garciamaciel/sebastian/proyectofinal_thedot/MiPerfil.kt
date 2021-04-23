package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MiPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)
        supportActionBar?.hide()
        val buttonRegresar: ImageButton = findViewById(R.id.btnRegresarMi) as ImageButton
        val btnRecordatorios: Button = findViewById(R.id.btnRecordatorios) as Button
        val btnAfirmaciones: Button = findViewById(R.id.btnAfirmaciones) as Button
        val btnMetas: Button = findViewById(R.id.btnMetas) as Button
        val btnTecnicas: Button = findViewById(R.id.btnAgenda) as Button


        buttonRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Metodos::class.java)
            startActivity(intent)
        }
        btnRecordatorios.setOnClickListener {
            var intent: Intent = Intent(this, Recordatorios::class.java)
            startActivity(intent)
        }
        btnAfirmaciones.setOnClickListener {
            var intent: Intent = Intent(this, Recordatorios::class.java)
            startActivity(intent)
        }
        btnMetas.setOnClickListener {
            var intent: Intent = Intent(this, Recordatorios::class.java)
            startActivity(intent)
        }
        btnTecnicas.setOnClickListener {
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }
    }
}