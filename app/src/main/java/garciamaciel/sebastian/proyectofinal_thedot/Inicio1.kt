package garciamaciel.sebastian.proyectofinal_thedot

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class Inicio1 : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio1)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonMiPerfil: ImageButton = findViewById<ImageButton>(R.id.boton_mi_perfil)
        val botonMetodos: ImageButton = findViewById<ImageButton>(R.id.boton_metodos)
        val botonJournal: ImageButton = findViewById<ImageButton>(R.id.boton_journal)
        val botonAbout: ImageButton = findViewById<ImageButton>(R.id.boton_about)
        val headerConNombre:TextView = findViewById(R.id.tv_header)
        val cerrar:ImageView = findViewById(R.id.btnCerarSesion)

        val bundle = intent.extras
        if (bundle != null){
            val nombre = bundle.getString("name")

            headerConNombre.setText("¡Hola "+nombre+"!")

        }

        cerrar.setOnClickListener{
            finish()
        }


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