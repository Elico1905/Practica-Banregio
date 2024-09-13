package com.balamcode.practicabanregio.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.balamcode.practicabanregio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)

    }
}