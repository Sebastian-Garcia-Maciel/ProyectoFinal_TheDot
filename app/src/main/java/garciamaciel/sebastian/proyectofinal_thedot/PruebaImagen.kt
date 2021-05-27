package garciamaciel.sebastian.proyectofinal_thedot

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_prueba_imagen.*
import java.io.IOException
import java.util.*

class PruebaImagen : AppCompatActivity(), View.OnClickListener {
    private var filePath: Uri? = null

    internal var storage: FirebaseStorage? = null
    internal var storageReference: StorageReference? = null
    private var PICK_IMAGE_REQUEST = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba_imagen)

        // Init firebase
        storage = FirebaseStorage.getInstance()
        storageReference = storage!!.reference

        // Setup Buttons
        btnChoose.setOnClickListener(this)
        btnUpload.setOnClickListener(this)
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
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imageView!!.setImageBitmap(bitmap)
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

            val imageRef = storageReference!!.child("images/" + UUID.randomUUID().toString())
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