package com.example.xenopedia.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.xenopedia.DB.XenopediaDB
import com.example.xenopedia.Entidad.Frase
import com.example.xenopedia.repository.FraseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FraseViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FraseRepository
    val readAllFrases:LiveData<List<Frase>>

    init{
        val fraseDao = XenopediaDB.getDB(application).fraseDAO()
        repository = FraseRepository(fraseDao)
        readAllFrases = repository.readAllFrases
    }
    fun addFrase(frase: Frase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFrase(frase)
        }
    }

    fun updateFrase(frase: Frase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFrase(frase)
        }
    }

    fun deleteFrase(frase: Frase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFrase(frase)
        }
    }
}