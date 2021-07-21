package com.example.xenopedia


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.xenopedia.DAO.FraseDao
import com.example.xenopedia.DB.XenopediaDB
import com.example.xenopedia.Entidad.Frase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class FrasesDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: XenopediaDB
    private lateinit var dao: FraseDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            XenopediaDB::class.java
        ).allowMainThreadQueries().build()

        dao = database.fraseDAO()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertFrase() = runBlocking{
        val frase = Frase(0, "Titulo1", "Autor1", "MuchoTexto")
        dao.insertFrase(frase)

        val allFrases = dao.getAllFrases().getOrAwaitValue()

        assert(allFrases.contains(frase))
    }
}