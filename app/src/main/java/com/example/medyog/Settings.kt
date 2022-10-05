package com.example.medyog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Settings : AppCompatActivity() {
    private lateinit var logout:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        logout = findViewById(R.id.Logout)
        logout.setOnClickListener{
            Firebase.auth.signOut()

            val intent = Intent(this, Login::class.java)
            startActivity(intent)

            Toast.makeText(this,"LogOut successfully", Toast.LENGTH_LONG).show()
        }


      val  deleteBtn = findViewById<Button>(R.id.deleteAccount)
        deleteBtn.setOnClickListener{
            val intent = Intent(this,AccountDelete::class.java)
            startActivity(intent)
        }

        val changeBtn = findViewById<Button>(R.id.change)
        changeBtn.setOnClickListener{
            val intent = Intent( this, TempChangePassword::class.java)
            startActivity(intent)
        }

    }
}