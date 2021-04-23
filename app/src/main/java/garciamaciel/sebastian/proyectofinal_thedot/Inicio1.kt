package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio1 : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio1)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonMiPerfil = findViewById<Button>(R.id.boton_mi_perfil)
        val botonMetodos = findViewById<Button>(R.id.boton_metodos)
        val  botonJournal = findViewById<Button>(R.id.boton_journal)
        val  botonAbout = findViewById<Button>(R.id. boton_about)


        botonMiPerfil.setOnClickListener() {
            var intent: Intent = Intent(this, MiPerfil::class.java)
            startActivity(intent)
        }
        botonMetodos.setOnClickListener() {
            var intent: Intent = Intent(this, Metodos::class.java)
            startActivity(intent)
        }

         botonJournal.setOnClickListener() {
            var intent: Intent = Intent(this, Journal::class.java)
            startActivity(intent)
        }

        botonAbout.setOnClickListener() {
            var intent: Intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}