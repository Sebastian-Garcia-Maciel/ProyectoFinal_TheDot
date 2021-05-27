package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios.ActivityRecordatorios
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos.tecnicas.Tecnicas
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.ActivityAfirmaciones
import kotlinx.android.synthetic.main.activity_mi_perfil.*
import kotlinx.android.synthetic.main.activity_prueba_imagen.*
import java.io.File
import java.io.IOException

class MiPerfil : AppCompatActivity() {

    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)
        supportActionBar?.hide()
        usuario = FirebaseAuth.getInstance()
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


}