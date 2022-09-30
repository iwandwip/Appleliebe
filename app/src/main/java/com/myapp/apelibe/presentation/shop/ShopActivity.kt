package com.myapp.apelibe.presentation.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.apelibe.R
import com.myapp.apelibe.databinding.ActivityShopBinding
import com.myapp.apelibe.presentation.main.MainActivity
import org.jetbrains.anko.startActivity

class ShopActivity : AppCompatActivity() {

    private lateinit var shopBinding: ActivityShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shopBinding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(shopBinding.root)

        onAction()
    }

    private fun onAction() {
        shopBinding.apply {
            btnCloseShop.setOnClickListener {
                startActivity<MainActivity>() //Add New
                finish()
            }
        }
    }
}