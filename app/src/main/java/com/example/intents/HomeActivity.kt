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
            val intent = Intent(this@HomeActivity, OtherActivityA::class.java)
            val bundle = Bundle()
            bundle.putString("fullName", "Husnain Ali Rafique")
            bundle.putInt("chack", 125)
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
            intent.putExtra("datakey",data)
            startActivity(intent)
        }

        //Implicit Intent's

        binding.btnOpenUrl.setOnClickListener {
            val intent = Intent()
                .setAction(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://www.google.com/"))
            val chooser = Intent.createChooser(intent, "Open With")
            startActivity(chooser)
        }
        binding.btnOpenDialer.setOnClickListener {

        }
        binding.btnShareText.setOnClickListener {
            val text = "Name =  Husnain\nPhone = 03463752125"
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,text  )
            startActivity(Intent.createChooser(intent, "Share With"))
        }
    }


}
