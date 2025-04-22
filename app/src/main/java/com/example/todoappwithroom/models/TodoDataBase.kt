package com.example.todoappwithroom.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoModel::class], exportSchema = false, version = 1)
abstract class TodoDataBase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

    companion object {
        private var myDb: TodoDataBase? = null
        fun getDb(context: Context): TodoDataBase {
            return myDb ?: Room.databaseBuilder(
                context.applicationContext,
                TodoDataBase::class.java,
                "myDb"
            ).build()
        }
    }
}