package com.example.xenopedia.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.xenopedia.Entidad.Frase
import com.example.xenopedia.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        // Previous button in action bar
        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val fraseTitle : TextView = findViewById(R.id.info_fase_title)
        val fraseAutor : TextView = findViewById(R.id.info_frase_autor)
        val fraseTexto : TextView = findViewById(R.id.info_frase_text)
        val copyBttn : Button = findViewById(R.id.copy_bttn)

        val frase : Frase = intent.getSerializableExtra("frase") as Frase

        fraseTitle.text = frase.titulo
        fraseAutor.text = frase.autor
        fraseTexto.text = frase.texto

        copyBttn.setOnClickListener{
            copyFraseToClipboad(fraseTexto)
        }




    }

    private fun copyFraseToClipboad(texto : TextView){
        val fraseToCopy = texto.text
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", fraseToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(this, "Frase copiada!", Toast.LENGTH_LONG).show()
    }
}