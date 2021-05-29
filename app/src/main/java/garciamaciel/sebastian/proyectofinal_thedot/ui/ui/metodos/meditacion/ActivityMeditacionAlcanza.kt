package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.meditacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import kotlinx.android.synthetic.main.activity_meditacion_alcanza.*

class ActivityMeditacionAlcanza : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    lateinit var usuario: FirebaseAuth
    val API_KEY = "AIzaSyAaOARnYN9G37K4xzQMk50r86DDZRpm_l0"


    companion object {
        var like: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion_alcanza)
        supportActionBar?.hide()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        obtenerEstadoFavorito()

        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarMA) as ImageButton


        btnRegresar.setOnClickListener {
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }

        like_meditacion_alcanza.setOnClickListener {
            ActivityMeditacionAlcanza.like = Favorito.likeAnimation(
                like_meditacion_alcanza, R.raw.apple_event,
                ActivityMeditacionAlcanza.like
            )

            if (!ActivityMeditacionAlcanza.like) {
                Toast.makeText(this, "Se ha eliminado de tus favoritos.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Se ha agregado a tus favoritos.", Toast.LENGTH_SHORT).show()
            }
            Favorito.actualizarDocumento(
                "meditacionAlcanza",
                ActivityMeditacionAlcanza.like, storage, usuario
            )
        }

        btn_play_meditacion_alcanza.setOnClickListener {
            // Se utiliza el id de los videos
            val intent = YouTubeStandalonePlayer.createVideoIntent(this, API_KEY, "KeJsHX-uaAo")
            startActivity(intent)
        }

    }


    fun obtenerEstadoFavorito() {
        val favoritosRef: DocumentReference = storage.collection("favoritos")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("meditacionAlcanza") != null) {
                ActivityMeditacionAlcanza.like = it.get("meditacionAlcanza")!! as Boolean
                if (ActivityMeditacionAlcanza.like) {
                    Favorito.devolverAnimacion(
                        like_meditacion_alcanza, R.raw.apple_event,
                        ActivityMeditacionAlcanza.like
                    )
                }
                Toast.makeText(
                    this,
                    "Valor obtenido de firebase: " + it.get("meditacionAlcanza") as Boolean,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Favorito.crearDocumento(storage, usuario)
                Toast.makeText(
                    this,
                    "No de se ha creado la colección de favoritos: ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}