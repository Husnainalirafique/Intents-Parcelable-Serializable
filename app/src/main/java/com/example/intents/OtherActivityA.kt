package com.example.intents

import android.os.Build
import android.os.Build.VERSION
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.intents.databinding.ActivityOtherActivityBinding
import com.google.android.material.snackbar.Snackbar

//@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class OtherActivityA : AppCompatActivity() {
    private lateinit var binding: ActivityOtherActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_other_activity)

        setStatusBarAppearance(window.decorView.rootView)
        gettingDataFromHomeActivity()
    }


    private fun gettingDataFromHomeActivity() {
        receivingBundleData()
        receivingSimpleIntent()
        receivingParcelableIntent()
        receivingSerializableData()
    }
    private fun receivingBundleData(){
        val bundle = intent.extras
        val name = bundle?.getString("key_name")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

    }
    private fun receivingSimpleIntent() {
        val receivedIntent = intent
        val name1 = receivedIntent.getStringExtra("fname")
        name1?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun receivingParcelableIntent() {
        val person = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("person", Person::class.java)
        } else {
            TODO()
        }
        person?.let {
            val snackbar = Snackbar.make(window.decorView, "parcelize data = ${it.name}", Snackbar.LENGTH_SHORT).show()
        }
    }


    private fun receivingSerializableData() {
        val value = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("data", Data::class.java)
        } else {
            TODO()
        }
        value?.let {
            val snackbar = Snackbar.make(window.decorView, "Serialized data = ${it.id}", Snackbar.LENGTH_SHORT).show()
        }
    }
}




