package com.example.todoappwithroom.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todoModel: TodoModel)

    @Insert
    fun insertAll(todoModels: List<TodoModel>)

    @Delete
    fun delete(todoModel: TodoModel)

    @Update
    fun update(todoModel: TodoModel)

    @Query("select * from todomodel where id = :id")
    fun getTodosById(id: Int): TodoModel?
}