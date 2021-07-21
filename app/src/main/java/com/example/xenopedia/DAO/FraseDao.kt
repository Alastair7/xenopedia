package com.example.xenopedia.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.xenopedia.Entidad.Frase


@Dao
interface FraseDao {

    @Query("SELECT * FROM frases ORDER BY id ASC")
    fun getAllFrases(): LiveData<List<Frase>>


    @Update
    suspend fun updateFrase(frase:Frase)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insertFrase(frase: Frase)

    @Delete
    suspend fun deleteFrase(frase: Frase)

}