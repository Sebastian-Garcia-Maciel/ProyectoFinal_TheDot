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
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.databinding.ActivityMiPerfilBinding
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.ActivityInicio
import kotlinx.android.synthetic.main.activity_cambiar_perfil.*
import kotlinx.android.synthetic.main.activity_mi_perfil.*
import java.io.File
import java.io.IOException

class CambiarPerfil : AppCompatActivity(), View.OnClickListener {
    private var filePath: Uri? = null

    internal var storage: FirebaseStorage? = null
    internal var storageReference: StorageReference? = null
    private var PICK_IMAGE_REQUEST = 1234
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_perfil)
        supportActionBar?.hide()

        // Init firebase
        storage = FirebaseStorage.getInstance()
        storageReference = storage!!.reference
        usuario = FirebaseAuth.getInstance()

        // Setup Buttons
        btnChoose.setOnClickListener(this)
        btnUpload.setOnClickListener(this)

        btn_regresar_de_nuevo_perfil.setOnClickListener{
            var intent: Intent = Intent(this, MiPerfil::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        if (v == btnChoose)
            showFileChooser()
        else
            uploadFile()
    }


    private fun showFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "SELECT PICTURE"), PICK_IMAGE_REQUEST)
        uploadFile()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imagenPerfilPrueba!!.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadFile() {
        if (filePath != null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Cargando...")
            progressDialog.show()
            val imageRef = storageReference!!.child("images/Profile_" + usuario.currentUser?.email.toString() +".png" )
            imageRef.putFile(filePath!!)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "File upload", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "Failed :c", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener {
                    val progres = 100.0 * it.bytesTransferred / it.totalByteCount
                    progressDialog.setMessage("uploaded" + progres.toInt() + "%...")
                }
        }
    }


}