package com.example.todoappwithroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface ToDoDao1 {
    //    simple data insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(toDo: ToDo)

    //    Simple inserting the todo list of datas
    @Insert
    fun insertAll(todoList: List<ToDo>)

    //    simple deleting the todo daos
    @Delete
    fun delete(toDo: ToDo)

    //    simple updating the daos
    @Update
    fun update(toDo: ToDo)
}