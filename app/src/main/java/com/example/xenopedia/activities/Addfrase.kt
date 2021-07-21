package com.example.xenopedia.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xenopedia.Entidad.Frase
import com.example.xenopedia.R
import com.example.xenopedia.models.FraseViewModel

class Addfrase : AppCompatActivity() {
    private lateinit var fraseViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addfrase)

        // Show previous button in an Action Bar
        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)
        actionBar.setDisplayHomeAsUpEnabled(true)

        // get add or edit mode
        val isAddMode = intent.getBooleanExtra("activityMode", false)

        fraseViewModel = ViewModelProvider(this).get(FraseViewModel::class.java)

        val inputFraseTitle : EditText = findViewById(R.id.frase_titulo_input)
        val inputFraseAutor : EditText = findViewById(R.id.frase_autor_input)
        val inputFraseTexto : EditText = findViewById(R.id.frase_texto_input)
        val addBttn: Button = findViewById(R.id.add_bttn)
        val titleTv: TextView = findViewById(R.id.addFrase_text)

        // Using same layout for different options
        if(isAddMode) {
            // Add Text
            titleTv.text = getString(R.string.add_frase_title)
            addBttn.text = getString(R.string.add_frase_bttn_text)


            addBttn.setOnClickListener {

                val frase = Frase(
                    0,
                    inputFraseTitle.text.toString(),
                    inputFraseAutor.text.toString(),
                    inputFraseTexto.text.toString()
                )
                (fraseViewModel as FraseViewModel).addFrase(frase)
                finish()

            }
        }else{
            // Edit Text
            titleTv.text = getString(R.string.edit_frase_title)
            addBttn.text = getString(R.string.edit_frase_bttn_text)

            val frase : Frase = intent.getSerializableExtra("frase") as Frase

                inputFraseTitle.setText(frase.titulo)
                inputFraseAutor.setText(frase.autor)
                inputFraseTexto.setText(frase.texto)

            addBttn.setOnClickListener{
                val fraseEditada = Frase(frase.id,
                    inputFraseTitle.text.toString(),
                    inputFraseAutor.text.toString(),
                    inputFraseTexto.text.toString())

                (fraseViewModel as FraseViewModel).updateFrase(fraseEditada)
                finish()
            }
        }
    }
}