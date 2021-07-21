package com.example.xenopedia.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.xenopedia.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToIndexBttn : Button = findViewById(R.id.login_bttn)

        goToIndexBttn.setOnClickListener{
            val intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)

        }
    }


}