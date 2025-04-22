package com.example.todoappwithroom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todoappwithroom.models.TodoDataBase
import com.example.todoappwithroom.models.TodoModel
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadUI()
    }

    private fun loadUI() {
        val db = TodoDataBase.getDb(this)
//       insert data to db
        thread {
            db.toDoDao().insert(TodoModel(1, "Azamat", "Android Developer"))
            db.toDoDao().insert(TodoModel(2, "Akbar", "Android Developer"))
            db.toDoDao().insert(TodoModel(3, "Izzat", "Android Developer"))
            db.toDoDao().insert(TodoModel(4, "Abror", "Android Developer"))
            db.toDoDao().insert(TodoModel(5, "Akmal", "Android Developer"))
            db.toDoDao().insert(TodoModel(6, "Sunnat", "Android Developer"))
            db.toDoDao().insert(TodoModel(7, "Muhammad", "Android Developer"))
            db.toDoDao().insert(TodoModel(8, "Oybek", "Android Developer"))
            db.toDoDao().insert(TodoModel(9, "Hursand", "Android Developer"))
            db.toDoDao().insert(TodoModel(10, "Akrom", "Android Developer"))
            db.toDoDao().insert(TodoModel(11, "raxmadjon", "Android Developer"))
            db.toDoDao().insert(TodoModel(12, "Sadulla", "Android Developer"))
        }
//       get data by id
        thread {
            val todo = db.toDoDao().getTodosById(1)
            runOnUiThread({
                Toast.makeText(this, "${todo?.title}", Toast.LENGTH_SHORT).show()
            })
        }
    }
}