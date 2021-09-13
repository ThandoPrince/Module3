package com.example.prjin_servtechvenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class AccountSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_selection)
        val btnNext = findViewById<Button>(R.id.btnNext_SelectAcc)
        val rdoClient = findViewById<RadioButton>(R.id.rdoClient)
        val rdoGroup = findViewById<RadioGroup>(R.id.Group1)
        val rdoServProvider = findViewById<RadioButton>(R.id.rdoService_Provider)

        fun onSerButtonClicked(view: View) {
            if (view is Button) {
                val clicked = view.isClickable
                when (view.getId()) {
                    R.id.btnNext_SelectAcc ->
                if (clicked=true) {
            if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
            R.id.rdoClient ->
            if (checked) {
            btnNext.setOnClickListener {
            val intent1 = Intent(this, ClientPersonalDet::class.java)
            startActivity(intent1)
                                            }
                                        }}}}}}}
        fun onCliButtonClicked(view: View) {
            if (view is Button) {
                val clicked = view.isClickable
                when (view.getId()) {
                    R.id.btnNext_SelectAcc ->
                        if (clicked = true) {
                            if (view is RadioButton) {
                                val checked = view.isChecked
                                when (view.getId()) {
                                    R.id.rdoService_Provider ->
                                        if (checked) {
                                            btnNext.setOnClickListener {
                                                val intent2 = Intent(
                                                    this, ServProviderPersonalDetails::class.java
                                                )
                                                startActivity(intent2)
                                            } }
                                }}}}}}}}
