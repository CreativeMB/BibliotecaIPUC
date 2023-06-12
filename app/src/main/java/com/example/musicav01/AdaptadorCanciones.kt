package com.example.musicav01

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicav01.databinding.RowSongBinding

class AdaptadorCanciones(val elementos:List<String>, val con:MainActivity)
    : RecyclerView.Adapter<AdaptadorCanciones.ViewHolder>() {

    var selected = -1

    class ViewHolder(val bind: RowSongBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorCanciones.ViewHolder {
        val v = RowSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: AdaptadorCanciones.ViewHolder, position: Int) {
        val elem = elementos[position]
        with(holder.bind) {
            if (position==selected){
                rowCancion.setBackgroundColor(Color.LTGRAY)
            }
            else{
                rowCancion.setBackgroundColor(Color.TRANSPARENT)
            }
            rowNombrecancion.text = elem
            rowCancion.setOnClickListener {
                con.cancionActualIndex = position
                con.refreshoSong()
                selected = position
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return elementos.size
    }
}




