package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.meditacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos

class ActivityMeditacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion)
        supportActionBar?.hide()
        val buttonRegresar: ImageButton = findViewById(R.id.btnRegresarM) as ImageButton
        val btnComienza: Button = findViewById(R.id.btn_comienza) as Button
        val btnDeja: Button = findViewById(R.id.btnDejaEstres) as Button
        val btnLidia: Button = findViewById(R.id.btnLidiaEstres) as Button
        val btnAlcanza: Button = findViewById(R.id.btnAlcanzaPotencial) as Button


        buttonRegresar.setOnClickListener{
            var intent: Intent =Intent(this, Metodos::class.java)
            startActivity(intent)
        }
        btnComienza.setOnClickListener {
            var intent: Intent= Intent(this, ActivityMeditacionComienza::class.java)
            startActivity(intent)
        }
        btnDeja.setOnClickListener {
            var intent: Intent= Intent(this, ActivityMeditacionAtras::class.java)
            startActivity(intent)
        }
        btnLidia.setOnClickListener {
            var intent: Intent= Intent(this, ActivityMeditacionLidia::class.java)
            startActivity(intent)
        }
        btnAlcanza.setOnClickListener {
            var intent: Intent= Intent(this, ActivityMeditacionAlcanza::class.java)
            startActivity(intent)
        }

    }
}