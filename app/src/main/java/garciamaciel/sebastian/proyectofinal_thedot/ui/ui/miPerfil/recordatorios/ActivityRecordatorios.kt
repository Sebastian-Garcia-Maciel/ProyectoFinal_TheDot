package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.MiPerfil
import kotlinx.android.synthetic.main.activity_recordatorios.*

class ActivityRecordatorios : AppCompatActivity() {
    private var adapter: AdaptadorRecordatorio? = null
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    companion object {
        var recordatorios = ArrayList<Recordatorio>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordatorios)
        supportActionBar?.hide()

        ActivityRecordatorios.recordatorios = ArrayList()
        // Instancia de firebase
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        fillRecordatorios()
        if (!ActivityRecordatorios.recordatorios.isEmpty()) {
            var gridView: GridView = findViewById(R.id.grid_view_recordatorios)
        }

        adapter = AdaptadorRecordatorio(this, ActivityRecordatorios.recordatorios)
        var gridView: GridView = this.findViewById(R.id.grid_view_recordatorios)

        gridView.adapter = adapter

        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarMI) as ImageButton


        btnRegresar.setOnClickListener {
            var intent: Intent = Intent(this, MiPerfil::class.java)
            startActivity(intent)
        }

        btnNuevoRecordatorio.setOnClickListener {
            var intent: Intent = Intent(this, ActivityCrearRecordatorio::class.java)
            startActivity(intent)
        }
    }

    fun fillRecordatorios() {
        storage.collection("recordatorios")
            .whereEqualTo("email", usuario.currentUser?.email)
            .get().addOnSuccessListener {
                it.forEach {
                    recordatorios!!.add(
                        Recordatorio(it.getString("titulo"),
                            it.getString("descripcion"),
                            it.getString("horario")
                        )
                    )
                }
                adapter = AdaptadorRecordatorio(this, recordatorios)
                grid_view_recordatorios.adapter = adapter

                Toast.makeText(
                    this,
                    "Accediste a tus recordatorios",
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