package com.nazartaraniuk.unsplashtesttask

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nazartaraniuk.unsplashtesttask.presentation.main_screen.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}