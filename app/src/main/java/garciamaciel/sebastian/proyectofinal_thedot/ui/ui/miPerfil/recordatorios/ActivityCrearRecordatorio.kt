package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.ActivityAfirmaciones
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.AdaptadorAfirmacion
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.Afirmacion
import kotlinx.android.synthetic.main.activity_afirmaciones.*
import kotlinx.android.synthetic.main.activity_crear_afirmacion.*
import kotlinx.android.synthetic.main.activity_crear_recordatorio.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ActivityCrearRecordatorio : AppCompatActivity() {
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    private var adaptador: AdaptadorRecordatorio? = null
    var recordatorios = ArrayList<Recordatorio>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_recordatorio)
        supportActionBar?.hide()

        // Inicialización firebase
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        btnAgregarRecordatorio.setOnClickListener{
            val recordatorio = hashMapOf(
                "titulo" to etTituloRecordatorio.text.toString(),
                "descripcion" to etDescripcionRecordatorio.text.toString(),
                "email" to usuario.currentUser?.email.toString(),
                "horario" to "Diario - " + btn_time.text.toString())

            storage.collection("recordatorios")
                .add(recordatorio)
                .addOnSuccessListener {
                    Toast.makeText(
                        this.btnAgregarRecordatorio.context,
                        "Recordatorio agregado.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this.btnAgregarRecordatorio.context ,
                        "Intente agregar de nuevo por favor",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }


        btnRegresarNuevoRecordatorio.setOnClickListener{
            var intent: Intent = Intent(this, ActivityRecordatorios::class.java)
            startActivity(intent)
        }


        btn_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                btn_time.text = SimpleDateFormat("HH:mm a").format(cal.time)
            }
            TimePickerDialog(
                this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true
            ).show()
        }
    }


}