package com.myapp.apelibe.presentation.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.apelibe.R
import com.myapp.apelibe.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var userBinding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(userBinding.root)
    }
}