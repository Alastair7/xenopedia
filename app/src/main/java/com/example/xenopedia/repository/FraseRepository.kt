package com.example.xenopedia.repository

import androidx.lifecycle.LiveData
import com.example.xenopedia.DAO.FraseDao
import com.example.xenopedia.Entidad.Frase

class FraseRepository(private val fraseDao: FraseDao) {
    suspend fun addFrase(frase: Frase){
        fraseDao.insertFrase(frase)
    }

    val readAllFrases: LiveData<List<Frase>> = fraseDao.getAllFrases()

    suspend fun updateFrase(frase: Frase){
        fraseDao.updateFrase(frase)
    }

    suspend fun deleteFrase(frase: Frase){
        fraseDao.deleteFrase(frase)
    }
}