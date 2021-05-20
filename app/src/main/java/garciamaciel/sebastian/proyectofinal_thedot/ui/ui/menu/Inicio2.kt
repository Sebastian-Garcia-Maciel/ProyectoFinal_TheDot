package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.Journal
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.MiPerfil

class Inicio2 : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio2)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonMiPerfil: ImageButton = findViewById<ImageButton>(R.id.boton_mi_perfil)
        val botonMetodos: ImageButton = findViewById<ImageButton>(R.id.boton_metodos)
        val  botonJournal: ImageButton = findViewById<ImageButton>(R.id.boton_journal)
        val  botonAbout: ImageButton = findViewById<ImageButton>(R.id.boton_about)


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