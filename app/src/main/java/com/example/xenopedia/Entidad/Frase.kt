package com.example.xenopedia.Entidad

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "frases")
data class Frase(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    val titulo: String,
    @ColumnInfo
    val autor: String,
    @ColumnInfo
    val texto: String) : Serializable