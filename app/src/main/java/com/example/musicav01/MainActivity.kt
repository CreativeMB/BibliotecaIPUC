package com.example.musicav01

import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    val fd by lazy {
        assets.openFd(cancionActual)

    }

    val mp by lazy {
        val m = MediaPlayer()
        m.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        fd.close()
        m.prepare()
        m
    }

    val controllers by lazy {
        listOf(R.id.atras, R.id.siguiente, R.id.play, R.id.stop).map {
            findViewById<MaterialButton>(it)
        }
    }

    object ci {
        val prev = 0
        val stop = 3
        val play = 2
        val next = 1

    }

    val nombrecancion by lazy {
        findViewById<TextView>(R.id.row_nombrecancion)
    }

    val canciones by lazy {
        val nombreFicheros = assets.list("")?.toList() ?: listOf()
        nombreFicheros.filter { it.contains(".mp3") }
    }
    var cancionActualIndex = 0
        set(value) {
            var v = if (value == -1) {
                canciones.size - 1
            } else {
                value % canciones.size
            }
            field = v
            cancionActual = canciones[v]
        }
    lateinit var cancionActual: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controllers[ci.play].setOnClickListener(this::playClicked)
        controllers[ci.stop].setOnClickListener(this::stopCliked)
        controllers[ci.prev].setOnClickListener(this::prevClicked)
        controllers[ci.next].setOnClickListener(this::nextClicked)
        cancionActual = canciones[cancionActualIndex]
        nombrecancion.text = cancionActual

    }

    override fun onStart() {
        super.onStart()
        findViewById<RecyclerView>(R.id.rv).apply {
            adapter = AdaptadorCanciones(canciones, this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)



        val switch = findViewById<Switch>(R.id.v_cambio)
        val ivModo = findViewById<ImageView>(R.id.ic_oscuro)

        switch.setOnCheckedChangeListener { _, _ ->
            if (switch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switch.text = "Desactivar modo oscuro: "
                ivModo.setImageResource(R.drawable.ic_oscuro)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switch.text = "Activar modo oscuro: "
                ivModo.setImageResource(R.drawable.ic_luz)
            }

        }
    }

    fun playClicked(v: View) {
        if (!mp.isPlaying) {
            mp.start()
            controllers[ci.play].setIconResource(R.drawable.baseline_pause_circle_filled_48)
            nombrecancion.visibility = View.VISIBLE

        } else {
            mp.pause()
            controllers[ci.play].setIconResource(R.drawable.baseline_play_circle_filled_24)

        }
    }

    fun stopCliked(v: View) {
        if (mp.isPlaying) {
            mp.pause()
            controllers[ci.play].setIconResource(R.drawable.baseline_play_circle_filled_24)
            nombrecancion.visibility = View.INVISIBLE

        }
        mp.seekTo(0)
    }

    fun nextClicked(v: View){
        cancionActualIndex++
        refreshoSong()
    }
    fun prevClicked(v:View){
        cancionActualIndex--
        refreshoSong()
    }


    fun refreshoSong(){
        mp.reset()
        val fd = assets.openFd(cancionActual)
        mp.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        mp.prepare()
        playClicked(controllers[ci.play])
        nombrecancion.text = cancionActual

    }



}