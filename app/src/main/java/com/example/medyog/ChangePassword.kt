package com.example.medyog

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.medyog.databinding.ActivityChangePasswordBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


private lateinit var binding : ActivityChangePasswordBinding
private lateinit var auth : FirebaseAuth
private lateinit var database: FirebaseDatabase
private val user = Firebase.auth.currentUser


class ChangePassword : AppCompatActivity() {

    val newPassword = binding.etNewPassword
    val newConfirmPassword = binding.etConfirmPassword


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val changeBtn = findViewById<Button>(R.id.btn_change_password)
        changeBtn.setOnClickListener {
            changePass()
        }
//        binding.btnChangePassword.setOnClickListener {
//            change()
//        }
    }

    fun changePass() {
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

    fun changeDatabasePassword(userID:String, password: String) {
        database.reference.child("users").child(userID).child("pass").setValue(password)

    }

//    private fun change() {
//
//        if (currentPass.isNotEmpty() &&
//            newPass.isNotEmpty() &&
//            confirmPass.isNotEmpty()
//        ) {
//            if (newPass == confirmPass){
//                val user : FirebaseUser? = auth.currentUser
//                if(user != null && user.email != null){
//                    val credential = EmailAuthProvider
//                        .getCredential(user.email !!, currentPass)
//
//// Prompt the user to re-provide their sign-in credentials
//                    user.reauthenticate(credential)
//                        .addOnCompleteListener {
//                            if(it.isSuccessful){
//                                Toast.makeText(this," Re-Authentication Success", Toast.LENGTH_SHORT).show()
//                                user!!.updatePassword(newPass)
//                                    .addOnCompleteListener { task ->
//                                        if (task.isSuccessful) {
//                                            Toast.makeText(this,"Password Changed Successfully", Toast.LENGTH_SHORT).show()
//                                            auth.signOut()
//                                            val intent = Intent (this, Login::class.java)
//                                            startActivity(intent)
//                                            finish()
//                                        }
//                                    }
//
//                            }else{
//                                Toast.makeText(this," Re-Authentication Failed", Toast.LENGTH_SHORT).show()
//                            }
//                        }
//
//                }else{
//                    val intent = Intent (this, Login::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//            }else{
//                Toast.makeText(this,"Password mismatching", Toast.LENGTH_SHORT).show()
//            }
//
//            } else {
//            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()
//        }
//
//    }
}
