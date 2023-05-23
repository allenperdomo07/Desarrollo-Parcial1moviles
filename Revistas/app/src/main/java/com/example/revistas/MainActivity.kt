package com.example.revistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.revistas.ui.revista.viewmodel.RevistaViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val revistaViewModel: RevistaViewModel by viewModels {
        RevistaViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        supportActionBar!!.hide()
    }

    override fun onBackPressed() {
        val trans = supportFragmentManager.beginTransaction()
        binding.navHostFragment.id
        if(revistaViewModel.getScreenFragment() == 0){
            super.onBackPressed()
        }

//        trans.replace(R.id.nav_host_fragment, BillBoardFragment())
//        movieViewModel.SetBillboardFragment()
//        trans.commit()}
    }



}

