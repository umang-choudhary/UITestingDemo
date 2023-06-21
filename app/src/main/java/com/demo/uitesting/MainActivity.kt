package com.demo.uitesting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.uitesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Robolectric
    /*
    -> Have you ever felt boring when you have to run your app for a small little change
    to see it is working fine or not?

    -> If yes then, you must try Robolectric, it is a unit testing framework that
    allows Android applications to be tested on the JVM without an emulator or device.

    -> It provides a way to run our tests inside Android Studio, without launching app on Device
    or Emulator.

    Cons of robolectric:
    -> It does not cover all the functionality a real device or emulator can offer.
    For example sensors, gps, open-gl etc etc.

    -> You'll need an emulator or real device when doing integration or UI testing,
    so that Activities and services can interact with full android environment
    (other apps, like using camera app to get a picture for your app), not a limited one.
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeText.setOnClickListener {
            binding.edtName.setText("Hello Guys")
            binding.txtMsg.text = "Msg Updated"
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            intent.putExtra("name", "Bhavish")
            startActivity(intent)
        }

    }
}