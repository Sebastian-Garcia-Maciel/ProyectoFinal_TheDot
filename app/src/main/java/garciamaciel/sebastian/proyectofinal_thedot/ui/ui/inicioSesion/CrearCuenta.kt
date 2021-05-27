package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.inicioSesion

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.MainActivity
import kotlinx.android.synthetic.main.activity_crear_cuenta.*

class CrearCuenta : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var storage: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)
        supportActionBar?.hide()
        auth = Firebase.auth

        /*Oculta la action bar*/


        storage = FirebaseFirestore.getInstance()
        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.boton_regresar_crear_cuenta)
        val botonCrearCuenta:Button = findViewById<Button>(R.id.boton_crea_cuenta)



        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        botonCrearCuenta.setOnClickListener() {
            valida_registro()
        }
    }

    private fun valida_registro(){
        val et_nombre: EditText = findViewById(R.id.etNombreUsuario)
        val et_correo: EditText = findViewById(R.id.etCorreo)
        val et_contra1: EditText = findViewById(R.id.etContraseña)
        val et_contra2: EditText = findViewById(R.id.etConfirmacion)

        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        var contra2: String = et_contra2.text.toString()
        var nombre: String = et_nombre.text.toString()

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank() && !nombre.isNullOrBlank()){

            if(contra1 == contra2){

                registrarFirebase(correo,contra1)


            }else{
                Toast.makeText(this, "Las contraseña no coinciden",
                    Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun limpiarFormulario(){
        etNombreUsuario.setText("")
        etCorreo.setText("")
        etContraseña.setText("")
        etConfirmacion.setText("")
    }

    private fun registrarFirebase(email: String,password: String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    Toast.makeText(baseContext, "El correo " + auth.currentUser?.email.toString() + " ha sido correctamente registrado.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(user)
                    crearDocumento()
                    this.limpiarFormulario()
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }

    fun crearDocumento() {

        val  favoritosRef: DocumentReference = storage.collection("usuarios")
            .document()
        val nuevoUsuario = hashMapOf(
            "nombreUsuario" to etNombreUsuario.text.toString(),
            "email" to auth.currentUser?.email.toString(),
            "descripcion" to ""
        )
        favoritosRef.set(nuevoUsuario)
    }
}