package garciamaciel.sebastian.proyectofinal_thedot.ui.ui.miPerfil.afirmaciones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import garciamaciel.sebastian.proyectofinal_thedot.R
import kotlinx.android.synthetic.main.afirmaciones_view.view.*


class AdaptadorAfirmacion : BaseAdapter {
    var afirmaciones = ArrayList<Afirmacion>()
    var context: Context? = null

    constructor(context: Context, afirmaciones: ArrayList<Afirmacion>){
        this.context = context
        this.afirmaciones = afirmaciones
    }

    override fun getCount(): Int {
        return afirmaciones.size
    }

    override fun getItem(position: Int): Any {
        return afirmaciones[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var afirmacion = afirmaciones[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.afirmaciones_view, null)
        vista.tv_afirmacion.setText(afirmacion.textoAfirmacion)

        return vista
    }
}