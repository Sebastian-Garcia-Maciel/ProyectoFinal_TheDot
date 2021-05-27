package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.inicioSesion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.activity_recuperar_contrasenia.*

class RecuperarContrasenia : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_contrasenia)
        supportActionBar?.hide()

        btn_recuperar.setOnClickListener{


            var correo: String = et_correo.text.toString()

            if(!correo.isNullOrBlank()){

                auth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener{ task ->

                        if(task .isSuccessful){
                            Toast.makeText(this, "Se envio la restauracion al correo $correo",
                                Toast.LENGTH_SHORT).show()
                            Thread.sleep(4*1000);
                            et_correo.setText("")
                        }else{
                            Toast.makeText(this, "Error al enviar correo",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this,"Ingresar correo",
                    Toast.LENGTH_SHORT).show()
            }
        }
        btn_regresar.setOnClickListener{
            var intent: Intent = Intent(this, IniciaSesion::class.java)
            startActivity(intent)
        }
    }
}