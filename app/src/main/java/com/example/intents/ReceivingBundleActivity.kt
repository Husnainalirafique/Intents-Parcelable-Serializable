package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ReceivingBundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiving_bundle)
        val bundle  = intent.extras
        bundle?.let {
            val name = it.getString("key_name")
            Toast.makeText(this@ReceivingBundleActivity, name, Toast.LENGTH_SHORT).show()
        }
    }
}