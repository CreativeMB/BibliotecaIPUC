package com.example.musicav01

import android.content.Intent
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGohome = findViewById<Button>(R.id.btn_go_to_home)
        btnGohome.setOnClickListener {
            gotohome()

        }

        val switch = findViewById<Switch>(R.id.v_cambio)
        val ivModo = findViewById<ImageView>(R.id.ic_oscuro)

        switch.setOnCheckedChangeListener { _, _ ->
            if (switch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switch.text = "Desactivar modo oscuro: "
                ivModo.setImageResource(R.drawable.ic_oscuro)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switch.text = "Activar modo oscuro: "
                ivModo.setImageResource(R.drawable.ic_luz)
            }
        }

    }

    private fun gotohome() {
        val i = Intent(this, homeActivity::class.java)
        startActivity(i)
    }
}