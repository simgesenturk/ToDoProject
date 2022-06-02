package com.simgesenturk.todoapp3

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.button)
        val deleteButton = findViewById<Button>(R.id.button2)
        val linLay = findViewById<LinearLayout>(R.id.ll)

        addButton.setOnClickListener{
            saveTasks()
        }

        deleteButton.setOnClickListener{
            linLay.removeAllViews()
        }

    }

    private fun saveTasks() {
        val linearLayout = findViewById<LinearLayout>(R.id.ll)
        val taskEditText = findViewById<EditText>(R.id.userInput)
        val task = taskEditText.text.toString()
        val checkBx = CheckBox(this)
        checkBx.setButtonTintList(getColorStateList(R.color.orange))
        checkBx.setTextSize(20f)
        checkBx.setTextColor(getColorStateList(R.color.white))
        if(task.isNotEmpty()){
            checkBx.text= "$task"
            taskEditText.getText().clear()
            linearLayout.addView(checkBx)
        } else
            Toast.makeText(this, "You didn't enter any task detail", Toast.LENGTH_SHORT).show()
    }


}