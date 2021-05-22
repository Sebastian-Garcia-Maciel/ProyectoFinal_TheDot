package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.Journal
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.MiPerfil
import kotlinx.android.synthetic.main.activity_inicio.*

class ActivityInicio : AppCompatActivity() {
    var contador: Int = 1
    var previo: Int = 1
    var siguiente: Int = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        /*Oculta la action bar*/
        supportActionBar?.hide()

        val botonMiPerfil: ImageButton = findViewById<ImageButton>(R.id.boton_mi_perfil)
        val botonMetodos: ImageButton = findViewById<ImageButton>(R.id.boton_metodos)
        val botonJournal: ImageButton = findViewById<ImageButton>(R.id.boton_journal)
        val botonAbout: ImageButton = findViewById<ImageButton>(R.id.boton_about)
        val headerConNombre: TextView = findViewById(R.id.tv_header)
        val cerrar: ImageView = findViewById(R.id.btnCerrarSesion)

        val bundle = intent.extras
        if (bundle != null) {
            val nombre = bundle.getString("name")

            headerConNombre.setText("¡Hola " + nombre + "!")

        }

        cerrar.setOnClickListener {
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

        btnAvanzarMenu.setOnClickListener {
            avanzarImagen()
        }

        btnRegresarMenu.setOnClickListener {
            retrocederImagen()
        }

    }

    /**
     *
     */
    fun avanzarImagen() {
        contador++
        if (contador > 5) {
            contador = 1
        }
        asignarImagen()
    }

    fun retrocederImagen() {
        contador--
        if (contador < 1) {
            contador = 5
        }
        asignarImagen()
    }

    fun asignarImagen() {
        if (contador == 1) {
            fondoInicio.setImageResource(R.drawable.frase)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_seleccionado)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel)
        }
        if (contador == 2) {
            fondoInicio.setImageResource(R.drawable.ve_por_helado2)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco_seleccionado)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
        }
        if (contador == 3) {
            fondoInicio.setImageResource(R.drawable.playlist3)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco_seleccionado)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
        }
        if (contador == 4) {
            fondoInicio.setImageResource(R.drawable.foto_del_dia2)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco_seleccionado)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
        }
        if (contador == 5) {
            fondoInicio.setImageResource(R.drawable.sabias2)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco_seleccionado)
        }


    }
}