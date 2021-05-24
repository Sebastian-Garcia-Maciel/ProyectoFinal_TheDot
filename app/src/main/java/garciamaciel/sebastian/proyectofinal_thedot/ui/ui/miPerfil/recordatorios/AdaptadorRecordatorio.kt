package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.recordatorios

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import garciamaciel.sebastian.proyectofinal_thedot.R
import garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones.Afirmacion
import kotlinx.android.synthetic.main.afirmaciones_view.view.*
import kotlinx.android.synthetic.main.recordatorios_view.view.*

class AdaptadorRecordatorio: BaseAdapter {
    var recordatorios = ArrayList<Recordatorio>()
    var context: Context? = null

    constructor(context: Context, recordatorios: ArrayList<Recordatorio>){
        this.context = context
        this.recordatorios = recordatorios
    }

    override fun getCount(): Int {
        return recordatorios.size
    }

    override fun getItem(position: Int): Any {
        return recordatorios[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var recordatorio = recordatorios[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.recordatorios_view, null)
        vista.tvDescripcionRecordatorio.setText(recordatorio.descripcion)
        vista.tvHorarioRecordatorio.setText(recordatorio.horario)
        vista.tvTituloRecordatorio.setText(recordatorio.titulo)
        return vista
    }
}