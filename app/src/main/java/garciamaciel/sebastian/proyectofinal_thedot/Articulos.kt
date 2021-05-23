package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.About
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.menu.TheDot
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_the_dot.*

class Articulos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulos)
        supportActionBar?.hide()

        btnRegresarTD.setOnClickListener{
            var intent: Intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}