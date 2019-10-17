package com.ynov.aro.myapplication

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.telephony.SmsManager
import android.widget.EditText




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val msg = findViewById<EditText>(R.id.MessageAEnvoyer)
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("Message", msg.text.toString())
        startActivity(intent)
    }
    fun UXcours(view: View){

        val intent = Intent(this, drawerActivity::class.java)
        startActivity(intent)
    }
    fun onClickEvent(view: View) {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE), 14540)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults:IntArray){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val msg = findViewById<EditText>(R.id.MessageAEnvoyer)
        if (requestCode == 14540){
            if (grantResults.size == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                val manager = SmsManager.getDefault()
                manager.sendTextMessage("0651678660", null, msg.text.toString(), null, null)
            }
        }
    }
}
