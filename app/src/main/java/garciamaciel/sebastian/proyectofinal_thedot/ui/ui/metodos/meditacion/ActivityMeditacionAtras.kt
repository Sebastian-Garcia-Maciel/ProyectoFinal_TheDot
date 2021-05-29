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
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.ActivityDedos
import kotlinx.android.synthetic.main.activity_dedos.*
import kotlinx.android.synthetic.main.activity_meditacion_alcanza.*
import kotlinx.android.synthetic.main.activity_meditacion_atras.*

class ActivityMeditacionAtras : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    lateinit var usuario: FirebaseAuth
    val API_KEY = "AIzaSyAaOARnYN9G37K4xzQMk50r86DDZRpm_l0"


    companion object {
        var like: Boolean = false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion_atras)
        supportActionBar?.hide()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        obtenerEstadoFavorito()

        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarAt) as ImageButton
        btnRegresar.setOnClickListener {
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }

        like_meditacion_atras.setOnClickListener {
            like = Favorito.likeAnimation(
                like_meditacion_atras, R.raw.apple_event,
                like
            )

            if (!like) {
                Toast.makeText(this, "Se ha eliminado de tus favoritos.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Se ha agregado a tus favoritos.", Toast.LENGTH_SHORT).show()
            }
            Favorito.actualizarDocumento(
                "meditacionAtras",
                like, storage, usuario
            )
        }

        btn_play_meditacion_atras.setOnClickListener {
            // Se utiliza el id de los videos
            val intent = YouTubeStandalonePlayer.createVideoIntent(this, API_KEY, "YuEBtH_FWQk")
            startActivity(intent)
        }

    }

    fun obtenerEstadoFavorito() {
        val favoritosRef: DocumentReference = storage.collection("favoritos")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("meditacionAtras") != null) {
                like = it.get("meditacionAtras")!! as Boolean
                if (like) {
                    Favorito.devolverAnimacion(
                        like_meditacion_atras, R.raw.apple_event,
                        like
                    )
                }
                Toast.makeText(
                    this,
                    "Valor obtenido de firebase: " + it.get("meditacionAtras") as Boolean,
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