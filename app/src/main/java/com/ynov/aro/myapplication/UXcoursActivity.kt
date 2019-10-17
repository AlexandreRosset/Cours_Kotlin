package com.ynov.aro.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.Toolbar
import android.telephony.SmsManager
import android.view.View
import android.widget.EditText

class UXcoursActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uxcours)
    }
    fun onClickEvent(view: View) {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.READ_PHONE_STATE), 14540)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults:IntArray){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var nom = findViewById<EditText>(R.id.Nom).text.toString()
        var prenom = findViewById<EditText>(R.id.Prenom).text.toString()
        val mail = findViewById<EditText>(R.id.mail).text.toString()
        val portable = findViewById<EditText>(R.id.portable).text.toString()
        nom = verifTaille(nom)
        prenom = verifTaille(prenom)
        if (requestCode == 14540 && android.util.Patterns.EMAIL_ADDRESS.matcher(findViewById<EditText>(R.id.mail).text.toString()).matches() && android.util.Patterns.PHONE.matcher(findViewById<EditText>(R.id.portable).text.toString()).matches()){
            if (grantResults.size == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                val manager = SmsManager.getDefault()
                manager.sendTextMessage("0651678660", null, "$nom:$prenom\n$mail\n$portable", null, null)
            }
        }
    }

    fun verifTaille(str: String):String{
        var tmp = str
        while (tmp.length < 5){
            tmp+="X"
        }
        return tmp
    }
}
