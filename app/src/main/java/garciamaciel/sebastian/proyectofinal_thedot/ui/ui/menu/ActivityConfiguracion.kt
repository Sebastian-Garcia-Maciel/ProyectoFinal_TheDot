package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.MainActivity

class ActivityConfiguracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        supportActionBar?.hide()

        val botonRegresar:ImageButton = findViewById<ImageButton>(R.id.btnRegresarConfiguracion)
        val botonCerrarSesion = findViewById<Button>(R.id.btnConfiguracion)


        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, ActivityInicio::class.java)
            startActivity(intent)
        }

        botonCerrarSesion.setOnClickListener{
            // Cerrar sesión firebase
            Firebase.auth.signOut()
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}