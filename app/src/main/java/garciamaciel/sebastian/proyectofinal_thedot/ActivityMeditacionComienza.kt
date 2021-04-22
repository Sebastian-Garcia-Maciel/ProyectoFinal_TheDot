package garciamaciel.sebastian.proyectofinal_thedot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityMeditacionComienza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion_comienza)
        /* Ocultar action bar */
        supportActionBar?.hide()
    }
}