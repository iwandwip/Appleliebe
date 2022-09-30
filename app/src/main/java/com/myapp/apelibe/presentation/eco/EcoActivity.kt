package com.myapp.apelibe.presentation.eco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.apelibe.R
import com.myapp.apelibe.databinding.ActivityEcoBinding
import com.myapp.apelibe.presentation.main.MainActivity
import org.jetbrains.anko.startActivity

class EcoActivity : AppCompatActivity() {

    private lateinit var ecoBinding: ActivityEcoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ecoBinding = ActivityEcoBinding.inflate(layoutInflater)
        setContentView(ecoBinding.root)

        onAction()
    }

    private fun onAction() {
        ecoBinding.apply {
            btnCloseEco.setOnClickListener {
                startActivity<MainActivity>() //Add New
                finish()
            }
        }
    }
}