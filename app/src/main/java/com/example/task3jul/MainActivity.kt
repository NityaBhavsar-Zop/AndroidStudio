package com.example.task3jul

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

data class User(val id: String, val name: String, val phone: String)

class MainActivity : AppCompatActivity() {

    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userID: EditText = findViewById(R.id.userid)
        val userName: EditText = findViewById(R.id.userName)
        val userPhone: EditText = findViewById(R.id.userPhone)

        val addUser: Button = findViewById(R.id.addBtn)
        val userSearch: Button = findViewById(R.id.viewBtn)
        lateinit var id1: String
        addUser.setOnClickListener {
            val id = userID.text.toString()
            id1 = id
            val name = userName.text.toString()
            val phone = userPhone.text.toString()

            if (id.isNotEmpty() && name.isNotEmpty() && phone.isNotEmpty()) {
                val user = User(id, name, phone)
                userList.add(user)
                userID.text.clear()
                userName.text.clear()
                userPhone.text.clear()

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Success")
                builder.setMessage("User added successfully!")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("Please fill all fields")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }

        userSearch.setOnClickListener {
            val search:EditText = findViewById(R.id.userSearch)
            val search1 = search.text.toString()
            if (search1 == id1) {
                val lastUser = userList.last()
                val intent = Intent(this, Main2Activity::class.java).apply {
                    putExtra("USER_ID", lastUser.id)
                    putExtra("USER_NAME", lastUser.name)
                    putExtra("USER_PHONE", lastUser.phone)
                }
                startActivity(intent)
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("No users available to view")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }
    }
}