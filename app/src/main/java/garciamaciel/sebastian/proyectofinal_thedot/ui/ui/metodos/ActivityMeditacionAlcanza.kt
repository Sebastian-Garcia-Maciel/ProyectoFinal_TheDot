package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.metodos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.youtube.player.YouTubeStandalonePlayer
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.activity_meditacion_alcanza.*

class ActivityMeditacionAlcanza : AppCompatActivity() {
    val API_KEY="AIzaSyAoH3FgpagT083EL8sS5UuoZyWVlGkfnhI"
    companion object {
        var like: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditacion_alcanza)
        supportActionBar?.hide()
        val btnRegresar: ImageButton = findViewById(R.id.btnRegresarMA) as ImageButton


        btnRegresar.setOnClickListener{
            var intent: Intent = Intent(this, ActivityMeditacion::class.java)
            startActivity(intent)
        }

        btnPlay.setOnClickListener{
            val intent = YouTubeStandalonePlayer.createVideoIntent(this,API_KEY,"My8WuZXvySA")
            startActivity(intent)
        }

    }
}