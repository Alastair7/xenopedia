package com.example.xenopedia.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xenopedia.Entidad.Frase
import com.example.xenopedia.R
import com.example.xenopedia.adapters.FrasesAdapter
import com.example.xenopedia.models.FraseViewModel
import kotlinx.android.synthetic.main.activity_index.*

class IndexActivity : AppCompatActivity() {
    private lateinit var viewModel: FraseViewModel
    private var isAddMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val addFraseButton : Button= findViewById(R.id.frases_add_bttn)
        val adapter = FrasesAdapter()


        frases_recyclerview.adapter = adapter
        frases_recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(FraseViewModel::class.java)
        viewModel.readAllFrases.observe(this,{frase -> adapter.setFrases(frase)})



        addFraseButton.setOnClickListener {
            isAddMode = true
            val intent = Intent(this, Addfrase::class.java).apply {
                putExtra("activityMode", isAddMode)

            }
            startActivity(intent)
        }

        adapter.onEditClick = {frase -> goToAddFrase(frase)}
        adapter.onDeleteClick = {frase -> viewModel.deleteFrase(frase)}
        adapter.onItemClick = {frase -> goToInfoFrase(frase)}
        }

    private fun goToAddFrase(frase: Frase){
        intent = Intent(this, Addfrase::class.java).apply {
            putExtra("frase", frase)
        }
        startActivity(intent)
    }

    private fun goToInfoFrase(frase: Frase){
        intent = Intent(this, InfoActivity::class.java).apply {
            putExtra("frase", frase)
        }
        startActivity(intent)
    }
}
