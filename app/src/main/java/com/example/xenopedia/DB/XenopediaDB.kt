package com.example.xenopedia.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xenopedia.DAO.FraseDao
import com.example.xenopedia.Entidad.Frase

@Database(entities = [Frase::class], version = 1)
abstract class XenopediaDB : RoomDatabase() {

    abstract fun fraseDAO():FraseDao


    // Singleton Model
    companion object{
        @Volatile
        private var INSTANCE:XenopediaDB? = null

        fun getDB(context: Context): XenopediaDB{
            val instance = INSTANCE
            if(instance!=null){
                return instance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, XenopediaDB::class.java, "XenopediaDB"
                ).build()

                INSTANCE = instance
                return instance
            }
        }

    }

}

