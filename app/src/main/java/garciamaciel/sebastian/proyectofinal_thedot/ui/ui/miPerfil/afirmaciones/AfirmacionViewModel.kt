package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AfirmacionViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is afirmacion fragment"
    }
    val text: LiveData<String> = _text
}