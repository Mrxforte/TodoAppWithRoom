package com.example.todoappwithroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "reja", primaryKeys = ["name", "isDone"])
data class ToDo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nomi") val title: String,
    val description: String?,
    val date: String?,
    @Ignore val ignoreData: String?,
    val isDone: Boolean?,
)
