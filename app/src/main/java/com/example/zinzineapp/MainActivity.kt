package com.example.zinzineapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_main)
                    // Passage à la page des émissions en cliquant sur le bouton
        val button= findViewById<Button>(R.id.open_emissions)
        button.setOnClickListener {

            startActivity(Intent(applicationContext, Emissions::class.java))
        }
                }
            }
