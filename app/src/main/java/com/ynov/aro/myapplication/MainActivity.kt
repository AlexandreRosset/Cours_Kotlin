package com.ynov.aro.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        var msg = findViewById<EditText>(R.id.MessageAEnvoyer)
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("Message", msg.text.toString())
        startActivity(intent)
    }
}
