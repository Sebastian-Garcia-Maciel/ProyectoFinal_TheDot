package garciamaciel.sebastian.proyectofinal_thedot.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.util.Log
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import garciamaciel.sebastian.proyectofinal_thedot.R

class Favorito {




    companion object {



        // Referencia al documento de favoritos


        fun likeAnimation(
            imageView: LottieAnimationView,
            animation: Int,
            like: Boolean
        ): Boolean {

            if (!like) {
                imageView.setAnimation(animation)
                imageView.playAnimation()
            } else {
                imageView.animate()
                    .alpha(0f)
                    .setDuration(200)
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationEnd(animator: Animator) {
                            imageView.setImageResource(R.drawable.icono_like)
                            imageView.alpha = 1f
                        }

                    })

            }
            return !like
        }

        fun devolverAnimacion(
            imageView: LottieAnimationView,
            animation: Int,
            like: Boolean
        ) {

            if (like) {
                imageView.setAnimation(animation)
                imageView.playAnimation()
            } else {
                imageView.animate()
                    .alpha(0f)
                    .setDuration(200)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animator: Animator) {
                            imageView.setImageResource(R.drawable.icono_like)
                            imageView.alpha = 1f
                        }

                    })

            }
        }

        fun crearDocumento(storage:FirebaseFirestore, usuario:FirebaseAuth) {

            val  favoritosRef: DocumentReference = storage.collection("favoritos")
                .document(usuario.currentUser?.email.toString())
            val afirmacion = hashMapOf(
                "estiramientoPasivo" to false,
                "estiramientoActivo" to false,
                "estiramientoEstatico" to false,
                "meditacionAlcanza" to false,
                "meditacionComienza" to false,
                "meditacionLidia" to false,
                "meditacionAtras" to false,
                "respiracionCompleta" to false,
                "respiracionMuscular" to false,
                "respiracionProfunda" to false,
                "tecnicaDedos" to false,
                "tecnicaMuevete" to false,
                "tecnicaTrazos" to false
            )
            favoritosRef.set(afirmacion)
        }

        fun actualizarDocumento(pantalla: String, like: Boolean, storage:FirebaseFirestore, usuario:FirebaseAuth) {
            val  favoritosRef: DocumentReference = storage.collection("favoritos")
                .document(usuario.currentUser?.email.toString())
            // Actualiza un documento
            favoritosRef
                .update(pantalla, like)
                .addOnSuccessListener { Log.d("si", "DocumentSnapshot successfully updated!") }
                .addOnFailureListener { e -> Log.w("no", "Error updating document", e) }
        }
    }
}