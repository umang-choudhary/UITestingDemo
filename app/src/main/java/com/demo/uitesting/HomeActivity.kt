package com.demo.uitesting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.uitesting.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.extras?.getString("name")
        binding.txtName.text = name

    }
}