package com.example.task3jul

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val backButton: Button = findViewById(R.id.closeBtn)
        backButton.setOnClickListener {
            finish()
        }

        val displayID: EditText = findViewById(R.id.idDisplay)
        val displayName: EditText = findViewById(R.id.nameDisplay)
        val displayPhone: EditText = findViewById(R.id.phoneDisplay)

        // Receiving data from MainActivity
        val userID = intent.getStringExtra("USER_ID")
        val userName = intent.getStringExtra("USER_NAME")
        val userPhone = intent.getStringExtra("USER_PHONE")

        displayID.setText(userID)
        displayName.setText(userName)
        displayPhone.setText(userPhone)
    }
}
