package garciamaciel.sebastian.proyectofinal_thedot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class IniciaSesion : AppCompatActivity() {

    val RC_SIGN_IN = 123
    val COD_LOGOUT = 323
    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicia_sesion)
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        /*Oculta la action bar*/
        supportActionBar?.hide()
        val botonRegresar: ImageButton =
            findViewById<ImageButton>(R.id.boton_regresar_inicia_sesion)
        val botonIniciarSesion = findViewById<Button>(R.id.boton_inicia_sesion)
        val botonIniciaSesionGoogle: com.google.android.gms.common.SignInButton =
            findViewById<com.google.android.gms.common.SignInButton>(
                R.id.sign_in_button
            )


        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        botonIniciaSesionGoogle.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        botonRegresar.setOnClickListener() {
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        botonIniciarSesion.setOnClickListener() {
            var intent: Intent = Intent(this, Inicio1::class.java)
            startActivity(intent)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }

        if(requestCode== COD_LOGOUT){
            signOut()
        }
    }

    override fun onStart() {
        super.onStart()
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }


    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                Toast.makeText(this, "Sesión Terminada", Toast.LENGTH_SHORT).show()
                // ...
            }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            // Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        if (account != null){
            val intent:Intent = Intent(this, Inicio1::class.java)
            intent.putExtra("name", account.displayName)
            startActivityForResult(intent, COD_LOGOUT)

        }
    }


}

