package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.Favorito
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.estiramiento.ActivityEstiramientoActivo
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.Tecnicas
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.ActivityAfirmaciones
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios.ActivityRecordatorios
import kotlinx.android.synthetic.main.activity_estiramiento_activo.*
import kotlinx.android.synthetic.main.activity_mi_perfil.*
import java.io.File


class MiPerfil : AppCompatActivity() {

    lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)
        supportActionBar?.hide()
        usuario = FirebaseAuth.getInstance()
        storage = FirebaseFirestore.getInstance()
        obtenerUsuario()
        descargarImagen()

        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarPerfil) as ImageButton
        val btnRecordatorios: LinearLayout = findViewById(R.id.btnRecordatorios) as LinearLayout
        val btnAfirmaciones: LinearLayout = findViewById(R.id.btnAfirmaciones) as LinearLayout
        val btnMetas: LinearLayout = findViewById(R.id.btnMetas) as LinearLayout
        val btnTecnicas: LinearLayout = findViewById(R.id.btnAgenda) as LinearLayout


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityInicio::class.java)
            startActivity(intent)
        }
        btnRecordatorios.setOnClickListener {
            var intent: Intent = Intent(this, ActivityRecordatorios::class.java)
            startActivity(intent)
        }
        btnAfirmaciones.setOnClickListener {
            var intent: Intent = Intent(this, ActivityAfirmaciones::class.java)
            startActivity(intent)
        }
        btnMetas.setOnClickListener {
            var intent: Intent = Intent(this, ActivityRecordatorios::class.java)
            startActivity(intent)
        }
        btnTecnicas.setOnClickListener {
            var intent: Intent = Intent(this, Tecnicas::class.java)
            startActivity(intent)
        }

        btnAgenda.setOnClickListener{
            var intent: Intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

        btnCambiarPerfil.setOnClickListener{
            var intent: Intent = Intent(this, CambiarPerfil::class.java)
            startActivity(intent)
        }

        descripcionPerfil.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //System.out.println(s.toString() + " " + start + " " + count + " " + after);
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //System.out.println(s.toString() + " " + start + " " + count);
            }

            override fun afterTextChanged(s: Editable) {
                val  favoritosRef: DocumentReference = storage.collection("usuarios")
                    .document(usuario.currentUser?.email.toString())
                // Actualiza un documento
                favoritosRef
                    .update("descripcion", descripcionPerfil.text.toString())
                    .addOnSuccessListener { Log.d("si", "DocumentSnapshot successfully updated!") }
                    .addOnFailureListener { e -> Log.w("no", "Error updating document", e) }
            }
        })
    }
    private fun descargarImagen() {
        val storageRef = Firebase.storage.reference.child("images/Profile_" + usuario.currentUser?.email.toString() +".png")
        val localFile = File.createTempFile("Profile", "png")
        storageRef.getFile(localFile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
            imagenPerfil.setImageBitmap(bitmap)
        }.addOnFailureListener{
            it.printStackTrace()
        }
    }

    fun obtenerUsuario() {
        val  favoritosRef: DocumentReference = storage.collection("usuarios")
            .document(usuario.currentUser?.email.toString())
        favoritosRef.get().addOnSuccessListener {
            if (it.get("nombreUsuario")!= null && it.get("descripcion")!=null){
                etNamePerfil.text = it.get("nombreUsuario") as String
                descripcionPerfil.setText(it.get("descripcion") as String)

                if (ActivityEstiramientoActivo.like) {
                    Favorito.devolverAnimacion(like_estiramiento_activo, R.raw.apple_event,
                        ActivityEstiramientoActivo.like
                    )
                }
            }
        }
    }



}