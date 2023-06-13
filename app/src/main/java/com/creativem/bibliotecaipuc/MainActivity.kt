package com.creativem.bibliotecaipuc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.creativem.bibliotecaipuc.corario.corarioActivity
import com.creativem.bibliotecaipuc.infantiles.infantilesActivity
import com.creativem.bibliotecaipuc.lluvias.lluviasActivity
import com.creativem.bibliotecaipuc.manantil.manantilActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_lluvias = findViewById<Button>(R.id.btn_lluvias)
        val btn_corai = findViewById<Button>(R.id.btn_corai)
        val btn_cora = findViewById<Button>(R.id.btn_cora)
        val btn_manantial = findViewById<Button>(R.id.btn_manantial)

        btn_lluvias.setOnClickListener { navigateUpToApp() }
        btn_corai.setOnClickListener { navigateUpToApp() }
        btn_cora.setOnClickListener { navigateUpToApp() }
        btn_manantial.setOnClickListener { navigateUpToApp() }


    }

    private fun navigateUpToApp() {
        val intent = Intent(this, infantilesActivity::class.java)
        startActivity(intent)
    }

}