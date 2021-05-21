package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.Inicio1
import kotlinx.android.synthetic.main.activity_afirmaciones.*
import kotlinx.android.synthetic.main.activity_crear_afirmacion.*

class ActivityAfirmaciones : AppCompatActivity() {

    private var adapter: AdaptadorAfirmacion? = null
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    companion object {
        var afirmaciones = ArrayList<Afirmacion>()
        var first = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_afirmaciones)
        supportActionBar?.hide()

        afirmaciones = ArrayList()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        fillAfirmaciones()
        if (!afirmaciones.isEmpty()) {
            var gridView: GridView = findViewById(R.id.gridViewAfirmaciones)
        }


        adapter = AdaptadorAfirmacion(this, afirmaciones)
        var gridView: GridView = this.findViewById(R.id.gridViewAfirmaciones)

        gridView.adapter = adapter

        btn_afirmaciones.setOnClickListener {
            var intent: Intent = Intent(this, ActivityCrearAfirmacion::class.java)
            startActivity(intent)

        }
        btn_regresar_afirmaciones.setOnClickListener {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)

        }


    }

    fun fillAfirmaciones() {
        storage.collection("afirmaciones")
            .whereEqualTo("afirmacion", usuario.currentUser?.email)
            .get().addOnSuccessListener {
                it.forEach {
                    afirmaciones!!.add(Afirmacion(it.getString("afirmacion")!!))
                }
                adapter = AdaptadorAfirmacion(this, afirmaciones)
                gridViewAfirmaciones.adapter = adapter

                Toast.makeText(
                    this,
                    "Se accedio a la colección",
                    Toast.LENGTH_SHORT
                ).show()
            }.addOnFailureListener {
                Toast.makeText(
                    this,
                    "No se ha podido acceder a la colección, de nuevo porfavor",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }


}

