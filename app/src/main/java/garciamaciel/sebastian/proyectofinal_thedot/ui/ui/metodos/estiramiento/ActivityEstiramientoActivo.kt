package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import kotlinx.android.synthetic.main.activity_estiramiento_activo.*

class ActivityEstiramientoActivo : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    lateinit var usuario: FirebaseAuth


    companion object {
        var like: Boolean = false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estiramiento_activo)


        /* Oculta la action bar*/
        supportActionBar?.hide()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        obtenerEstadoFavorito()

        val botonRegresar: ImageButton =
            findViewById<ImageButton>(R.id.boton_regresar_estiramiento_activo)





        like_estiramiento_activo.setOnClickListener {
            like = Favorito.likeAnimation(like_estiramiento_activo, R.raw.apple_event, like)

            if (!like) {
                Toast.makeText(this, "Se ha eliminado de tus favoritos.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Se ha agregado a tus favoritos.", Toast.LENGTH_SHORT).show()
            }
            Favorito.actualizarDocumento("estiramientoActivo", like, storage, usuario)
        }

        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityEstiramiento::class.java)
            startActivity(intent)

        }
    }





    fun obtenerEstadoFavorito() {
        val  favoritosRef: DocumentReference = storage.collection("favoritos")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("estiramientoActivo")!= null){
                ActivityEstiramientoActivo.like = it.get("estiramientoActivo")!! as Boolean
                if (like) {
                    Favorito.devolverAnimacion(like_estiramiento_activo, R.raw.apple_event, like)
                }
                Toast.makeText(
                    this,
                    "Valor obtenido de firebase: " + it.get("estiramientoActivo") as Boolean,
                    Toast.LENGTH_SHORT
                ).show()
            } else{
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


