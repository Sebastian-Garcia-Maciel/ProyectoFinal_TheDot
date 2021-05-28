package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.journal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento.ActivityEstiramientoActivo
import kotlinx.android.synthetic.main.activity_como_estas.*
import kotlinx.android.synthetic.main.activity_estiramiento_activo.*
import kotlinx.android.synthetic.main.activity_mi_perfil.descripcionPerfil

class ActivityComoEstas : AppCompatActivity() {
    lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_como_estas)
        /*Oculta la action bar*/
        supportActionBar?.hide()
        usuario = FirebaseAuth.getInstance()
        storage = FirebaseFirestore.getInstance()
        obtenerEstadoDocumento()

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.boton_regresar_como_estas)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, Journal::class.java)
            startActivity(intent)
        }

        como_estas_hoy.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //System.out.println(s.toString() + " " + start + " " + count + " " + after);
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //System.out.println(s.toString() + " " + start + " " + count);
            }

            override fun afterTextChanged(s: Editable) {
                val  favoritosRef: DocumentReference = storage.collection("journal")
                    .document(usuario.currentUser?.email.toString())
                // Actualiza un documento
                favoritosRef
                    .update("descripcion", descripcionPerfil.text.toString())
                    .addOnSuccessListener { Log.d("si", "DocumentSnapshot successfully updated!") }
                    .addOnFailureListener { e ->
                        Log.w("no", "Error updating document", e) }
            }
        })
    }

    fun obtenerEstadoDocumento() {
        val  favoritosRef: DocumentReference = storage.collection("journal")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("comoEstas")!= null) {
                como_estas_hoy.setText(it.get("comoEstas")!! as String)
            } else{
                Toast.makeText(
                    this,
                    "No de se ha creado la colección de favoritos: ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}