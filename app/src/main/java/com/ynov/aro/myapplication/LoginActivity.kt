package com.ynov.aro.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun sendMessage(view: View) {
        var psd = findViewById<EditText>(R.id.pseudo)
        var intent = intent
        var msg = intent.getStringExtra("Message").toString()
        intent = Intent(this, Page2::class.java)
        intent.putExtra("Message", msg)
        intent.putExtra("Pseudo", psd.text.toString())
        startActivity(intent)
    }
}
