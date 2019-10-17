package com.ynov.aro.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_page2.*
import java.io.File
import java.nio.file.Path


class Page2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        val intent = intent
        var pseudo = intent.getStringExtra("Pseudo").toString()
        var message = intent.getStringExtra("Message").toString()
        val path = this@Page2.getExternalFilesDir(null)
        val f = File(path, "data.txt")
        f.createNewFile()
        f.appendText("$pseudo : $message" + System.getProperty("line.separator"))
        var nbLine = 0
        f.forEachLine {
            nbLine++
        }
        val listItems = arrayOfNulls<String>(nbLine)
        var compteur = 0
        f.forEachLine {
            println(it)
            listItems[compteur] = it
            compteur++
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listeMessage.adapter = adapter

    }
}
