package com.example.prjin_servtechvenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prjin_servtechvenger.ui.login.Auth_In_Serv_Activity

class WelcomeActivityprjInserv : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_activityprj_inserv)
        val button = findViewById<Button>(R.id.btnPressStart)
        button.setOnClickListener {
            val intent = Intent(this, AccountSelection::class.java)
            startActivity(intent)
        }
        }
    }

