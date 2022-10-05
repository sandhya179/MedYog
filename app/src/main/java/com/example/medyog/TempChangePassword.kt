package com.example.medyog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.medyog.databinding.ActivityChangePasswordBinding
import com.example.medyog.databinding.ActivityTempChangePasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class TempChangePassword : AppCompatActivity() {

    private lateinit var binding : ActivityTempChangePasswordBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private val user = Firebase.auth.currentUser

    val newPassword = binding.etNewPassword
    val newConfirmPassword = binding.etConfirmPassword

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTempChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangePassword.setOnClickListener {
            if(newPassword.text.toString().trim() == newConfirmPassword.text.toString().trim()) {
                user!!.updatePassword(newPassword.text.toString()).addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        changeDatabasePassword(user.uid, newPassword.text.toString())
                        Toast.makeText(this, "Information Updated Successfully for pass ", Toast.LENGTH_LONG)
                            .show()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Andha he kya thik se type ker", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun changeDatabasePassword(userID:String, password: String) {
        database.reference.child("users").child(userID).child("pass").setValue(password)

    }
}