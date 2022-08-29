package com.myapp.apelibe.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.myapp.apelibe.R
import com.myapp.apelibe.adapter.MaterialsAdapter
import com.myapp.apelibe.databinding.ActivityMainBinding
import com.myapp.apelibe.presentation.user.UserActivity
import com.myapp.apelibe.repository.Repository
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var materialsAdapter: MaterialsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        //Init
        materialsAdapter = MaterialsAdapter()

        getDataMaterial()
        onAction()
    }

    private fun getDataMaterial() {
        showLoading()
        val materials = Repository.getMaterials(this)

        Handler(Looper.getMainLooper())
            .postDelayed({
                hideLoading()
                materials?.let {
                    materialsAdapter.materials = it
                }
            }, 1200)

        mainBinding.rvMaterialsMain.adapter = materialsAdapter
    }

    private fun showLoading() {
        mainBinding.swipeMain.isRefreshing = true
    }

    private fun hideLoading() {
        mainBinding.swipeMain.isRefreshing = false
    }

    private fun onAction() {
        mainBinding.apply {
            ivAvatarMain.setOnClickListener {
                startActivity<UserActivity>()
            }

            etSearchMain.addTextChangedListener {
                materialsAdapter.filter.filter(it.toString())
            }

            etSearchMain.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    val dataSearch = etSearchMain.text.toString().trim()
                    materialsAdapter.filter.filter(dataSearch)
                    return@setOnEditorActionListener true
                }

                return@setOnEditorActionListener false
            }

            swipeMain.setOnRefreshListener {
                getDataMaterial()
            }
        }
    }
}