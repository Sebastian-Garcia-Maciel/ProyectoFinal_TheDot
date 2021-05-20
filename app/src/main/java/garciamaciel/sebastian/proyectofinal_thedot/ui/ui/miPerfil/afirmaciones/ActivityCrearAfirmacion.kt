package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.activity_crear_afirmacion.*

class ActivityCrearAfirmacion : AppCompatActivity() {
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    private var adaptador: AdaptadorAfirmacion? = null
    var afirmaciones = ArrayList<Afirmacion>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_afirmacion)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()


        btn_agregar_afirmacion.setOnClickListener() {
            val afirmacion = hashMapOf("afirmacion" to et_nueva_afirmacion.text.toString())
            storage.collection("afirmaciones")
                .add(afirmacion)
                .addOnSuccessListener {
                    Toast.makeText(
                        this.btn_agregar_afirmacion.context,
                        "Afirmación agregada.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this.btn_agregar_afirmacion.context ,
                        "Intente agregar de nuevo porfavor",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }

        btn_regresar_de_nueva_afirmacion.setOnClickListener{
            var intent: Intent = Intent(this, ActivityAfirmaciones::class.java)
            startActivity(intent)
        }


    }
}