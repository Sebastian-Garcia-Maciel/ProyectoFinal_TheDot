package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.inicioSesion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import garciamaciel.sebastian.proyectofinal_thedot.R

class ReestablecerContrasenia : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reestablecer_contrasenia)

        auth = Firebase.auth

        val btn_restablecer: Button = findViewById(R.id.btn_restablecer)

        btn_restablecer.setOnClickListener {
            val et_correo: EditText = findViewById(R.id.et_correo_cont)

            var correo: String = et_correo.text.toString()

            if (!correo.isNullOrBlank()) {
                //enviarcorreo


                auth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this, "Se envio un correo al $correo",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this, "Error al enviar correo",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(
                    this, "Ingresar correo",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}