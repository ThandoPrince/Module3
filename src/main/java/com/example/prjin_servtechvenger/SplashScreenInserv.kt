package com.example.prjin_servtechvenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.coroutines.delay

class SplashScreenInserv : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_inserv)

     handler= Handler()
        handler.postDelayed({
            val intent = Intent(this, WelcomeActivityprjInserv::class.java)
            startActivity(intent)
            finish()

        }, 2000)
    }
}