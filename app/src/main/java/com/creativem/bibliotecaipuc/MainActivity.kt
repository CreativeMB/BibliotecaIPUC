package com.creativem.bibliotecaipuc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.creativem.bibliotecaipuc.corario.corarioActivity
import com.creativem.bibliotecaipuc.infantiles.infantilesActivity
import com.creativem.bibliotecaipuc.lluvias.lluviasActivity
import com.creativem.bibliotecaipuc.manantil.manantilActivity
import com.creativem.bibliotecaipuc.mp3.mp3Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_lluvias = findViewById<Button>(R.id.btn_lluvias)
        val btn_corai = findViewById<Button>(R.id.btn_corai)
        val btn_cora = findViewById<Button>(R.id.btn_cora)
        val btn_manantial = findViewById<Button>(R.id.btn_manantial)
        val btn_mp3 = findViewById<Button>(R.id.btn_mp3)

        btn_mp3.setOnClickListener {navigateUpTomp3() }
        btn_lluvias.setOnClickListener { navigateUpTolluvias() }
        btn_corai.setOnClickListener { navigateUpTocorai() }
        btn_cora.setOnClickListener { navigateUpTocora() }
        btn_manantial.setOnClickListener { navigateUpTomanantial() }


    }

    private fun navigateUpTomp3() {
        val intent = Intent(this, mp3Activity::class.java)
        startActivity(intent)
    }

    private fun navigateUpTomanantial() {
        val intent = Intent(this, manantilActivity::class.java)
        startActivity(intent)
    }

    private fun navigateUpTocora() {
        val intent = Intent(this, infantilesActivity::class.java)
        startActivity(intent)
    }

    private fun navigateUpTocorai() {
        val intent = Intent(this, corarioActivity::class.java)
        startActivity(intent)
    }

    private fun navigateUpTolluvias() {
        val intent = Intent(this, lluviasActivity::class.java)
        startActivity(intent)
    }



}