package com.example.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.intents.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setOnClickListener()
        setStatusBarAppearance(window.decorView.rootView)
    }

    private fun setOnClickListener() {

        //Explicit Intents
        binding.btnIntentWithData.setOnClickListener {
            val intent = Intent(this@HomeActivity, OtherActivityA::class.java)
            intent.putExtra("fname", "Husnain")
            startActivity(intent)
        }

        binding.btnIntentWithBundle.setOnClickListener {
            val intent = Intent(this, OtherActivityA::class.java)
            val bundle = Bundle()
            bundle.putString("key_name", "Hello, this is some data!")
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.btnIntentWithParcelableData.setOnClickListener {
            val intent = Intent(this, OtherActivityA::class.java)
            val person = Person("Person")
            intent.putExtra("person", person)
            startActivity(intent)
        }

        binding.btnIntentWithSerializableData.setOnClickListener {
            val intent = Intent(this@HomeActivity, OtherActivityA::class.java)
            val data = Data(1)
            intent.putExtra("data", data)
            startActivity(intent)
        }

        //Implicit Intent's

        binding.btnOpenUrl.setOnClickListener {
            Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.google.com/")
                startActivity(this)
            }
        }

        binding.btnShareText.setOnClickListener {
            val text = "Name =  Husnain\nPhone = 03463752125"
            Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(this, "Share With"))
            }
        }
    }


}
