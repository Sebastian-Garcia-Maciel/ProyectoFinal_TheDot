package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import kotlinx.android.synthetic.main.activity_dedos.*

class ActivityDedos : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    lateinit var usuario: FirebaseAuth


    companion object {
        var like: Boolean = false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dedos)
        supportActionBar?.hide()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        obtenerEstadoFavorito()

        btnRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }

        like_dedos.setOnClickListener {
            ActivityDedos.like = Favorito.likeAnimation(
                like_dedos, R.raw.apple_event,
                ActivityDedos.like
            )

            if (!ActivityDedos.like) {
                Toast.makeText(this, "Se ha eliminado de tus favoritos.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Se ha agregado a tus favoritos.", Toast.LENGTH_SHORT).show()
            }
            Favorito.actualizarDocumento(
                "tecnicaDedos",
                ActivityDedos.like, storage, usuario
            )
        }
    }


    fun obtenerEstadoFavorito() {
        val favoritosRef: DocumentReference = storage.collection("favoritos")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("tecnicaDedos") != null) {
                ActivityDedos.like = it.get("tecnicaDedos")!! as Boolean
                if (ActivityDedos.like) {
                    Favorito.devolverAnimacion(
                        like_dedos, R.raw.apple_event,
                        ActivityDedos.like
                    )
                }
                Toast.makeText(
                    this,
                    "Valor obtenido de firebase: " + it.get("tecnicaDedos") as Boolean,
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
