package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento.ActivityEstiramientoPasivo
import kotlinx.android.synthetic.main.activity_estiramiento_pasivo.*
import kotlinx.android.synthetic.main.activity_muevete.*

class ActivityMuevete : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    lateinit var usuario: FirebaseAuth


    companion object {
        var like: Boolean = false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muevete)
        /*Oculta la action bar*/
        supportActionBar?.hide()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        obtenerEstadoFavorito()

        val btnRegresar: ImageButton = findViewById(R.id.boton_regresar_muevete) as ImageButton

        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }

        like_muevete.setOnClickListener {
            like = Favorito.likeAnimation(
                like_muevete, R.raw.apple_event,
                ActivityMuevete.like
            )

            if (!ActivityMuevete.like) {
                Toast.makeText(this, "Se ha eliminado de tus favoritos.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Se ha agregado a tus favoritos.", Toast.LENGTH_SHORT).show()
            }
            Favorito.actualizarDocumento("tecnicaMuevete",
                ActivityMuevete.like, storage, usuario)
        }
    }

    fun obtenerEstadoFavorito() {
        val  favoritosRef: DocumentReference = storage.collection("favoritos")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("tecnicaMuevete") != null) {
                like = it.get("tecnicaMuevete")!! as Boolean
                if (like) {
                    Favorito.devolverAnimacion(
                        like_muevete, R.raw.apple_event,
                        like
                    )
                }
                Toast.makeText(
                    this,
                    "Valor obtenido de firebase: " + it.get("tecnicaMuevete") as Boolean,
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