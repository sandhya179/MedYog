package com.example.medyog

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountDelete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_delete)
        val user = Firebase.auth.currentUser!!


        val deleteBtn = findViewById<Button>(R.id.Delete)
        deleteBtn.setOnClickListener {
            user.delete()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this," Account Deleted", Toast.LENGTH_SHORT).show()
                        val intent = Intent (this, SignUp::class.java)
                        startActivity(intent)
                        finish()
                    }
                }


        }
    }
}