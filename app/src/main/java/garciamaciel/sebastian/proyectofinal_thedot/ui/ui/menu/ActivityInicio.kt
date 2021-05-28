package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.journal.Journal
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.Metodos
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento.ActivityEstiramientoActivo
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.MiPerfil
import kotlinx.android.synthetic.main.activity_estiramiento_activo.*
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_mi_perfil.*

class ActivityInicio : AppCompatActivity() {
    var contador: Int = 1
    var previo: Int = 1
    var siguiente: Int = 2

    lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        /*Oculta la action bar*/
        supportActionBar?.hide()
        usuario = FirebaseAuth.getInstance()
        storage = FirebaseFirestore.getInstance()
        obtenerUsuario()


        val botonMiPerfil: ImageButton = findViewById<ImageButton>(R.id.boton_mi_perfil)
        val botonMetodos: ImageButton = findViewById<ImageButton>(R.id.boton_metodos)
        val botonJournal: ImageButton = findViewById<ImageButton>(R.id.boton_journal)
        val botonAbout: ImageButton = findViewById<ImageButton>(R.id.boton_about)
        val headerConNombre: TextView = findViewById(R.id.tv_header_nombre)
        val btnConfiguracion: ImageButton = findViewById(R.id.btnConfiguracion)

        val bundle = intent.extras
        if (bundle != null) {
            val nombre = bundle.getString("name")

            headerConNombre.setText("¡Hola " + nombre + "!")

        }

        btnConfiguracion.setOnClickListener {
            var intent: Intent = Intent(this, ActivityConfiguracion::class.java)
            startActivity(intent)
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

    fun obtenerUsuario() {
        val  favoritosRef: DocumentReference = storage.collection("usuarios")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("nombreUsuario")!= null){
                tv_header_nombre.setText("¡Hola " + it.get("nombreUsuario") as String +"!")

                if (ActivityEstiramientoActivo.like) {
                    Favorito.devolverAnimacion(like_estiramiento_activo, R.raw.apple_event,
                        ActivityEstiramientoActivo.like
                    )
                }
            }
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
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_seleccionado)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
        }
        if (contador == 3) {
            fondoInicio.setImageResource(R.drawable.playlist3)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_seleccionado)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
        }
        if (contador == 4) {
            fondoInicio.setImageResource(R.drawable.foto_del_dia2)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_seleccionado)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
        }
        if (contador == 5) {
            fondoInicio.setImageResource(R.drawable.sabias2)
            btnPrimeraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnSegundaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnTerceraImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnCuartaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_blanco)
            btnQuintaImagen.setBackgroundResource(R.drawable.fondo_boton_carrusel_seleccionado)
        }


    }
}