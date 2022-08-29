package com.myapp.apelibe.presentation.content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.apelibe.R
import com.myapp.apelibe.databinding.ActivityContentBinding
import org.jetbrains.anko.toast

class ContentActivity : AppCompatActivity() {

    private lateinit var contentBinding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentBinding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(contentBinding.root)

        onAction()
    }

    private fun onAction() {
        contentBinding.apply {
            btnCloseContent.setOnClickListener { finish() }

            btnNextContent.setOnClickListener {
                toast("Next")
            }

            btnPrevContent.setOnClickListener {
                toast("Previous")
            }
        }
    }
}